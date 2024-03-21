
import java.io.BufferedReader;
// 0 igual a azul, 1 es rojo, 2 es negro, 3 amarillo
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Enfermedades {
	public static void main(String[] args) {
		String NomFit = "ciudades.txt";
		String NomLec = "CCP.bin";
		String NouFit = "ciudades-enfermedades.bin";
		leerFichero(NomLec);
		escribirFichero(NomFit, NouFit);
		leerFichero(NouFit);
	}
	// ************************************************************************************
	// ** Nombre de la función: escribirFichero
	// ** Explicación del que hace la función: Se graba en un fichero mirando el archivo de ciudades.txt
	// ** Parámetros de entrada: Dos Strings
	// ** Parámetros de salida: nada
	// ************************************************************************************
	public static void escribirFichero(String Fit, String NouFit) {
		String texto;
		try {
            FileReader fr = new FileReader(Fit);
            try (BufferedReader br = new BufferedReader(fr)) {
				DataOutputStream escribeFichero = new DataOutputStream(new FileOutputStream(NouFit, false));
				while ((texto = br.readLine()) != null) {
				    String[] Desglose = texto.split("[,;]");
				    if (Desglose[1].equals("0")) {//Dependiendo del número extraído  suceden una de las siguiente grabaciones en el archivo
				    	escribeFichero.writeUTF("La ciudad "+Desglose[0]+" padece de Alfa");
				    }if (Desglose[1].equals("1")) {
				    	escribeFichero.writeUTF("La ciudad "+Desglose[0]+" padece de Beta");
				    }if (Desglose[1].equals("2")) {
				    	escribeFichero.writeUTF("La ciudad "+Desglose[0]+" padece de Gama");
				    }if (Desglose[1].equals("3")) {
				    	escribeFichero.writeUTF("La ciudad "+Desglose[0]+" padece de Delta");
				    }
				}
			}

		} catch (IOException e) {
			System.out.println("Error E/S");
		}
	}
	// ************************************************************************************
	// ** Nombre de la función: leerFichero
	// ** Explicación del que hace la función: Se lee los datos dentro de los archivos
	// ** Parámetros de entrada: Dos Strings
	// ** Parámetros de salida: nada
	// ************************************************************************************
	public static void leerFichero(String Fit) {
		try {
			DataInputStream leeFichero = new DataInputStream(new FileInputStream(Fit));
			while( leeFichero != null) {//Se lee mientas el DataInputStream no sea NULL
				
				if(Fit.equals("CCP.bin")) {
					System.out.println(leeFichero.readUTF());
                    System.out.println(leeFichero.readInt());
                    System.out.println(leeFichero.readUTF());
                    System.out.println(leeFichero.readUTF());

                    System.out.println(leeFichero.readInt());
                    System.out.println(leeFichero.readUTF());
                    System.out.println(leeFichero.readUTF());

                    System.out.println(leeFichero.readInt());
                    System.out.println(leeFichero.readUTF());
                    System.out.println(leeFichero.readUTF());

                    System.out.println(leeFichero.readInt());
                    System.out.println(leeFichero.readUTF());
                    System.out.println(leeFichero.readUTF());
                    
                    System.out.println(leeFichero.readInt());
                    System.out.println(leeFichero.readInt());
				} else {
					System.out.println(leeFichero.readUTF());
				}
			}
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException e) {
			System.out.println("Error E/S");
		}

	}

}
