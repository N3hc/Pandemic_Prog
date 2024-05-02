package Func_Partida;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		DatosPartida datosPartida = new DatosPartida();
		datosPartida.cargarDatos("Normal");
		String [] ciudad1 = new String[11];
		int i = 0;
		
//		control_de_partida cdp = new control_de_partida();
//		cdp.gestionarTurno(datosPartida, 0);
//		for (Ciudad ciudad : datosPartida.getCiudades()) {
//			if(ciudad.getInfeccion() > 0) {
//				System.out.println(ciudad.getNombre());
//				i++;
//				ciudad1[i] = ciudad.getNombre();
//			}
//		}
		
		
		 System.out.println("Elementos de la lista:");
	        for (Vacuna viruses : datosPartida.getVacunas()) {
	            System.out.println(viruses.toString());
	        }
	        

	}

}
