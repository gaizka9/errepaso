package hotela;

import java.util.Objects;
import java.util.Scanner;

public class hotela {
	private int id;
	private String izena;
	private String hiria;
	private String nanZuzendaria;
	
	public hotela(){
        this.id=0;
        this.izena="";
        this.hiria="";
        this.nanZuzendaria="";
    }
     
	public hotela(int id, String i, String h, String n){
        this.id=id;
        this.izena=i;
        this.hiria=h;
        this.nanZuzendaria=n;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHiria() {
		return hiria;
	}

	public void setHiria(String hiria) {
		this.hiria = hiria;
	}

	public String getNanZuzendaria() {
		return nanZuzendaria;
	}

	public void setNanZuzendaria(String nanZuzendaria) {
		this.nanZuzendaria = nanZuzendaria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hiria, id, izena, nanZuzendaria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		hotela other = (hotela) obj;
		return Objects.equals(hiria, other.hiria) && id == other.id && Objects.equals(izena, other.izena)
				&& Objects.equals(nanZuzendaria, other.nanZuzendaria);
	}

	@Override
	public String toString() {
		return "hotela [id=" + id + ", izena=" + izena + ", hiria=" + hiria + ", nanZuzendaria=" + nanZuzendaria + "]";
	}
	
	public void pantailaratu() {
		System.out.println("id: "+this.id);
		System.out.println("izena: "+this.izena);
		System.out.println("hiria: "+this.hiria);
		System.out.println("nanZuzendaria: "+this.nanZuzendaria);
		System.out.println("-------------------------------------------");
	}

	public void irakurri(Scanner sc) {
		System.out.println("izena: ");
		this.izena=sc.next();
		System.out.println("hiria: ");
		this.hiria=sc.next();	
		do{
			System.out.println("nanZuzendaria (9 karaktere): ");
			this.nanZuzendaria=sc.next();	
		}while(nanZuzendaria.length()!=9);
		
	}
}
