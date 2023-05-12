package hotela;

import java.util.Objects;
import java.util.Scanner;

public class logelak {
	private int id;
	private String izena;
	private String zerbitzuak;
	private int idHotel;
	private int okupatuta;
	
	public logelak(){
        this.id=0;
        this.izena="";
        this.zerbitzuak="";
        this.idHotel=0;
        this.okupatuta=0;
    }
     
	public logelak(int id, String i, String z, int ih, int o){
        this.id=id;
        this.izena=i;
        this.zerbitzuak=z;
        this.idHotel=ih;
        this.okupatuta=o;
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

	public String getZerbitzuak() {
		return zerbitzuak;
	}

	public void setZerbitzuak(String zerbitzuak) {
		this.zerbitzuak = zerbitzuak;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getOkupatuta() {
		return okupatuta;
	}

	public void setOkupatuta(int okupatuta) {
		this.okupatuta = okupatuta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idHotel, izena, okupatuta, zerbitzuak);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		logelak other = (logelak) obj;
		return id == other.id && idHotel == other.idHotel && Objects.equals(izena, other.izena)
				&& okupatuta == other.okupatuta && Objects.equals(zerbitzuak, other.zerbitzuak);
	}

	@Override
	public String toString() {
		return "logelak [id=" + id + ", izena=" + izena + ", zerbitzuak=" + zerbitzuak + ", idHotel=" + idHotel
				+ ", okupatuta=" + okupatuta + "]";
	}
	
	public void pantailaratu() {
		System.out.println("id: "+this.id);
		System.out.println("izena: "+this.izena);
		System.out.println("zerbitzuak: "+this.zerbitzuak);
		System.out.println("idHotel: "+this.idHotel);
		System.out.println("okupatuta: "+this.okupatuta);
		System.out.println("-------------------------------------------");
	}

	public void irakurri(Scanner sc) {	
		System.out.println("izena: ");
		this.izena=sc.next();
		System.out.println("zerbitzuak: ");
		this.zerbitzuak=sc.next();
		System.out.println("okupatuta: ");
		this.okupatuta=sc.nextInt();
		
	}
}
