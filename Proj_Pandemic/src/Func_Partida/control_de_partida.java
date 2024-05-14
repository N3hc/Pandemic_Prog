package Func_Partida;

import java.sql.Connection;
import java.util.Random;

import Swing.Panel_Login;
import Swing.Panel_Partida;

public class control_de_partida {
	int contadorInfeccions = 0;
	int contadorPartida = 0;
	int contadorBrotes = 0;
	int contadorTurnos = 0;
	int contadorInvestigacions = 0;
	int contadorMatar = 0;
	int total = 0;

	public void iniciarPartida() {

	}

	public void iniciarPartidaGuardada(String id) {

	}

	public void guardarPartida(DatosPartida datosPartida) {
		Panel_Login pl = new Panel_Login();
		Connection con = bbdd.conectarBaseDatos();
		String a = "INSERT INTO DatosPartidaTabla (Jugador, Puntuacion, Datos)" + "VALUES ('"+Panel_Login.getUser()+"',"
				+ calcularPuntuajeFinal() + ", DatosPartida(CiudadTabla(Ciudad('"
				+ datosPartida.getCiudades().get(0).getNombre() + "',"
				+ datosPartida.getCiudades().get(0).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(1).getNombre() + "',"
				+ datosPartida.getCiudades().get(1).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(2).getNombre() + "',"
				+ datosPartida.getCiudades().get(2).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(3).getNombre() + "',"
				+ datosPartida.getCiudades().get(3).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(4).getNombre() + "',"
				+ datosPartida.getCiudades().get(4).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(5).getNombre() + "',"
				+ datosPartida.getCiudades().get(5).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(6).getNombre() + "',"
				+ datosPartida.getCiudades().get(6).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(7).getNombre() + "',"
				+ datosPartida.getCiudades().get(7).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(8).getNombre() + "',"
				+ datosPartida.getCiudades().get(8).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(9).getNombre() + "',"
				+ datosPartida.getCiudades().get(9).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(10).getNombre() + "',"
				+ datosPartida.getCiudades().get(10).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(11).getNombre() + "',"
				+ datosPartida.getCiudades().get(11).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(12).getNombre() + "',"
				+ datosPartida.getCiudades().get(12).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(13).getNombre() + "',"
				+ datosPartida.getCiudades().get(13).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(14).getNombre() + "',"
				+ datosPartida.getCiudades().get(14).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(15).getNombre() + "',"
				+ datosPartida.getCiudades().get(15).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(16).getNombre() + "',"
				+ datosPartida.getCiudades().get(16).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(17).getNombre() + "',"
				+ datosPartida.getCiudades().get(17).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(18).getNombre() + "',"
				+ datosPartida.getCiudades().get(18).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(19).getNombre() + "',"
				+ datosPartida.getCiudades().get(19).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(20).getNombre() + "',"
				+ datosPartida.getCiudades().get(20).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(21).getNombre() + "',"
				+ datosPartida.getCiudades().get(21).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(22).getNombre() + "',"
				+ datosPartida.getCiudades().get(22).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(23).getNombre() + "',"
				+ datosPartida.getCiudades().get(23).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(24).getNombre() + "',"
				+ datosPartida.getCiudades().get(24).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(25).getNombre() + "',"
				+ datosPartida.getCiudades().get(25).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(26).getNombre() + "',"
				+ datosPartida.getCiudades().get(26).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(27).getNombre() + "',"
				+ datosPartida.getCiudades().get(27).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(28).getNombre() + "',"
				+ datosPartida.getCiudades().get(28).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(29).getNombre() + "',"
				+ datosPartida.getCiudades().get(29).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(30).getNombre() + "',"
				+ datosPartida.getCiudades().get(30).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(31).getNombre() + "',"
				+ datosPartida.getCiudades().get(31).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(32).getNombre() + "',"
				+ datosPartida.getCiudades().get(32).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(33).getNombre() + "',"
				+ datosPartida.getCiudades().get(33).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(34).getNombre() + "',"
				+ datosPartida.getCiudades().get(34).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(35).getNombre() + "',"
				+ datosPartida.getCiudades().get(35).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(36).getNombre() + "',"
				+ datosPartida.getCiudades().get(36).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(37).getNombre() + "',"
				+ datosPartida.getCiudades().get(37).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(38).getNombre() + "',"
				+ datosPartida.getCiudades().get(38).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(39).getNombre() + "',"
				+ datosPartida.getCiudades().get(39).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(40).getNombre() + "',"
				+ datosPartida.getCiudades().get(40).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(41).getNombre() + "',"
				+ datosPartida.getCiudades().get(41).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(42).getNombre() + "',"
				+ datosPartida.getCiudades().get(42).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(43).getNombre() + "',"
				+ datosPartida.getCiudades().get(43).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(44).getNombre() + "',"
				+ datosPartida.getCiudades().get(44).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(45).getNombre() + "',"
				+ datosPartida.getCiudades().get(45).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(46).getNombre() + "',"
				+ datosPartida.getCiudades().get(46).getInfeccion() + "),Ciudad('"
				+ datosPartida.getCiudades().get(47).getNombre() + "',"
				+ datosPartida.getCiudades().get(47).getInfeccion() + ")" 
				+ "),VacunaTabla(Vacuna('"
				+ datosPartida.getVacunas().get(0).getArma() + "'," + datosPartida.getVacunas().get(0).getPorcentaje()
				+ "),Vacuna('" + datosPartida.getVacunas().get(1).getArma() + "',"
				+ datosPartida.getVacunas().get(1).getPorcentaje() + "),Vacuna('"
				+ datosPartida.getVacunas().get(2).getArma() + "'," + datosPartida.getVacunas().get(2).getPorcentaje()
				+ "),Vacuna('"+datosPartida.getVacunas().get(3).getArma()+"',"+datosPartida.getVacunas().get(3).getPorcentaje()+"))," + datosPartida.getBrotes() + "," + datosPartida.getRondas() + "," + datosPartida.getAcciones()
				+ ", SYS.ODCINUMBERLIST(" + datosPartida.getDerCon(0) + "," + datosPartida.getDerCon(1) + ","
				+ datosPartida.getDerCon(2) + "," + datosPartida.getDerCon(3) + "," + datosPartida.getDerCon(4)
				+ ")))";
		bbdd.insert(con, a);
		System.out.println(a);

	}

