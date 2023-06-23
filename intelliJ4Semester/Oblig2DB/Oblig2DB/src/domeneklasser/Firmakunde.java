package domeneklasser;

public class Firmakunde extends Kunde {
	private String kredittgrense;
	private String telefonnummer;
	

	public Firmakunde(String kundenummer, String kundenavn, String kredittgrense, String telefonnummer) {
		super(kundenummer, kundenavn);
		this.kredittgrense = kredittgrense;
		this.telefonnummer = telefonnummer;
	}


	public String getKredittgrense() {
		return kredittgrense;
	}


	public void setKredittgrense(String kredittgrense) {
		this.kredittgrense = kredittgrense;
	}


	public String getTelefonnummer() {
		return telefonnummer;
	}


	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}


	@Override
	public String toString() {
		return "Firmakunde [kredittgrense=" + kredittgrense + ", telefonnummer=" + telefonnummer + "]";
	}
	
	public String toFile() {
		return super.toFile() + ";" +  kredittgrense + ";" + telefonnummer;
	}
	
	

}
