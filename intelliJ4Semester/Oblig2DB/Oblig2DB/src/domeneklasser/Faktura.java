package domeneklasser;

public class Faktura {
	private int fakturanr;
	private Kunde fakturaKunde;
	private String dagensDato;
	private String forfallsDato;
	private Fakturalinje fakturalinje;
	
	public Faktura(int fakturanr, Kunde fakturaKunde, String dagensDato, String forfallsDato, Fakturalinje fakturalinje) {
		super();
		this.fakturanr = fakturanr;
		this.fakturaKunde = fakturaKunde;
		this.dagensDato = dagensDato;
		this.forfallsDato = forfallsDato;
		this.fakturalinje = fakturalinje;
	}

	public int getFakturanr() {
		return fakturanr;
	}

	public void setFakturanr(int fakturanr) {
		this.fakturanr = fakturanr;
	}

	public Kunde getFakturaKunde() {
		return fakturaKunde;
	}

	public void setFakturaKunde(Kunde fakturaKunde) {
		this.fakturaKunde = fakturaKunde;
	}

	public String getDagensDato() {
		return dagensDato;
	}

	public void setDagensDato(String dagensDato) {
		this.dagensDato = dagensDato;
	}

	public String getForfallsDato() {
		return forfallsDato;
	}

	public void setForfallsDato(String forfallsDato) {
		this.forfallsDato = forfallsDato;
	}
	
	public Fakturalinje getFakturalinje() {
		return fakturalinje;
	}

	public void setFakturalinje(Fakturalinje fakturalinje) {
		this.fakturalinje = fakturalinje;
	}
	
		@Override
	public String toString() {
		return "Faktura [fakturanr=" + fakturanr + ", fakturaKunde=" + fakturaKunde + ", dagensDato=" + dagensDato
				+ ", forfallsDato=" + forfallsDato + ", fakturalinje" + fakturalinje + "]";
	}
	
		public String toFile() {
			return fakturanr + ";" + fakturaKunde.toFile() + ";" + dagensDato + ";" + forfallsDato + ";" + fakturalinje.toFile();
		}
	

}
