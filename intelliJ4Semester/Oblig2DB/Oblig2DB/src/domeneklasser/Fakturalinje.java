package domeneklasser;

public class Fakturalinje {
	private Vare vare;
	private int antall;
	private float rabatt;
	private float totallPris;
	
	public Fakturalinje(Vare vare, int antall, float rabatt, float totallPris) {
		super();
		this.vare = vare;
		this.antall = antall;
		this.rabatt = rabatt;
		this.totallPris = totallPris;
	}

	public Vare getVare() {
		return vare;
	}

	public void setVare(Vare vare) {
		this.vare = vare;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public float getRabatt() {
		return rabatt;
	}

	public void setRabatt(float rabatt) {
		this.rabatt = rabatt;
	}

	public float getTotallPris() {
		return totallPris;
	}

	public void setTotallPris(float totallPris) {
		this.totallPris = totallPris;
	}

	@Override
	public String toString() {
		return "Fakturalinje [vare=" + vare + ", antall=" + antall + ", rabatt=" + rabatt + ", totallPris=" + totallPris
				+ "]";
	}
	
	public String toFile() {
		return vare.toFile() + ";" + antall + ";" + rabatt + ";" + totallPris;
	}
	
	
}
