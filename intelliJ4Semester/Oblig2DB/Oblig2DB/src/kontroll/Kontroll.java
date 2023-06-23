package kontroll;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

import domeneklasser.Faktura;
import domeneklasser.Fakturalinje;
import domeneklasser.Firmakunde;
import domeneklasser.Kunde;
import domeneklasser.Kundekontakt;
import domeneklasser.Privatkunde;
import domeneklasser.Vare;
import hjelpeklasser.Filbehandling;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class Kontroll {
	Filbehandling filbehanding = new Filbehandling();
	public TreeMap<String, Vare> vareliste = new TreeMap<>();
	public HashMap<String, Privatkunde> privatkundeliste = new HashMap<>();
	public HashMap<String, Firmakunde> firmakundeliste = new HashMap<>();
	private TreeMap<String, Kundekontakt> kontaktliste = new TreeMap<>();
	private TreeMap<String, Fakturalinje> fakturalinjeliste = new TreeMap<>();
	private ArrayList<Vare> data = new ArrayList<Vare>();
	private ArrayList<Privatkunde> privatkundeData = new ArrayList<Privatkunde>();
	private ArrayList<Firmakunde> firmakundeData = new ArrayList<Firmakunde>();
	private ArrayList<Kundekontakt> kontaktData = new ArrayList<Kundekontakt>();
	private ArrayList<Fakturalinje> fakturalinjeData = new ArrayList<Fakturalinje>();
	private ArrayList<Kunde> kundeData = new ArrayList<>();
	private ArrayList<Faktura> fakturaData = new ArrayList<>();
	
	

	//Lister
	public TreeMap<String, Vare> getTreeVare() {
		return vareliste;
	}
	
	public HashMap<String, Privatkunde> getHashPrivatkunde() {
		return privatkundeliste;
	}
	
	public HashMap<String, Firmakunde> getHashFirmakunde() {
		return firmakundeliste;
	}
	public TreeMap<String, Kundekontakt> getTreeKundekontakt() {
		return kontaktliste;
	}
	
	public TreeMap<String, Fakturalinje> getTreeFakturalinje() {
		return fakturalinjeliste;
	}
	
	public ArrayList<Vare> getListVarer() {
		return data;
	}
	
	public ArrayList<Fakturalinje> getListLinja() {
		return fakturalinjeData;
	}
	
	public ArrayList<Privatkunde> getListPrivatkunder() {
		return privatkundeData;
	}
	
	public ArrayList<Firmakunde> getListFirmakunder() {
		return firmakundeData;
	}
	
	public ArrayList<Kundekontakt> getListKundekontakt() {
		return kontaktData;
	}
	
	public ArrayList<Kunde> getKunde() {
		return kundeData;
	}
	
	public ArrayList<Faktura> getFaktura() {
		System.out.println("1"+fakturaData);
		
		return fakturaData;
	}
	//Lister slutt
	
	/*public Vare finnVare(String varenr) {
		Vare vare = vareliste.get(varenr);
		if(vare!=null) return vare;
		else return null;
	}*/
	
	/*public void slettVare(String varenr) {
		vareliste.remove(varenr);
	}*/
	
	//Vare start
	public void nyVare(String varenr, Vare vare) {
		vareliste.put(varenr, vare);
	}
	public void skrivData (String filnavn) {
		try {
			PrintWriter utfil = Filbehandling.lagSkriveforbindelse(filnavn);
			for(Vare vare : vareliste.values()) {
				utfil.println(vare.toFile());
			}
			utfil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void removeDataArray() {
		data.clear();
	}
	
	public void removeDataTree() {
		vareliste.clear();
	}
	
	public ArrayList<Vare> lesData (String filnavn) {
		try {
			removeDataArray();
			BufferedReader innfil = Filbehandling.lagLeseforbindelse(filnavn);
			String linje = innfil.readLine();
			while(linje!=null) {
				StringTokenizer innhold = new StringTokenizer(linje,";");
				String varenr = innhold.nextToken();
				String varenavn = innhold.nextToken();
				String varepris = innhold.nextToken();
				data.add(new Vare(varenr,varenavn,varepris));
				linje = innfil.readLine();
			}
			innfil.close();
		} catch(Exception e) {}
		return data;
	}
	
	public Vare finnVare(String varenr) {
		Vare vare = null;
		boolean funnet = false;
		int teller = 0;
		while(!funnet) {
			vare = data.get(teller);
			if(varenr.equals(vare.getVarenr()))
				funnet = true;
			else teller++;
		}
		return vare;
	}
	//Varer Slutt
	
	
	//Kunde Start
	public void nyPrivatkunde(String kundenr, Privatkunde privatkunde) {
		privatkundeliste.put(kundenr, privatkunde);
	}
	
	public void skrivDataPrivatkunde (String filnavn) {
		try {
			PrintWriter utfil = Filbehandling.lagSkriveforbindelse(filnavn);
			for(Privatkunde privatkunde : privatkundeliste.values()) {
				utfil.println(privatkunde.toFile());
			}
			utfil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void removePrivatkundeDataArray() {
		privatkundeData.clear();
	}
	
	public void removePrivatkundeDataHash() {
		privatkundeliste.clear();
	}
	public ArrayList<Privatkunde> lesPrivatkundeData (String filnavn) {
		try {
			removePrivatkundeDataArray();
			removeKundeDataArray();
			BufferedReader innfil = Filbehandling.lagLeseforbindelse(filnavn);
			String linje = innfil.readLine();
			while(linje!=null) {
				StringTokenizer innhold = new StringTokenizer(linje,";");
				String kundenr = innhold.nextToken();
				String kundenavn = innhold.nextToken();
				String kundebutikk = innhold.nextToken();
				privatkundeData.add(new Privatkunde(kundenr,kundenavn,kundebutikk));
				linje = innfil.readLine();
			}
			innfil.close();
		} catch(Exception e) {}
		return privatkundeData;
	}
	
	public void nyFirmakunde(String kundenr, Firmakunde firmakunde) {
		firmakundeliste.put(kundenr, firmakunde);
	}
	
	public void skrivDataFirmakunde (String filnavn) {
		try {
			PrintWriter utfil = Filbehandling.lagSkriveforbindelse(filnavn);
			for(Firmakunde firmakunde : firmakundeliste.values()) {
				utfil.println(firmakunde.toFile());
			}
			utfil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void removeFirmakundeDataArray() {
		firmakundeData.clear();
	}
	
	public void removeFirmakundeDataHash() {
		firmakundeliste.clear();
	}
	public ArrayList<Firmakunde> lesFirmakundeData (String filnavn) {
		try {
			removeFirmakundeDataArray();
			removeKundeDataArray();
			BufferedReader innfil = Filbehandling.lagLeseforbindelse(filnavn);
			String linje = innfil.readLine();
			while(linje!=null) {
				StringTokenizer innhold = new StringTokenizer(linje,";");
				String kundenr = innhold.nextToken();
				String kundenavn = innhold.nextToken();
				String kundekredittgrense = innhold.nextToken();
				String kundetelefon = innhold.nextToken();
				firmakundeData.add(new Firmakunde(kundenr,kundenavn,kundekredittgrense,kundetelefon));
				linje = innfil.readLine();
			}
			innfil.close();
		} catch(Exception e) {}
		return firmakundeData;
	}
	
	public void removeKundeDataArray() {
		kundeData.clear();
	}
	
	public ArrayList<Kunde> lesAlleKunder() {
		removeKundeDataArray();
		try {
			BufferedReader innfilPrivatkunde = Filbehandling.lagLeseforbindelse("privatkundefil.txt");
			String linjePrivatkunde = innfilPrivatkunde.readLine();
			while(linjePrivatkunde!=null) {
				StringTokenizer innhold = new StringTokenizer(linjePrivatkunde, ";");
				String kundenr = innhold.nextToken();
				String kundenavn = innhold.nextToken();
				String butikk = innhold.nextToken();
				Privatkunde privatkunde = new Privatkunde(kundenr,kundenavn,butikk);
				kundeData.add(privatkunde);
				linjePrivatkunde = innfilPrivatkunde.readLine();
			} innfilPrivatkunde.close();
			
			
			BufferedReader innfilFirmakunde = Filbehandling.lagLeseforbindelse("firmakundefil.txt");
			String linjeFirmakunde = innfilFirmakunde.readLine();
			while(linjeFirmakunde!=null) {
				StringTokenizer innhold = new StringTokenizer(linjeFirmakunde, ";");
				String kundenr = innhold.nextToken();
				String kundenavn = innhold.nextToken();
				String kreditt = innhold.nextToken();
				String kundetlf = innhold.nextToken();
				Firmakunde firmakunde = new Firmakunde(kundenr,kundenavn,kreditt,kundetlf);
				kundeData.add(firmakunde);
				linjeFirmakunde = innfilFirmakunde.readLine();
			} innfilFirmakunde.close();
		} catch (Exception e) {}
		
		
		return kundeData;
	}
	
	public Kunde finnKunde(String kundenummer) {
			Kunde kunde = null;
			boolean funnet = false;
			int teller = 0;
			//getKunde();
			while(!funnet) {
				kunde = kundeData.get(teller);
				if(kundenummer.equals(kunde.getKundenummer()))
					funnet = true;
				else teller++;
			}
			return kunde;
	}

		/*String setKundenavn = null;
		try {
			BufferedReader innfilPrivatkunde = Filbehandling.lagLeseforbindelse("privatkundefil.txt");
			String linjePrivatkunde = innfilPrivatkunde.readLine();
			while(linjePrivatkunde!=null) {
				StringTokenizer innhold = new StringTokenizer(linjePrivatkunde, ";");
				String kundenr = innhold.nextToken();
				if(kundenummer.equals(kundenr)) {
					String kundenavn = innhold.nextToken();
					setKundenavn = kundenavn;
					linjePrivatkunde=null;
					return setKundenavn;
					
				} else {
				String kundenavn = innhold.nextToken();
				String butikk = innhold.nextToken();
				linjePrivatkunde = innfilPrivatkunde.readLine();
			} innfilPrivatkunde.close();
		}
			
			BufferedReader innfilFirmakunde = Filbehandling.lagLeseforbindelse("firmakundefil.txt");
			String linjeFirmakunde = innfilFirmakunde.readLine();
			while(linjeFirmakunde!=null) {
				StringTokenizer innhold = new StringTokenizer(linjeFirmakunde, ";");
				String kundenr = innhold.nextToken();
				if (kundenummer.equals(kundenr)) {
					String kundenavn = innhold.nextToken();
					setKundenavn = kundenavn;
					linjeFirmakunde=null;
					return setKundenavn;
				} else {
				
				String kreditt = innhold.nextToken();
				String kundetlf = innhold.nextToken();
				linjeFirmakunde = innfilFirmakunde.readLine();
			} innfilFirmakunde.close();
		}
	} catch (Exception e) {}
		
		return setKundenavn;
		*/


	//Kunde slutt
	//Kontakt start

	public void removeKontaktDataTree() {
		kontaktliste.clear();
	}
	
	public void removeKontaktDataArray() {
		kontaktData.clear();
	}
	
	public ArrayList<Kundekontakt>lesKundekontakt(String filnavn) {
		try {
			removeKontaktDataArray();
			BufferedReader innfil = Filbehandling.lagLeseforbindelse(filnavn);
			String linje = innfil.readLine();
			while(linje!=null) {
				StringTokenizer innhold = new StringTokenizer(linje,";");
				String kundenr = innhold.nextToken();
				String dato = innhold.nextToken();
				String kontakt = innhold.nextToken();
				kontaktData.add(new Kundekontakt(kundenr,dato,kontakt));
				linje = innfil.readLine();
			}
			innfil.close();
		} catch(Exception e) {}
		return kontaktData;
		
	}
	
	public void skrivDataKontakt (String filnavn) {
		try {
			PrintWriter utfil = Filbehandling.lagSkriveforbindelse(filnavn);
			for(Kundekontakt kundekontakt : kontaktliste.values()) {
				utfil.println(kundekontakt.toFile());
			}
			utfil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void nyKontakt(String kundenr, Kundekontakt kundekontakt) {
		kontaktliste.put(kundenr, kundekontakt);
	}
	
	
	//Faktura start
	
	public void nyFaktura(Faktura faktura) {
		fakturaData.add(faktura);
	}
	public void removeFakturaData() {
		fakturaData.clear();
	}
	
	public void skrivFakturaData (String filnavn) {
		try {
			PrintWriter utfil = Filbehandling.lagSkriveforbindelse(filnavn);
			for(Faktura faktura : fakturaData) {
				utfil.println(faktura.toFile());
			}
			utfil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Faktura>lesFaktura(String filnavn) {
		try {
			removeFakturaData();
			BufferedReader innfil = Filbehandling.lagLeseforbindelse(filnavn);
			String linje = innfil.readLine();
			while(linje!=null) {
				StringTokenizer innhold = new StringTokenizer(linje,";");
				String fakturanr = innhold.nextToken();
				String kundenr = innhold.nextToken();
				String kundenavn = innhold.nextToken();
				String dato = innhold.nextToken();
				String forfall = innhold.nextToken();
				String varenr = innhold.nextToken();
				String varenavn = innhold.nextToken();
				String varepris = innhold.nextToken();
				String linjeAntall = innhold.nextToken();
				String linjeRabatt = innhold.nextToken();
				String linjeTotPris = innhold.nextToken();
				int intFakturanr = Integer.parseInt(fakturanr);
				int intLinjeAntall = Integer.parseInt(linjeAntall);
				float floatLinjeRabatt = Float.parseFloat(linjeRabatt);
				float floatLinjeTotPris = Float.parseFloat(linjeTotPris);
				Vare vare = new Vare(varenr,varenavn,varepris);
				Fakturalinje fakturalinje = new Fakturalinje(vare,intLinjeAntall,floatLinjeRabatt,floatLinjeTotPris);
				Kunde kunde = new Kunde(kundenr,kundenavn);
				Faktura faktura = new Faktura(intFakturanr,kunde,dato,forfall,fakturalinje);
				fakturaData.add(faktura);
				linje = innfil.readLine();
				
			}
			innfil.close();
		} catch(Exception e) {}
		return fakturaData;
		
	}
	
	public void skrivDataFakturalinje (String filnavn) {
		try {
			PrintWriter utfil = Filbehandling.lagSkriveforbindelse(filnavn);
			for(Fakturalinje fakturalinje : fakturalinjeData) {
				utfil.println(fakturalinje.toFile());
			}
			utfil.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeFakturalinjeArray() {
		fakturalinjeData.clear();
	}
	
	public void nyFakturalinje(Fakturalinje fakturalinje) {
		fakturalinjeData.add(fakturalinje);
	}
	
	public ArrayList<Fakturalinje>lesFakturalinje(String filnavn) {
		try {
			removeFakturalinjeArray();
			BufferedReader innfil = Filbehandling.lagLeseforbindelse(filnavn);
			String linje = innfil.readLine();
			while(linje!=null) {
				StringTokenizer innhold = new StringTokenizer(linje,";");
				String varenr = innhold.nextToken();
				String varenavn = innhold.nextToken();
				String varepris = innhold.nextToken();
				String linjeAntall = innhold.nextToken();
				String linjeRabatt = innhold.nextToken();
				String linjeTotPris = innhold.nextToken();
				int intLinjeAntall = Integer.parseInt(linjeAntall);
				float floatLinjeRabatt = Float.parseFloat(linjeRabatt);
				float floatLinjeTotPris = Float.parseFloat(linjeTotPris);
				Vare vare = new Vare(varenr,varenavn,varepris);
				Fakturalinje fakturalinje = new Fakturalinje(vare,intLinjeAntall,floatLinjeRabatt,floatLinjeTotPris);
				fakturalinjeData.add(fakturalinje);
				linje = innfil.readLine();
			}
			innfil.close();
		} catch(Exception e) {}
		return fakturalinjeData;
		
	}
	
	//Faktura slutt
	
}
