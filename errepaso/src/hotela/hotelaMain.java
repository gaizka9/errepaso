package hotela;

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

public class hotelaMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hotelaMain hM = new hotelaMain();
		erabiltzailea e2 = new erabiltzailea();
		erabiltzailea e3 = new erabiltzailea();
		String nan1, nanUp, pasahitza1, salir, zuzendariNan="";
		int DNI=0, aukera, aukera1, id1, id2=0, ocupau=0, idL=0;
		boolean dni = false;
		boolean nanRe = false;
		boolean contra = false;
		boolean irten = false;
		
		boolean era = false;
		boolean hot = false;
		boolean log = false;
		boolean bez = false;
		boolean err = false;
		
		ArrayList<erabiltzailea> v = new ArrayList<erabiltzailea>();
		ArrayList<hotela> w = new ArrayList<hotela>();
		ArrayList<logelak> x = new ArrayList<logelak>();
		ArrayList<bezeroa> y = new ArrayList<bezeroa>();
		ArrayList<erreserba> z = new ArrayList<erreserba>();
		
		
		try {
			FileInputStream fis = new FileInputStream("erabiltzailea.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				e2 = (erabiltzailea) ois.readObject();
				v.add(e2);
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnfe) {
			// si el archivo complejos.dat no est� creado
			System.out.println("Error archivo erabiltzailea.dat No encontrado.");
		} catch (IOException ioe) {
			// si se produce otro error de Entrada / Salida
			System.out.println("Error de Entrada / Salida");
		} catch (ClassNotFoundException cnfe) {
			// si se produce un error de Clase No Encontrada
			System.out.println("Error Clase No Encontrada");
		}
		
		
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hotela", "root", "");
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");

			Statement st = conexion.createStatement();
			ResultSet rs1 = st.executeQuery("SELECT * FROM hotela.hotela;");

			while (rs1.next()) {
				hotela h1 = new hotela(rs1.getInt("id"), rs1.getString("izena"), rs1.getString("hiria"), rs1.getString("nanZuzendari"));
				w.add(h1);
			}

			ResultSet rs2 = st.executeQuery("SELECT * FROM hotela.logelak;");

			while (rs2.next()) {
				logelak l1 = new logelak(rs2.getInt("id"), rs2.getString("izena"), rs2.getString("zerbitzuak"),
						rs2.getInt("idHotela"), rs2.getInt("okupatuta"));
				x.add(l1);
			}
			
			ResultSet rs3 = st.executeQuery("SELECT * FROM hotela.bezeroa;");

			while (rs3.next()) {
				bezeroa b1 = new bezeroa(rs3.getString("nan"), rs3.getString("izena"));
				y.add(b1);
			}
			
			ResultSet rs4 = st.executeQuery("SELECT * FROM hotela.erreserba;");

			while (rs4.next()) {
				erreserba er1 = new erreserba(rs4.getInt("idErreserba"), rs4.getInt("idLogela"), rs4.getString("nanCliente"));
				z.add(er1);
			}

			rs1.close();
			rs2.close();
			rs3.close();
			rs4.close();
			conexion.close();
		} catch (SQLException e) {
			// si NO se ha conectado correctamente
			e.printStackTrace();
			System.out.println("Error de Conexión");
		}
		
		do {
			do{
				System.out.println("Sartu zure nan(9 karaktere): ");
				nan1=sc.next();	
			}while(nan1.length()!=9);
			
			for(int i=0;i<v.size();i++) {
				  if(v.get(i).getNan().equalsIgnoreCase(nan1)) {
					  DNI=i;
					  dni=true;
				  }
			}
			System.out.println("Sartu pasahitza");
			pasahitza1=sc.next();
				  if(v.get(DNI).getPasahitza().equals(pasahitza1)) {;
					  contra=true;
				  }
			if(contra==false || dni==false) {
				System.out.println("Pasahitza edo nan-a txarto dago");
			}
		}while(contra==false || dni==false);
		
		do {
			if(v.get(DNI).getMota()==0) {
				System.out.println("ongi etorri " + v.get(DNI).getIzena());
				System.out.println("-----------------------------------");
				System.out.println("1.- Erabiltzaileak");
				System.out.println("2.- Hotelak");
				System.out.println("-----------------------------------");
			
				aukera=sc.nextInt();
				switch(aukera){
				case 1:
					hM.CRUD();
					aukera1=sc.nextInt();
					switch(aukera1){
					case 1:
						erabiltzailea h3 = new erabiltzailea();
						h3.irakurri(sc);
						v.add(h3);
						System.out.println("Gehitu egin da");
						era = true;
						break;
						
					case 2:
						for (erabiltzailea e : v) {
							e.pantailaratu();
						}
						break;
						
					case 3:
						System.out.println("Sartu eguneratu nahi duzun nan-a");
						nanUp=sc.next();
						for(int i=0;i<v.size();i++) {
							if(v.get(i).getNan().equalsIgnoreCase(nanUp)) {
								h3 = new erabiltzailea();
								h3.irakurri(sc);
								v.set(i, h3);
								System.out.println("Eguneratu egin da");
							}
						}
						era = true;
						break;
						
					case 4:
						System.out.println("Sartu ezabatu nahi duzun nan-a");
						nanUp=sc.next();
						for(int i=0;i<v.size();i++) {
							if(v.get(i).getNan().equalsIgnoreCase(nanUp)) {
								h3 = new erabiltzailea();
								v.remove(i);
								System.out.println("Ezabatu egin da");
							}
						}		
						era = true;
						break;
						
					default:
						System.out.println("Aukera hori es da existitzen");
					}
					break;
				case 2:
					hM.CRUD();	
					aukera1=sc.nextInt();
					switch(aukera1){
					case 1:
						hotela h1 = new hotela();
						if(w.isEmpty()) {
							h1.setId(1);	
						}else {
							h1.setId(w.get(w.size() - 1).getId() + 1);
						}
						h1.irakurri(sc);
						w.add(h1);
						System.out.println("Gehitu egin da");
						hot = true;
						break;
						
					case 2:
						for (hotela e : w) {
							e.pantailaratu();
						}
						break;
						
					case 3:
						System.out.println("Sartu eguneratu nahi duzun id-a");
						id1=sc.nextInt();
						for(int i=0;i<w.size();i++) {
							if(w.get(i).getId()==id1) {
								h1 = new hotela();
								h1.setId(id1);
								h1.irakurri(sc);
								w.set(i, h1);
								System.out.println("Eguneratu egin da");
							}
						}
						hot = true;
						break;
						
					case 4:
						System.out.println("Sartu ezabatu nahi duzun id-a");
						id1=sc.nextInt();
						for(int i=0;i<w.size();i++) {
							if(w.get(i).getId()==id1) {
								 w.remove(i);
								 System.out.println("Ezabatu egin da");
							}
						}			
						hot = true;
						break;
						
					default:
						System.out.println("Aukera hori es da existitzen");
					}
					break;
					
				default:
					System.out.println("Aukera hori es da existitzen");
				}
			
			
			}else if(v.get(DNI).getMota()==1) {
				System.out.println("ongi etorri " + v.get(DNI).getIzena());
				System.out.println("-----------------------------------");
				System.out.println("-Logelak");
				System.out.println("-----------------------------------");
				hM.CRUD();	
				aukera1=sc.nextInt();
				switch(aukera1){
				case 1:
					logelak l1 = new logelak();
					if(x.isEmpty()) {
						l1.setId(1);	
					}else {
						l1.setId(x.get(x.size() - 1).getId() + 1);
					}
					
					for(int i=0;i<w.size();i++) {
						if(w.get(i).getNanZuzendaria().equalsIgnoreCase(nan1)) {
							l1.setIdHotel(w.get(i).getId());
						}
					}
					l1.irakurri(sc);
					x.add(l1);
					System.out.println("Gehitu egin da");
					log = true;
					break;
					
				case 2:
					for (logelak e : x) {
						e.pantailaratu();
					}
					break;
					
				case 3:
					System.out.println("Sartu eguneratu nahi duzun logelaren id-a");
					id1=sc.nextInt();
					
					for(int i=0;i<x.size();i++) {
						if(x.get(i).getId()==id1) {
							ocupau=x.get(i).getOkupatuta();
						}
					}
					
					if(ocupau==1) {
						System.out.println("Logela hau okupatuta dago ezin duzu eguneratu");
					}else {
						for(int i=0;i<x.size();i++) {
							if(x.get(i).getId()==id1) {
								id2=x.get(i).getIdHotel();
							}
						}
						for(int i=0;i<w.size();i++) {
							if(w.get(i).getId()==id2) {
								zuzendariNan=w.get(i).getNanZuzendaria();
							}
						}
						
						if(!zuzendariNan.equals(nan1)) {
							System.out.println("Hotel hau ez da zurea. Ezin duzu aldaketak egin");
						}else {
							for(int i=0;i<x.size();i++) {
								if(x.get(i).getId()==id1) {
									l1 = new logelak();
									l1.setId(id1);
									l1.irakurri(sc);
									x.set(i, l1);
									System.out.println("Eguneratu egin da");
								}
							}
						}
					}
					
					log = true;
					break;
					
				case 4:
					System.out.println("Sartu ezabatu nahi duzun logelaren id-a");
					id1=sc.nextInt();
					
					for(int i=0;i<x.size();i++) {
						if(x.get(i).getId()==id1) {
							id2=x.get(i).getIdHotel();
						}
					}
					for(int i=0;i<w.size();i++) {
						if(w.get(i).getId()==id2) {
							zuzendariNan=w.get(i).getNanZuzendaria();
						}
					}
					
					if(!zuzendariNan.equals(nan1)) {
						System.out.println("Hotel hau ez da zurea. Ezin duzu aldaketak egin");
					}else {
						for(int i=0;i<x.size();i++) {
							if(x.get(i).getId()==id1) {
								 x.remove(i);
								 System.out.println("Ezabatu egin da");
							}
						}
					}
					
					log = true;
					break;
					
				default:
					System.out.println("Aukera hori es da existitzen");
				}
				
				
			}else if(v.get(DNI).getMota()==2) {
				System.out.println("ongi etorri " + v.get(DNI).getIzena());
				System.out.println("-----------------------------------");
				System.out.println("- Erreserbak");
				System.out.println("-----------------------------------");
				System.out.println("1.- Sartu");
				System.out.println("2.- Ikusi");
				System.out.println("3.- Ezabatu");
				System.out.println("-----------------------------------");
				aukera1=sc.nextInt();
				switch(aukera1){
				case 1:
					erreserba er2 = new erreserba();
					do {
						if(z.isEmpty()) {
							er2.setIdReserba(1);	
						}else {
							er2.setIdReserba(z.get(z.size() - 1).getIdReserba() + 1);
						}
						er2.irakurri(sc);
						z.add(er2);
						for(int i=0;i<y.size();i++) {
							if(y.get(i).getNan().equalsIgnoreCase(z.get(z.size()-1).getNanCliente())) {
								nanRe=true;
							}
						}
						if(nanRe==false) {
							System.out.println("Bezero hori ez da existitzen");
							z.remove(z.size()-1);
						}
					}while(nanRe==false);
					for(int i=0;i<x.size();i++) {
						if(x.get(i).getId()==z.get(z.size()-1).getIdLogela()) {
							if(x.get(i).getOkupatuta()==1) {
								z.remove(z.size()-1);
								System.out.println("Logela hori okupatuta dago");
							}else if(x.get(i).getOkupatuta()==0) {
								x.get(i).setOkupatuta(1);
								System.out.println("Gehitu egin da");
							}
						}
					}
					err = true;
					log = true;
					break;
					
				case 2:
					for (erreserba e : z) {
						e.pantailaratu();
					}
					break;
					
				case 3:
					System.out.println("Sartu ezabatu nahi duzun erreserbaren id-a");
					id1=sc.nextInt();
					for(int i=0;i<z.size();i++) {
						if(z.get(i).getIdReserba()==id1) {
							idL=z.get(i).getIdLogela();
							 z.remove(i);
							 
							 for(int j=0;j<x.size();j++) {
								if(x.get(j).getId()==idL) {
									x.get(i).setOkupatuta(0);
								}
							 }
							 System.out.println("Ezabatu egin da");
						}
					}			
					err = true;
					log = true;
					break;
					
				default:
					System.out.println("Aukera hori es da existitzen");
				}
			} 
			
			System.out.println("irten nahi duzu? (B/E)");
			salir=sc.next();
			
			if(salir.equalsIgnoreCase("B")) {
				irten=true;
			}else if(salir.equalsIgnoreCase("E")) {
				irten=false;
			}else {
				while(!salir.equalsIgnoreCase("B") && !salir.equalsIgnoreCase("E")) {
					System.out.println("Hori ez da aukera bat");
					System.out.println("irten nahi duzu? (B/E)");
					salir=sc.next();
					
					if(salir.equalsIgnoreCase("B")) {
						irten=true;
					}else if(salir.equalsIgnoreCase("E")) {
						irten=false;
					}
				}
			}
		}while(irten!=true);
	
		
	
	try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/hotela", "root", "");
		// si se ha conectado correctamente
		System.out.println("Conexión Correcta.");

		Statement st = conexion.createStatement();

		if (hot) {
			st.executeUpdate("DELETE from hotela.hotela;");

			String izena, hiria, nanZuzendari;
			int id;
			for (int i = 0; i < w.size(); i++) {

				id = w.get(i).getId();
				izena = w.get(i).getIzena();
				hiria = w.get(i).getHiria();
				nanZuzendari = w.get(i).getNanZuzendaria();

				st.executeUpdate("INSERT Into hotela.hotela values( '" + id + "' ,'" + izena + "','" + hiria
						+ "' ,'" + nanZuzendari + "');");
			}
		}

		if (log) {
			st.executeUpdate("DELETE from hotela.logelak;");
			
			int id, idHotela, okupatuta;
			String izena, zerbitzuak;
			for (int i = 0; i < x.size(); i++) {

				id = x.get(i).getId();
				izena = x.get(i).getIzena();
				zerbitzuak = x.get(i).getZerbitzuak();
				idHotela = x.get(i).getIdHotel();
				okupatuta = x.get(i).getOkupatuta();
				st.executeUpdate("INSERT Into hotela.logelak values( '" + id + "' ,'" + izena
						+ "','" + zerbitzuak + "' ,'" + idHotela + "' ,'" + okupatuta + "');");
			}
		}
		
		if (bez) {
			st.executeUpdate("DELETE from hotela.bezeroa;");
			
			String izena, nan;
			for (int i = 0; i < y.size(); i++) {

				nan = y.get(i).getNan();
				izena = y.get(i).getIzena();
				st.executeUpdate("INSERT Into hotela.bezeroa values( '" + nan + "' ,'" + izena + "');");
			}
		}
		
		if (err) {
			st.executeUpdate("DELETE from hotela.erreserba;");
			
			String nanCliente;
			int idErreserba, idLogela;
			for (int i = 0; i < z.size(); i++) {

				idErreserba = z.get(i).getIdReserba();
				idLogela = z.get(i).getIdLogela();
				nanCliente = z.get(i).getNanCliente();
				st.executeUpdate("INSERT Into hotela.erreserba values( '" + idErreserba + "' ,'" + idLogela + "' ,'" + nanCliente + "');");
			}
		}
		// cierro la conexion
		conexion.close();
	} catch (SQLException e) {
		// si NO se ha conectado correctamente
		e.printStackTrace();
		System.out.println("Error de Conexión");
	}
	if(era) {
	try {
		FileOutputStream fos = new FileOutputStream("erabiltzailea.dat");
		ObjectOutputStream oos = new ObjectOutputStream (fos);	
		
		for (int i = 0 ; i<v.size() ; i++) {
			e3 = v.get(i);
			oos.writeObject(e3);
		}

		// cierro los recursos abiertos
		oos.close();
		fos.close();
	} catch (FileNotFoundException fnfe) {
		// si el archivo complejos.dat no est� creado
		System.out.println("Error archivo erabiltzailea.dat No encontrado.");
	} catch (IOException ioe) {
		// si se produce otro error de Entrada / Salida
		System.out.println("Error de Entrada / Salida");
	}
	}
	}
	
	public void CRUD() {
		System.out.println("1.- Sartu");
		System.out.println("2.- Ikusi");
		System.out.println("3.- Eguneratu");
		System.out.println("4.- Ezabatu");
		System.out.println("-----------------------------------");
	}
	
}
