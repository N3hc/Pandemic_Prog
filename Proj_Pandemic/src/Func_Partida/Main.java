package Func_Partida;

import java.sql.Connection;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		String NICKNAME = "Ardui";
		int password = 123;
		Connection con = bbdd.conectarBaseDatos();
		bbdd.insert(con, "INSERT INTO JUGADOR (\"NICKNAME\", \"PASSWORD\")\n" + "VALUES ('" +NICKNAME+"'," 
				+ password + ")");
		
		System.out.println("si");
	        

	}

}
