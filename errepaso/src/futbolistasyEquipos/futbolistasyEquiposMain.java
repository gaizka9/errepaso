package futbolistasyEquipos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class futbolistasyEquiposMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int aukera;
		int irten=1;
		boolean fut = false;
		boolean equ = false;
		boolean futb = false;
		boolean equi = false;
		futbolistas f = new futbolistas();
		equipos e = new equipos();
		futbolistas f1 = new futbolistas();
		equipos e1 = new equipos();
		
		ArrayList<futbolistas> a = new ArrayList<futbolistas>();
		ArrayList<equipos> b = new ArrayList<equipos>();
		try {
			FileInputStream fis = new FileInputStream("equipos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				e = (equipos) ois.readObject();
				b.add(e);
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnfe) {
			// si el archivo complejos.dat no est� creado
			System.out.println("Error archivo equipos.dat No encontrado.");
		} catch (IOException ioe) {
			// si se produce otro error de Entrada / Salida
			System.out.println("Error de Entrada / Salida");
		} catch (ClassNotFoundException cnfe) {
			// si se produce un error de Clase No Encontrada
			System.out.println("Error Clase No Encontrada");
		}
		
		try {
			FileInputStream fis = new FileInputStream("futbolistas.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				f = (futbolistas) ois.readObject();
				a.add(f);
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnfe) {
			// si el archivo complejos.dat no est� creado
			System.out.println("Error archivo futbolistas.dat No encontrado.");
		} catch (IOException ioe) {
			// si se produce otro error de Entrada / Salida
			System.out.println("Error de Entrada / Salida");
		} catch (ClassNotFoundException cnfe) {
			// si se produce un error de Clase No Encontrada
			System.out.println("Error Clase No Encontrada");
		}
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/futbolisistasyequipos", "root", "");
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");

			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM futbolisistasyequipos.futbolistas;");

			while (rs.next()) {
				futbolistas f2 = new futbolistas(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("salario"), rs.getInt("idEquipo"));
				a.add(f2);
			}

			ResultSet rs1 = st.executeQuery("SELECT * FROM futbolisistasyequipos.equipos;");
			

			while (rs1.next()) {
				equipos e2 = new equipos(rs1.getInt("idEquipo"), rs1.getString("nombre"),
						rs1.getString("ciudad"));
				b.add(e2);
			}

			// cierro la conexion
			rs.close();
			rs1.close();
			conexion.close();
		} catch (SQLException w) {
			// si NO se ha conectado correctamente
			w.printStackTrace();
			System.out.println("Error de Conexión");
		}
		
		System.out.println("Ongi etrri!");
		System.out.println("Zer egin nahi duzu?");
		do {
			System.out.println("-----------------------------------");
			System.out.println("0.- Salir");
			System.out.println("1.- Ver futbolistas");
			System.out.println("2.- Ver equipos");
			System.out.println("3.- Añadir futbolistas");
			System.out.println("4.- Añadir equipos");
			System.out.println("-----------------------------------");
			aukera = sc.nextInt();

			switch (aukera) {
			case 1:
				System.out.println("1.- Ver futbolistas");
				for (futbolistas w : a) {
					w.pantailaratu();
				}
				break;
			case 2:
				System.out.println("2.- Ver equipos");
				for (equipos w : b) {
					w.pantailaratu();
				}
				break;
			case 3:
				System.out.println("3.- Añadir futbolistas");
				futbolistas f2 = new futbolistas();
				f2.irakurri(sc);
				a.add(f2);
				fut = true;
				futb = true;
				break;
			case 4:
				System.out.println("4.- Añadir equipos");
				equipos e2 = new equipos();
				e2.setIdEquipo(b.get(b.size() - 1).getIdEquipo()+1);
				e2.irakurri(sc);
				b.add(e2);
				equ = true;
				equi = true;
				break;
			case 0:
				irten=0;

				break;
				
			}
			System.out.println("irten nahi duzu [0(bai)/1(ez)]");
			irten=sc.nextInt();
			
		} while (irten!=0);
		sc.close();
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/futbolisistasyequipos", "root", "");
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");

			Statement st = conexion.createStatement();

			if (futb) {
				st.executeUpdate("DELETE from futbolisistasyequipos.futbolistas;");

				String dni, nombre, apellido;
				int salario, idEquipo;
				for (int i = 0; i < a.size(); i++) {

					dni = a.get(i).getDni();
					nombre = a.get(i).getNombre();
					apellido = a.get(i).getApellido();
					salario = a.get(i).getSalario();
					idEquipo = a.get(i).getIdEquipo();

					st.executeUpdate("INSERT Into futbolisistasyequipos.futbolistas values( '" + dni + "' ,'" + nombre + "','" + apellido + "' ,'" + salario + "','"
							+ idEquipo + "');");
				}
			}

			if (equi) {
				st.executeUpdate("DELETE from futbolisistasyequipos.equipos;");

				String nombre, ciudad;
				int idEquipo;
				for (int i = 0; i < b.size(); i++) {

					idEquipo = b.get(i).getIdEquipo();
					nombre = b.get(i).getNombre();
					ciudad = b.get(i).getCiudad();

					st.executeUpdate("INSERT Into futbolisistasyequipos.equipos values( '" + idEquipo + "' ,'" + nombre + "','" + ciudad
							+ "');");
				}
			}
			// cierro la conexion
			conexion.close();
		} catch (SQLException w) {
			// si NO se ha conectado correctamente
			w.printStackTrace();
			System.out.println("Error de Conexión");
		}
		
		if(equ) {
			try {
				FileOutputStream fos = new FileOutputStream("equipos.dat");
				ObjectOutputStream oos = new ObjectOutputStream (fos);	
				
				for (int i = 0 ; i<b.size() ; i++) {
					e1 = b.get(i);
					oos.writeObject(e1);
				}

				// cierro los recursos abiertos
				oos.close();
				fos.close();
			} catch (FileNotFoundException fnfe) {
				// si el archivo complejos.dat no est� creado
				System.out.println("Error archivo equipos.dat No encontrado.");
			} catch (IOException ioe) {
				// si se produce otro error de Entrada / Salida
				System.out.println("Error de Entrada / Salida");
			}
		}
		if(fut) {
			try {
				FileOutputStream fos = new FileOutputStream("futbolistas.dat");
				ObjectOutputStream oos = new ObjectOutputStream (fos);	
				
				for (int i = 0 ; i<a.size() ; i++) {
					f1 = a.get(i);
					oos.writeObject(f1);
				}

				// cierro los recursos abiertos
				oos.close();
				fos.close();
			} catch (FileNotFoundException fnfe) {
				// si el archivo complejos.dat no est� creado
				System.out.println("Error archivo futbolistas.dat No encontrado.");
			} catch (IOException ioe) {
				// si se produce otro error de Entrada / Salida
				System.out.println("Error de Entrada / Salida");
			}
		}
	}

}
