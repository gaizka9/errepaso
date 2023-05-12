package futbolistasyEquipos;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class futbolistas implements Serializable{
	private String dni;
	private String nombre;
	private String apellido;
	private int salario;
	private int idEquipo;
	
	public futbolistas(){
        this.dni="";
        this.nombre="";
        this.apellido="";
        this.salario=0;
        this.idEquipo=0;
    }
     
	public futbolistas(String d, String n, String a, int s, int e){
        this.dni=d;
        this.nombre=n;
        this.apellido=a;
        this.salario=s;
        this.idEquipo=e;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, idEquipo, nombre, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		futbolistas other = (futbolistas) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(dni, other.dni)
				&& Objects.equals(idEquipo, other.idEquipo) && Objects.equals(nombre, other.nombre)
				&& salario == other.salario;
	}

	@Override
	public String toString() {
		return "futbolistas [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario
				+ ", idEquipo=" + idEquipo + "]";
	}
	
	public void pantailaratu() {
		System.out.println("dni: " + this.dni);
		System.out.println("nombre: " + this.nombre);
		System.out.println("apellido: " + this.apellido);
		System.out.println("salario: " + this.salario);
		System.out.println("idEquipo: " + this.idEquipo);
		
	}

	public void irakurri(Scanner sc) {
		
		System.out.println("Sartu dni");
		this.dni=sc.next();
		
		System.out.println("Sartu nombre");
		this.nombre=sc.next();
		
		System.out.println("Sartu apellido");
		this.apellido=sc.next();

		System.out.println("Sartu salario");
		this.salario=sc.nextInt();
		
		System.out.println("Sartu idEquipo");
		this.idEquipo=sc.nextInt();
	}
}
