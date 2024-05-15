package Func_Partida;

import java.sql.Connection;
import java.util.Random;

import Swing.Panel_Login;
import Swing.Panel_Menu_Principal;
import Swing.Panel_Partida;

public class control_de_partida {
	int contadorInfeccions = 0;
	int contadorPartida = 0;
	int contadorBrotes = 0;
	int contadorTurnos = 0;
	int contadorInvestigacions = 0;
	int contadorMatar = 0;
	int total = 0;
	/**
	 * Función para cargar todas y cada unas de las informaciones guardadas en la base de datos sobre una partida guardada
	 * @param datosPartida Información de la partida
	 */
	
	public void iniciarPartidaGuardada(DatosPartida datosPartida) {
		Connection con = bbdd.conectarBaseDatos();
		Panel_Login pl = new Panel_Login();
		for (int i = 0; i < datosPartida.getCiudades().size(); i++) {
			String[] listaElementosSeleccionados = { "Infeccion" };
			String[] Select = bbdd.select(con,
					"SELECT c.Infeccion FROM DATOSPARTIDATABLA d,TABLE(d.datos.Ciudades) c where c.nombre = '"
							+ datosPartida.getCiudades().get(i).getNombre()+ "' and d.id = (Select MAX(id) FROM DATOSPARTIDATABLA where jugador = '"+pl.getUser()+"')",
					listaElementosSeleccionados);
		datosPartida.getCiudades().get(i).setInfeccion(Integer.parseInt(Select[0]));
		}

		for (int i = 0; i < datosPartida.getVacunas().size(); i++) {
			String[] listaElementosSeleccionados = { "Porcentaje" };
			String[] Select = bbdd.select(con,
					"SELECT v.Porcentaje FROM DATOSPARTIDATABLA d,TABLE(d.datos.Vacunas) v where v.nombre = '"
							+ datosPartida.getVacunas().get(i).getArma() + "' and d.id = (Select MAX(id) FROM DATOSPARTIDATABLA where jugador = '"+pl.getUser()+"')",
					listaElementosSeleccionados);
			datosPartida.getVacunas().get(i).setPorcentaje(Integer.parseInt(Select[0]));
		}
		;
		String[] listaElementosSeleccionados = { "datos.Rondas" };
		String[] Select = bbdd.select(con,
				"SELECT d.datos.Rondas FROM DatosPartidaTabla d WHERE d.id = (Select MAX(id) FROM DATOSPARTIDATABLA where jugador = '"+pl.getUser()+"')",
				listaElementosSeleccionados);
		datosPartida.setRondas(Integer.parseInt(Select[0]));

		String[] listaElementosSeleccionados2 = { "datos.Brotes" };
		String[] Select2 = bbdd.select(con,
				"SELECT d.datos.Brotes FROM DatosPartidaTabla d WHERE d.id = (Select MAX(id) FROM DATOSPARTIDATABLA where jugador = '"+pl.getUser()+"')",
				listaElementosSeleccionados2);
		datosPartida.setBrotes(Integer.parseInt(Select2[0]));

		String[] listaElementosSeleccionados3 = { "datos.Acciones" };
		Select2 = bbdd.select(con,
				"SELECT d.datos.Acciones FROM DatosPartidaTabla d WHERE d.id = (Select MAX(id) FROM DATOSPARTIDATABLA where jugador = '"+pl.getUser()+"')",
				listaElementosSeleccionados3);
		datosPartida.setAcciones(Integer.parseInt(Select2[0]));
		
		String[] listaElementosSeleccionados4 = { "Datos.Dificultad" };
		String[] Select4 = bbdd.select(con, "SELECT d.Datos.Dificultad FROM DatosPartidaTabla d where d.id = (Select MAX(id) FROM DATOSPARTIDATABLA where jugador = '"+pl.getUser()+"')", listaElementosSeleccionados4);
		datosPartida.cargarDiffPartidaGuardada(Select4[0]);
		System.out.println(Select4[0]);
	}
	
	
	/**
	 * Se guardan todos los parametros de la partida en una base de datos mediante
	 * la clase bbdd
	 * 
	 * @param datosPartida Se le pasa los datos del juego
	 */
	public void guardarPartida(DatosPartida datosPartida) {
		int i = 0;
		String ciudad1 = "";
		String vacuna1 = "";
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (i == 47) {
				ciudad1 += "Ciudad('" + ciudad.getNombre() + "'," + ciudad.getInfeccion() + ")";
				i = 0;
			} else {
				ciudad1 += "Ciudad('" + ciudad.getNombre() + "'," + ciudad.getInfeccion() + "),";
				i++;
			}
		}

		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (i == 3) {
				vacuna1 += "Vacuna('" + vacuna.getArma() + "'," + vacuna.getPorcentaje() + ")";
			} else {
				vacuna1 += "Vacuna('" + vacuna.getArma() + "'," + vacuna.getPorcentaje() + "),";
				i++;
			}
		}
		Panel_Login pl = new Panel_Login();
		Connection con = bbdd.conectarBaseDatos();
		String b = "INSERT INTO DatosPartidaTabla (Jugador, Puntuacion, Datos) Values ('" + pl.getUser() + "',"
				+ calcularPuntuajeFinal() + "," + " DatosPartida(CiudadTabla(" + ciudad1 + "),VacunaTabla(" + vacuna1
				+ ")," + datosPartida.getBrotes() + "," + datosPartida.getRondas() + "," + datosPartida.getAcciones()
				+ ", '"+Panel_Menu_Principal.getDiff()+"'))";
		bbdd.insert(con, b);
	}

	/**
	 * Se devuelve el total de la suma de las diferentes variables de puntuación de
	 * la partida
	 * 
	 * @return
	 */
	public int calcularPuntuajeFinal() {
		total = contadorInfeccions * 2;
		total = total + contadorPartida * 1000;
		total = total + contadorBrotes * 10;
		total = total + contadorTurnos * 5;
		total = total + contadorInvestigacions * 20;
		total = total + contadorMatar * 10;

		return total;
	};

	/**
	 * Se comprueba la condición de victoria que es que todas las vacunas tengan su
	 * estado en true
	 * 
	 * @param datosPartida
	 * @return Devuelve un true/false para saber si se gana o no
	 */
	public boolean ganarPartida(DatosPartida datosPartida) {
		int i = 0;
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.isEstado()) {
				i++;
			}
			if (i == 4) {
				contadorPartida++;
				return true;
			}
		}

		return false;

	}

	/**
	 * Se comprueba que le personaje tenga su cooldown en 0
	 * 
	 * @param datosPartida la información de la partida
	 * @param i            i es el identifdicador del personaje
	 * @return Devuelve true/false
	 */
	public boolean estadoPej(DatosPartida datosPartida, int i) {
		for (Personaje personaje : datosPartida.getPersonajes()) {
			if (personaje.getCooldown() == 0 && personaje.getRol() == i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Los diferentes procesos de paso de turno se ejecutan
	 * 
	 * @param datosPartida  informació nde la partida
	 * @param valor_momento valor por el cual se decide si es una cantidad u otra de
	 *                      ciudades infectadas
	 */
	public void gestionarTurno(DatosPartida datosPartida, int valor_momento) {
		contadorTurnos++;
		actualizarEstado(datosPartida);
		datosPartida.setRondas(datosPartida.getRondas() + 1);
		datosPartida.setAcciones(4);
		int[] ciudades_ya = new int[(int) datosPartida.getDerCon(valor_momento)];

		for (int i = 0; i < ciudades_ya.length; i++) {
			int indiceAleatorio;
			do {
				indiceAleatorio = (int) (Math.random()*48);
			} while (esCiudadYaSeleccionada(ciudades_ya, indiceAleatorio, i));

			ciudades_ya[i] = indiceAleatorio;

			Ciudad ciudadAleatoria = datosPartida.getCiudades().get(indiceAleatorio);
			gestionarInfeccion(datosPartida, ciudadAleatoria.getNombre(), datosPartida.getDerCon(4));
			String datos = "Se ha infectado " + ciudadAleatoria.getNombre() + " " + ciudadAleatoria.getInfeccion();
			Panel_Partida.GuardarDatos(datos);

		}
		gestionarBrote(datosPartida);
	}

	/**
	 * Se comprueba si ya se ha elegido para no repetir
	 * 
	 * @param ciudades_ya     la arra yde las posiciones ya elegidas
	 * @param indiceAleatorio número aleatorio a comprobar
	 * @param indiceActual    Posición del array que se comprueba
	 * @return Devuelve true false
	 */
	private boolean esCiudadYaSeleccionada(int[] ciudades_ya, int indiceAleatorio, int indiceActual) {
		for (int j = 0; j < indiceActual; j++) {
			if (ciudades_ya[j] == indiceAleatorio) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Los procesos de acciónm que se ejecutan al elegir un heroe de ataque
	 * 
	 * @param datosPartida daTOS de la partida
	 * @param elemento     la ciudad desde la que se ha activado
	 */
	public void gestionarHeroesAtc(DatosPartida datosPartida, String elemento) {
		try {
			boolean comp = false;
			if (datosPartida.getAcciones() > 0 && !elemento.equals(null)) {
				for (Personaje personaje : datosPartida.getPersonajes()) {
					if (personaje.getCooldown() == 0 && comp == false) {
						for (Ciudad ciudad : datosPartida.getCiudades()) {
							if (personaje.getRol() == 0 && ciudad.getNombre().equals(elemento)) {
								personaje.setCooldown(3);
								comp = true;
								ciudadesCura(datosPartida, elemento);
								for (String colindantes : ciudad.getCiudadesColindantes()) {
									ciudadesCura(datosPartida, colindantes);
								}
							}
						}
					}
				}
			}
		} catch (NullPointerException e) {
			// Manejo de la excepción
			System.out.println("Se ha producido un NullPointerException");
		}
	}

	/**
	 * Los procesos de acciónm que se ejecutan al elegir un heroe de soporte
	 * 
	 * @param datosPartida datos de la partida
	 * @param elemento     Se manda la ciudad origen de donde se ha activado el
	 *                     personaje
	 */
	public void gestionarHeroeSup(DatosPartida datosPartida, String elemento) {
		try {
			boolean comp = false;
			if (datosPartida.getAcciones() > 0 && !elemento.equals(null)) {
				for (Personaje personaje : datosPartida.getPersonajes()) {
					if (personaje.getCooldown() == 0 && comp == false) {
						for (Ciudad ciudad : datosPartida.getCiudades()) {
							if (personaje.getRol() == 1 && ciudad.getNombre().equals(elemento)) {
								personaje.setCooldown(5);
								comp = true;
								for (Vacuna vacuna : datosPartida.getVacunas()) {
									vacuna.setPorcentaje(vacuna.getPorcentaje() + 5);
								}
							}
						}
					}
				}
			}
		} catch (NullPointerException e) {
			// Manejo de la excepción
			System.out.println("Se ha producido un NullPointerException");
		}
	}

	/**
	 * Función para quitar números de infección en la ciudad seleccionada
	 * 
	 * @param datosPartida Datos de la partida
	 * @param Ciudad       ciudad String que se manda para quitar contadores de la
	 *                     ciudad
	 * @return Devuelve true false
	 */
	public boolean ciudadesCura(DatosPartida datosPartida, String Ciudad) {
		contadorMatar++;
		String datos = null;
		if (datosPartida.getAcciones() > 0) {
			for (Ciudad ciudad : datosPartida.getCiudades()) {
				if (ciudad.getNombre().equals(Ciudad) && ciudad.getInfeccion() > 0) {
					boolean com = false;
					for (Vacuna vacuna : datosPartida.getVacunas()) {
						if (ciudad.getInfeccion() > 0 && !com) {
							if ((ciudad.getEnfermedad().equals("Tritones") && vacuna.getColor().equals("Azul"))
									|| (ciudad.getEnfermedad().equals("Antarboles")
											&& vacuna.getColor().equals("Verde"))
									|| (ciudad.getEnfermedad().equals("Goblos") && vacuna.getColor().equals("Rojo"))
									|| (ciudad.getEnfermedad().equals("Momias") && vacuna.getColor().equals("Negro"))) {
								if (vacuna.isEstado()) {
									datos = "La ciudad " + ciudad.getNombre() + " ha sido purgada!";
									ciudad.setInfeccion(0);
								} else {
									datos = "La ciudad " + ciudad.getNombre() + " ha recibido refuerzos!";
									ciudad.setInfeccion(ciudad.getInfeccion() - 1);
								}

								Panel_Partida.GuardarDatos(datos);
								com = true;
							}
						}
					}
				}
			}
			return true;
		}
		datos = "Acciones insuficientes";
		Panel_Partida.GuardarDatos(datos);
		return false;
	}

	/**
	 * Función para aumentar el porcentaje de las vacunas
	 * 
	 * @param datosPartida Datos de la partida
	 * @param nVacuna      nVacuna es la variable que referencia a una de las cuatro
	 *                     Vacunas
	 * @return Devuelve true/false
	 */
	public boolean gestionarVacuna(DatosPartida datosPartida, String nVacuna) {
		contadorInvestigacions++;
		try {
			String datos = "";
			if (!nVacuna.equals(null)) {
				if (datosPartida.getAcciones() == 4) {
					for (Vacuna vacuna : datosPartida.getVacunas()) {
						if (vacuna.getArma().equals(nVacuna)) {
							if (!vacuna.isEstado()) {
								datosPartida.setAcciones(0);
								datos = "El arma " + vacuna.getArma() + " está siendo creada! \n Resiste!";
								Panel_Partida.GuardarDatos(datos);
								vacuna.setPorcentaje(vacuna.getPorcentaje() + datosPartida.getDerCon(3));
							} else {
								datos = "El arma " + vacuna.getArma() + " Ya está creada! \n Úsala!";
								Panel_Partida.GuardarDatos(datos);
								return false;
							}
						}
					}
					return true;
				}
			}

		} catch (NullPointerException e) {
			System.out.println("Se ha producido un NullPointerException");
		}
		return false;
	}

	/**
	 * Aumenta los contadores de infeccion
	 * 
	 * @param datosPartida datos de la partida
	 * @param nCiudad      Nombre de la ciudad
	 * @param f            es el valor que aumenta de infecció nde la ciudad
	 */
	public void gestionarInfeccion(DatosPartida datosPartida, String nCiudad, int f) {
		contadorInfeccions++;
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.getNombre().equals(nCiudad)) {
				ciudad.setInfeccion(ciudad.getInfeccion() + f);
			}
		}
	}

	/**
	 * Se aumenta el número de brotes si sse cumplen las condiciones ys i es así las
	 * ciudades colindantes aumentan sus infecciones en 1
	 * 
	 * @param datosPartida Datos de la partida
	 */
	public void gestionarBrote(DatosPartida datosPartida) {
		contadorBrotes++;
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.propagarInfeccion() && !ciudad.isActivado()) {
				ciudad.setActivado(true);
				datosPartida.setBrotes(datosPartida.getBrotes() + 1);
				for (String ciudadColindante : ciudad.getCiudadesColindantes()) {
					gestionarInfeccion(datosPartida, ciudadColindante, 1);
				}
			}
		}
	}

	/**
	 * Se resuelve el cooldown (Se restan 1 a menos que sea 0) y el estado de las
	 * ciudades a false
	 * 
	 * @param datosPartida datos partida
	 */
	public void actualizarEstado(DatosPartida datosPartida) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.isActivado()) {
				ciudad.setActivado(false);
			}
		}
		for (Personaje personaje : datosPartida.getPersonajes()) {
			if (personaje.getCooldown() > 0) {
				personaje.setCooldown(personaje.getCooldown() - 1);
			}
		}
	}

	/**
	 * Condición de derrota
	 * 
	 * @param datosPartida datos partida
	 * @return true/false
	 */
	public boolean gestionarFinPartida(DatosPartida datosPartida) {
		if (datosPartida.getBrotes() >= datosPartida.getDerCon(2)) {
			return true;
		}
		return false;
	}

	/**
	 * SI hay una vacuna con porcentaje 100 se le pone el estado en true, está
	 * completada
	 * 
	 * @param datosPartida
	 */
	public void gestionarCura(DatosPartida datosPartida) {
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.getPorcentaje() >= 100 && !vacuna.isEstado()) {
				vacuna.setEstado(true);
			}
		}
	}
}