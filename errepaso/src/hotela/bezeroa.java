package hotela;

import java.util.Objects;
import java.util.Scanner;

public class bezeroa {
	private String nan;
	private String izena;
	
	public bezeroa(){
        this.nan="";
        this.izena="";
    }
     
	public bezeroa(String n, String i){
        this.nan=n;
        this.izena=i;
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

	@Override
	public int hashCode() {
		return Objects.hash(izena, nan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		bezeroa other = (bezeroa) obj;
		return Objects.equals(izena, other.izena) && Objects.equals(nan, other.nan);
	}

	@Override
	public String toString() {
		return "bezeroa [nan=" + nan + ", izena=" + izena + "]";
	}
	
	public void pantailaratu() {
		System.out.println("nan: "+this.nan);
		System.out.println("izena: "+this.izena);
		System.out.println("-------------------------------------------");
	}

	public void irakurri(Scanner sc) {
		do{
			System.out.println("nan (9 karaktere): ");
			this.nan=sc.next();	
		}while(nan.length()!=9);
		System.out.println("izena: ");
		this.izena=sc.next();
	}
}
