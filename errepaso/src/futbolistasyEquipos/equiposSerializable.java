package futbolistasyEquipos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class equiposSerializable {
	public static void main(String[] args) {
		equipos e1 = new equipos(1, "Athletic", "Bilbao");
		
		try {
			FileOutputStream fos = new FileOutputStream("equipos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			/* LO GRABO */
			oos.writeObject(e1);
			/* CIERRO LOS RECURSOS ABIERTOS */
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
