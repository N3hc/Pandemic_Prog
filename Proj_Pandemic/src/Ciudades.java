import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ciudades {

    public static void main(String[] args) {
        String Fit = "ciudades.txt";
        String NomFit = "ciudadesRedactadas.txt";
        String texto = "";
        int[] coordenadas = new int[4];
        try {
            FileReader fr = new FileReader(Fit);
            BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(NomFit, false);
			BufferedWriter bw = new BufferedWriter(fw);
            while ((texto = br.readLine()) != null) {
                ArrayList<String> infoCol = new ArrayList<String>();
                String[] Desglose = texto.split("[,;]");
                coordenadas[0] = Integer.parseInt(Desglose[2]);
                coordenadas[1] = Integer.parseInt(Desglose[3]);
                for (int i = 4; i < Desglose.length; i++) {
                    infoCol.add(Desglose[i]);
                }
                bw.write("\nLa ciudad " + Desglose[0] + " está en las coordenadas (" + Desglose[2] + ","
                        + Desglose[3] + ") sus ciudades colindantes son: ");//Se graba en el archivo la siguiente línea
                FileReader fr2 = new FileReader(Fit);
                BufferedReader br2 = new BufferedReader(fr2);
                br2.mark(0);
                while ((texto = br2.readLine()) != null) {
                    Desglose = texto.split("[,;]");
                    coordenadas[2] = Integer.parseInt(Desglose[2]);
                    coordenadas[3] = Integer.parseInt(Desglose[3]);

                    if (infoCol.contains(Desglose[0])) {
                				bw.write("La ciudad " + Desglose[0] + " está a " + distancia(coordenadas) + " unidades");//Se graba en el archivo la siguiente línea
                				bw.newLine();
                        System.out.println();
                    }
                }
                infoCol.clear();
                fr2.close();
                br2.close();
            }
            fr.close();
            br.close();
			bw.close();
			fw.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
    }
	// ************************************************************************************
	// ** Nombre de la función: distancia
	// ** Explicación del que hace la función: Se calcula la distancia
	// ** Parámetros de entrada: Array de Ints
	// ** Parámetros de salida: un int
	// ************************************************************************************
    public static int distancia(int[] coordenadas) {
        int distancia = (int) (Math.pow((coordenadas[0] - coordenadas[2]), 2) + Math.pow((coordenadas[1] - coordenadas[3]), 2));
        distancia = (int) Math.sqrt(distancia);
        return distancia;
    }
}

