package Func_Partida;

public class Main {

	public static void main(String[] args) {
		DatosPartida datosPartida = new DatosPartida(3);
		datosPartida.cargarDatos();
		
		 System.out.println("Elementos de la lista:");
	        for (Vacuna viruses : datosPartida.getVacunas()) {
	            System.out.println(viruses.toString());
	        }
	        System.out.println();
	        for (Vacuna vacunas : datosPartida.getVacunas()) {
	            System.out.println(vacunas.toString());
	        }
	        System.out.println();
	        for (Ciudad ciudad : datosPartida.getCiudades()) {
	            System.out.println(ciudad.toString());
	        }

	}

}
