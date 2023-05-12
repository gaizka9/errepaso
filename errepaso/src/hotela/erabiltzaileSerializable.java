package hotela;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class erabiltzaileSerializable {
	public static void main(String[] args) {
		erabiltzailea a1 = new erabiltzailea("11111111A", "Asier", "1111", 0);
		erabiltzailea a2 = new erabiltzailea("21111111A", "Gaizka", "2222", 1);
		erabiltzailea a3 = new erabiltzailea("31111111A", "Antonio", "3333", 2);
		
		try {
			FileOutputStream fos = new FileOutputStream("erabiltzailea.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			/* LO GRABO */
			oos.writeObject(a1);
			oos.writeObject(a2);
			oos.writeObject(a3);
			/* CIERRO LOS RECURSOS ABIERTOS */
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
