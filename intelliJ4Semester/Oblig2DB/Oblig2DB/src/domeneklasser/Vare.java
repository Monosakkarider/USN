package domeneklasser;

import java.util.Objects;

public class Vare {
	private String varenr;
	private String varenavn;
	private String varepris;
	
	
	public Vare(String varenr, String varenavn, String varepris) {
		super();
		this.varenr = varenr;
		this.varenavn = varenavn;
		this.varepris = varepris;
	}


	public String getVarenr() {
		return varenr;
	}


	public void setVarenr(String varenr) {
		this.varenr = varenr;
	}


	public String getVarenavn() {
		return varenavn;
	}


	public void setVarenavn(String varenavn) {
		this.varenavn = varenavn;
	}


	public String getVarepris() {
		return varepris;
	}


	public void setVarepris(String varepris) {
		this.varepris = varepris;
	}


	@Override
	public String toString() {
		return "Vare [varenr=" + varenr + ", varenavn=" + varenavn + ", varepris=" + varepris + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(varepris, varenavn, varenr);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vare other = (Vare) obj;
		return varenr == other.varenr;
	}
	
	public String toFile() {
		return varenr + ";" + varenavn + ";" + varepris;
	}
	
	
	
	
	

}
