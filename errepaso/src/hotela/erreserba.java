package hotela;

import java.util.Objects;
import java.util.Scanner;

public class erreserba {
	private int idReserba;
	private int idLogela;
	private String nanCliente;
	
	public erreserba(){
        this.idReserba=0;
        this.idLogela=0;
        this.nanCliente="";
    }
     
	public erreserba(int iR, int iL, String n){
        this.idReserba=iR;
        this.idLogela=iL;
        this.nanCliente=n;
	}

	public int getIdReserba() {
		return idReserba;
	}

	public void setIdReserba(int idReserba) {
		this.idReserba = idReserba;
	}

	public int getIdLogela() {
		return idLogela;
	}

	public void setIdLogela(int idLogela) {
		this.idLogela = idLogela;
	}

	public String getNanCliente() {
		return nanCliente;
	}

	public void setNanCliente(String nanCliente) {
		this.nanCliente = nanCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLogela, idReserba, nanCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		erreserba other = (erreserba) obj;
		return idLogela == other.idLogela && idReserba == other.idReserba
				&& Objects.equals(nanCliente, other.nanCliente);
	}

	@Override
	public String toString() {
		return "erreserba [idReserba=" + idReserba + ", idLogela=" + idLogela + ", nanCliente=" + nanCliente + "]";
	}
	
	public void pantailaratu() {
		System.out.println("idReserba: "+this.idReserba);
		System.out.println("idLogela: "+this.idLogela);
		System.out.println("nanCliente: "+this.nanCliente);
		System.out.println("-------------------------------------------");
	}

	public void irakurri(Scanner sc) {
		System.out.println("idLogela: ");
		this.idLogela=sc.nextInt();
		
		do{
			System.out.println("nan (9 karaktere): ");
			this.nanCliente=sc.next();	
		}while(nanCliente.length()!=9);
	}
}
