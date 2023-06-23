package domeneklasser;

public class Kundekontakt {
	private String kundenummer;
	private String dato;
	private String kontakt;
	
	public Kundekontakt(String kundenummer, String dato, String kontakt) {
		this.kundenummer = kundenummer;
		this.dato = dato;
		this.kontakt  = kontakt;
	}

	public String getKundenummer() {
		return kundenummer;
	}

	public void setKundenummer(String kundenummer) {
		this.kundenummer = kundenummer;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	@Override
	public String toString() {
		return "Kundekontakt [kundenummer=" + kundenummer + ", dato=" + dato + ", kontakt=" + kontakt + "]";
	}
	
	public String toFile() {
		return kundenummer + ";" + dato + ";" + kontakt;
	}
	

}
