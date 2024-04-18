package Func_Partida;

public class Main {

	public static void main(String[] args) {
		DatosPartida datosPartida = new DatosPartida(3);
		datosPartida.cargarDatos();
		
		 System.out.println("Elementos de la lista:");
	        for (Vacuna viruses : datosPartida.getVacunas()) {
	            System.out.println(viruses.toString());
	        }

	}

}
