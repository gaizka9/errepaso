package futbolistasyEquipos;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class equipos implements Serializable{
	private int idEquipo;
	private String nombre;
	private String ciudad;
	
	public equipos(){
        this.idEquipo=0;
        this.nombre="";
        this.ciudad="";
    }
     
	public equipos(int id, String n, String c){
        this.idEquipo=id;
        this.nombre=n;
        this.ciudad=c;
	}

	@Override
	public String toString() {
		return "equipos [idEquipo=" + idEquipo + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudad, idEquipo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		equipos other = (equipos) obj;
		return Objects.equals(ciudad, other.ciudad) && idEquipo == other.idEquipo
				&& Objects.equals(nombre, other.nombre);
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void pantailaratu() {
		System.out.println("idEquipo: " + this.idEquipo);
		System.out.println("nombre: " + this.nombre);
		System.out.println("ciudad: " + this.ciudad);;
		
	}

	public void irakurri(Scanner sc) {
		
		
		System.out.println("Sartu nombre");
		this.nombre=sc.next();
		
		System.out.println("Sartu ciudad");
		this.ciudad=sc.next();
	}
}
