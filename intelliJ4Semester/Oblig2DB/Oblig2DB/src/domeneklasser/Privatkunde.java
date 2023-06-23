package domeneklasser;

public class Privatkunde extends Kunde {
	private String butikk;

	public Privatkunde(String kundenr, String kundenavn, String butikk) {
		super(kundenr, kundenavn);
		this.butikk = butikk;

	}

	public String getButikk() {
		return butikk;
	}

	public void setButikk(String butikk) {
		this.butikk = butikk;
	}

	@Override
	public String toString() {
		return "Privatkunde [butikk=" + butikk + "]";
	}
	
	public String toFile() {
		return super.toFile() + ";" + butikk;
	}
	
	
	
}
