package Func_Partida;

import java.util.Random;

import Swing.Panel_Partida;

public class control_de_partida {

	public void iniciarPartida() {

	}

	public void iniciarPartidaGuardada(String id) {

	}

	public boolean ganarPartida(DatosPartida datosPartida) {
		int i = 0;
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.isEstado()) {
				i++;
			}
		}
		if (i == 4) {
			return true;
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
		gestionarCura(datosPartida);
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
		actualizarEstado(datosPartida);
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
									vacuna.setPorcentaje(vacuna.getPorcentaje()+5);
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
		try {
			String datos = "";
			if (!nVacuna.equals(null)) {
				if (datosPartida.getAcciones() == 4) {
					for (Vacuna vacuna : datosPartida.getVacunas()) {
						if (vacuna.getArma().equals(nVacuna) && !vacuna.isEstado()) {
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
					return true;
				}
			}

		} catch (NullPointerException e) {
			System.out.println("Se ha producido un NullPointerException");
		}
		return false;
	}

	public void gestionarInfeccion(DatosPartida datosPartida, String nCiudad, int f) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.getNombre().equals(nCiudad)) {
				ciudad.setInfeccion(ciudad.getInfeccion() + f);
			}
		}
	}

	public void gestionarBrote(DatosPartida datosPartida) {
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
			ciudad.setActivado(false);
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
			if (vacuna.getPorcentaje() >= 100) {
				vacuna.setEstado(true);
			}
		}
	}
}
