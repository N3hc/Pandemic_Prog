package Func_Partida;

public class Main {

	public static void main(String[] args) {
		DatosPartida datosPartida = new DatosPartida(3);
		datosPartida.cargarDatos();
		
		 System.out.println("Elementos de la lista:");
	        for (Virus viruses : datosPartida.getVirus()) {
	            System.out.println(viruses.toString());
	        }

	}

}
