import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rustas_Optimas {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String Fit = "ciudades.txt";
        String texto = ""; // Texto de lectura
        String[] ciudades = new String [48]; // Nombre de las ciudades
        String ciudadOrigen = ""; // ciudad que querramos buscar
        int[][] matriz = new int[48][48]; // Matriz donde estan las distancias
        int[] coordenadas = new int[4]; //cordenadas de las ciudades
        int cont_fil = 0; //Contador para las filas
        int cont_col = 0; //Contador para las columnas
        int cont_ciu = 0; //Contador para las ciudades
        int cont_ciu_def = 0; //Contador para la poscicion de la ciudad buscada
        System.out.println("Introduzla la ciudad Origen");
        ciudadOrigen = sc.nextLine();
        try {
            FileReader fr = new FileReader(Fit);
            BufferedReader br = new BufferedReader(fr);

            while ((texto = br.readLine()) != null) { // Conseguimos las ciudades principales
                ArrayList<String> infoCol = new ArrayList<String>();
                String[] Desglose = texto.split("[,;]");
                ciudades[cont_ciu] = Desglose[0];
                if(Desglose[0].matches(ciudadOrigen)) {
                	cont_ciu_def = cont_ciu;
                }
                coordenadas[0] = Integer.parseInt(Desglose[2]);
                coordenadas[1] = Integer.parseInt(Desglose[3]);
                for (int i = 4; i < Desglose.length; i++) {
                    infoCol.add(Desglose[i]);
                }

                FileReader fr2 = new FileReader(Fit);
                BufferedReader br2 = new BufferedReader(fr2);

                cont_col = 0;
                while ((texto = br2.readLine()) != null) { // COnseguimos las ciudades colindantes de la principal
                    Desglose = texto.split("[,;]");
                    coordenadas[2] = Integer.parseInt(Desglose[2]);
                    coordenadas[3] = Integer.parseInt(Desglose[3]);

                    if (infoCol.contains(Desglose[0])) {
                        matriz[cont_fil][cont_col] = distancia(coordenadas);
                        matriz[cont_col][cont_fil] = distancia(coordenadas);
                    }
                    cont_col++;
                }
                cont_fil++;
                cont_ciu++;
                infoCol.clear();
                fr2.close();
                br2.close();
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }

//        // Imprimir la matriz
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j] + "|");
//            }
//            System.out.println();
//        }
        Dijkstra d = new Dijkstra();
        
        d.dijkstra(ciudades,matriz, cont_ciu_def);
    }

    // Función para calcular la distancia entre dos puntos
    public static int distancia(int[] coordenadas) {
        int distancia = (int) (Math.pow((coordenadas[0] - coordenadas[2]), 2)
                + Math.pow((coordenadas[1] - coordenadas[3]), 2));
        distancia = (int) Math.sqrt(distancia);
        return distancia;
    }
}