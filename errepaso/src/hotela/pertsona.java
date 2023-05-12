package hotela;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public abstract class pertsona implements Serializable{
	protected String nan;
	protected String izena;
	protected String pasahitza;
	
	public pertsona(){
        this.nan="";
        this.izena="";
        this.pasahitza="";
    }
     
	public pertsona(String n, String i, String p){
        this.nan=n;
        this.izena=i;
        this.pasahitza=p;
	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(izena, nan, pasahitza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pertsona other = (pertsona) obj;
		return Objects.equals(izena, other.izena) && Objects.equals(nan, other.nan)
				&& Objects.equals(pasahitza, other.pasahitza);
	}

	@Override
	public String toString() {
		return "pertsona [nan=" + nan + ", izena=" + izena + ", pasahitza=" + pasahitza + "]";
	}
	
	public void pantailaratu() {
		System.out.println("nan: " + this.nan);
		System.out.println("izena: " + this.izena);
		System.out.println("pasahitza: " + this.pasahitza);;
		
	}

	public abstract void irakurri(Scanner sc);
}
