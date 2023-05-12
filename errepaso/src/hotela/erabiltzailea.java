package hotela;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class erabiltzailea extends pertsona implements Serializable{
	private int mota;
	
	public erabiltzailea() {
		super();
		this.mota=0;
	}
	
	public erabiltzailea(String n,String i,String p, int m) {
		super(n,i,p);
		this.mota=m;
	}

	@Override
	public String toString() {
		return super.toString() + "erabiltzailea [mota=" + mota + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mota);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		erabiltzailea other = (erabiltzailea) obj;
		return mota == other.mota;
	}

	public int getMota() {
		return mota;
	}

	public void setMota(int mota) {
		this.mota = mota;
	}
	
	public void pantailaratu() {
		System.out.println("nan: "+this.nan);
		System.out.println("izena: "+this.izena);
		System.out.println("pasahitza: "+this.pasahitza);
		System.out.println("Promocion: "+this.mota);
		System.out.println("-------------------------------------------");
	}

	@Override
	public void irakurri(Scanner sc) {
		do{
			System.out.println("nan (9 karaktere): ");
			this.nan=sc.next();	
		}while(nan.length()!=9);
		System.out.println("izena: ");
		this.izena=sc.next();
		System.out.println("pasahitza: ");
		this.pasahitza=sc.next();	
		System.out.println("mota: ");
		this.mota=sc.nextInt();
		
	}
}
