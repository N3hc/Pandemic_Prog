package Func_Partida;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		DatosPartida datosPartida = new DatosPartida();
		datosPartida.cargarDatos();
		String [] ciudad1 = new String[7];
		int i = 0;
		
		control_de_partida cdp = new control_de_partida();
		cdp.gestionarTurno(datosPartida, 0);
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if(ciudad.getInfeccion() > 0) {
				System.out.println("a");
				i++;
				ciudad1[i] = ciudad.getNombre();
			}
		}
		ciudad1.toString();
		for (int j = 0; j < ciudad1.length; j++) {
			cdp.gestionarInfeccion(datosPartida, ciudad1[j], 1);
		}
		
		
//		 System.out.println("Elementos de la lista:");
//	        for (Ciudad viruses : datosPartida.getCiudades()) {
//	            System.out.println(viruses.toString());
//	        }
	        

	}

}