	public int calcularPuntuajeFinal() {
		total = contadorInfeccions * 2;
		total = total + contadorPartida * 1000;
		total = total + contadorBrotes * 10;
		total = total + contadorTurnos * 5;
		total = total + contadorInvestigacions * 20;
		total = total + contadorMatar * 10;

		return total;
	};

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

	public boolean estadoPej(DatosPartida datosPartida, int i) {
		for (Personaje personaje : datosPartida.getPersonajes()) {
			if (personaje.getCooldown() == 0 && personaje.getRol() == i) {
				return true;
			}
		}
		return false;
	}

	public void gestionarTurno(DatosPartida datosPartida, int valor_momento) {
		contadorTurnos++;
		actualizarEstado(datosPartida);
		datosPartida.setRondas(datosPartida.getRondas() + 1);
		datosPartida.setAcciones(4);
		Random random = new Random();
		int[] ciudades_ya = new int[(int) datosPartida.getDerCon(valor_momento)];

		for (int i = 0; i < ciudades_ya.length; i++) {
			int indiceAleatorio;
			do {
				indiceAleatorio = random.nextInt(datosPartida.getCiudades().size());
			} while (esCiudadYaSeleccionada(ciudades_ya, indiceAleatorio, i));

			ciudades_ya[i] = indiceAleatorio;

			Ciudad ciudadAleatoria = datosPartida.getCiudades().get(indiceAleatorio);
			gestionarInfeccion(datosPartida, ciudadAleatoria.getNombre(), datosPartida.getDerCon(4));
			String datos = "Se ha infectado " + ciudadAleatoria.getNombre() + " " + ciudadAleatoria.getInfeccion();
			Panel_Partida.GuardarDatos(datos);

		}
		gestionarBrote(datosPartida);
	}

	private boolean esCiudadYaSeleccionada(int[] ciudades_ya, int indiceAleatorio, int indiceActual) {
		for (int j = 0; j < indiceActual; j++) {
			if (ciudades_ya[j] == indiceAleatorio) {
				return true;
			}
		}
		return false;
	}

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

	public void gestionarInfeccion(DatosPartida datosPartida, String nCiudad, int f) {
		contadorInfeccions++;
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.getNombre().equals(nCiudad)) {
				ciudad.setInfeccion(ciudad.getInfeccion() + f);
			}
		}
	}

	public void gestionarBrote(DatosPartida datosPartida) {
		contadorBrotes++;
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.propagarInfeccion() && !ciudad.isActivado()) {
				ciudad.setActivado(true);
				datosPartida.setBrotes(datosPartida.getBrotes() + 1);
				for (String ciudadColindante : ciudad.getCiudadesColindantes()) {
					gestionarInfeccion(datosPartida, ciudadColindante, datosPartida.getDerCon(4));
				}
			}
		}
	}

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

	public boolean gestionarFinPartida(DatosPartida datosPartida) {
		if (datosPartida.getBrotes() >= datosPartida.getDerCon(2)) {
			return true;
		}
		return false;
	}

	public void gestionarCura(DatosPartida datosPartida) {
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.getPorcentaje() >= 100 && !vacuna.isEstado()) {
				vacuna.setEstado(true);
			}
		}
	}
}