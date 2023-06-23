package domeneklasser;

import java.util.Objects;

public class Kunde {
	private String kundenummer;
	private String kundenavn;
	
	
	public Kunde(String kundenr, String kundenavn) {
		super();
		this.kundenummer = kundenr;
		this.kundenavn = kundenavn;
	}


	public String getKundenummer() {
		return kundenummer;
	}


	public void setKundenummer(String kundenummer) {
		this.kundenummer = kundenummer;
	}


	public String getKundenavn() {
		return kundenavn;
	}


	public void setKundenavn(String kundenavn) {
		this.kundenavn = kundenavn;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kunde other = (Kunde) obj;
		return Objects.equals(kundenummer, other.kundenummer);
	}


	@Override
	public String toString() {
		return "Kunde [kundenummer=" + kundenummer + ", kundenavn=" + kundenavn + "]";
	}

	public String toFile() {
		return kundenummer + ";" + kundenavn;
	}
	
	
	

}
