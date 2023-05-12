package futbolistasyEquipos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class futbolistaSerializable {
	public static void main(String[] args) {
		futbolistas f1 = new futbolistas("11111111A", "Antonio", "Rodelgo", 40000000, 1);
		
		try {
			FileOutputStream fos = new FileOutputStream("futbolistas.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			/* LO GRABO */
			oos.writeObject(f1);
			/* CIERRO LOS RECURSOS ABIERTOS */
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
