package Func_Partida;

public class Main {

	public static void main(String[] args) {
		DatosPartida datosPartida = new DatosPartida();
		datosPartida.cargarDatos();
		
		control_de_partida cdp = new control_de_partida();
		
		cdp.gestionarVacuna(datosPartida, "Kzarka");
		
		 System.out.println("Elementos de la lista:");
	        for (Vacuna viruses : datosPartida.getVacunas()) {
	            System.out.println(viruses.toString());
	        }
	        

	}

}
