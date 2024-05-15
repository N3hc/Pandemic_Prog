package Func_Partida;

import java.sql.Connection;
import java.util.Iterator;

import Swing.Panel_Login;

public class Main {

	public static void main(String[] args) {
//		String NICKNAME = "Ardui";
//		int password = 123;
//		Connection con = bbdd.conectarBaseDatos();
//		bbdd.insert(con, "INSERT INTO JUGADOR (\"NICKNAME\", \"PASSWORD\")\n" + "VALUES ('" +NICKNAME+"'," 
//				+ password + ")");
//		
//		System.out.println("si");
		Panel_Login pl = new Panel_Login();
		pl.setUser("Ardui");
		control_de_partida c = new control_de_partida();
	    DatosPartida datosPartida = new DatosPartida();
	    datosPartida.cargarDatos("Facil");
<<<<<<< Updated upstream
	    c.guardarPartida(datosPartida);
=======
	    c.FuncionPrueba();
//	    c.guardarPartida(datosPartida);
>>>>>>> Stashed changes
//	    c.iniciarPartidaGuardada(datosPartida);
//	    System.out.println(datosPartida.toString());
		

	}

}
