package hjelpeklasser;

import java.io.*;

public class Filbehandling {
	//Metode for å lage en skriveforbindelse
	//til en tekstfil:
	
	//Lager metodene som klassemetoder:
	public static PrintWriter lagSkriveforbindelse(String filnavn) {
		try {
			FileWriter filforbindelse = new FileWriter(filnavn, true);
			BufferedWriter skrivebuffer = new BufferedWriter(filforbindelse);
			PrintWriter skriver = new PrintWriter(skrivebuffer);
			return skriver;
		} catch (Exception e) {
			return null;
		}
	}//Slutt metode
	
	public static BufferedReader lagLeseforbindelse(String filnavn) {
		try {
			FileReader filforbindelse = new FileReader(filnavn);
			BufferedReader leser = new BufferedReader(filforbindelse);
			return leser;
			
		} catch(Exception e) {		
			return null;
		}
	}
	
	public static void fjernText(String filnavn) {
		try {
			FileWriter filforbindelse = new FileWriter(filnavn);
			filforbindelse.write("");
			filforbindelse.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
