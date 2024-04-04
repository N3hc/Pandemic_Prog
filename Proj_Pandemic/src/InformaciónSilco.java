import java.util.ArrayList;
import java.util.Scanner;

public class InformaciónSilco {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indique el texto encriptado");
		String textoEncriptado = sc.nextLine();
		System.out.println(desEncriptador(textoEncriptado));
		sc.close();
	}
	// ************************************************************************************
	// ** Nombre de la función: desEncriptar
	// ** Explicación del que hace la función: Se envía un texto desde el main para dividir en string y crear una frase
	// ** Parámetros de entrada: String textoEncriptado
	// ** Parámetros de salida: Un String
	// ************************************************************************************
	public static String desEncriptador(String textoEncriptado) {
		ArrayList<String> infoCol = new ArrayList<String>();// Se crea la array List de infoCol, se hace así para recoger las ciudades y que no pete al no estar determinadas
		String ciudad = "";
		int[] infoCity = new int[3];
		String texto = "";
		String[] prueba = textoEncriptado.split("[,;]");
		ciudad = prueba[0];
		infoCity[0] = Integer.parseInt(prueba[1]);
		infoCity[1] = Integer.parseInt(prueba[2]);
		infoCity[2] = Integer.parseInt(prueba[3]);
		for (int i = 4; i < prueba.length; i++) {
			infoCol.add(prueba[i]);	
		}
		texto = "El Espiritu Oscuro esta tramando sus antimañas en " + ciudad + " con los numeros " + infoCity[0] + ", " + infoCity[1] + " y "
	            + infoCity[2] + ", y cuyas ciudades colindantes son ";
		for (int i = 0; i < infoCol.size(); i++) {
			if (i != infoCol.size()-1 && i != 0) {
			texto += ", "+infoCol.get(i);
			} else if (i == 0) {
			texto += infoCol.get(i);
			} else {
				texto += " y "+infoCol.get(i)+".";	
			}
		}
		return texto;
	}

}
