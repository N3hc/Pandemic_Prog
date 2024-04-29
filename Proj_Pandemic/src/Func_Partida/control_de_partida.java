package Func_Partida;

import java.util.Random;

public class control_de_partida {
	public void iniciarPartida() {

	}

	public void iniciarPartidaGuardada(String id) {

	}

	public void gestionarTurno(DatosPartida datosPartida, int valor_momento) {
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
	    }
	    
	}
	
	private boolean esCiudadYaSeleccionada(int[] ciudades_ya, int indiceAleatorio, int indiceActual) {
	    for (int j = 0; j < indiceActual; j++) {
	        if (ciudades_ya[j] == indiceAleatorio) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void ciudadesCura (DatosPartida datosPartida, String Ciudad) {
		boolean com;
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.getNombre().equals(Ciudad)) {
				com = false;
				for (Vacuna vacuna : datosPartida.getVacunas()) {
					if (ciudad.getInfeccion()> 0) {
					if((ciudad.getEnfermedad().equals("Tritones") && vacuna.getColor().equals("Azul")) && vacuna.isEstado() && com == false) {
						ciudad.setInfeccion(0);
<<<<<<< HEAD
						System.out.println("1");
					} else {
=======
						com = true;
					} else if (!com) {
>>>>>>> e925adc8bcc29a35e0c09e7f8509692a77db9b34
						ciudad.setInfeccion(ciudad.getInfeccion()-1);
						com = true;
					}
					if((ciudad.getEnfermedad().equals("Antarboles") && vacuna.getColor().equals("Verde")) && vacuna.isEstado() && com == false) {
						ciudad.setInfeccion(0);
<<<<<<< HEAD
						System.out.println("2");
					} else {
=======
						com = true;
					} else if (!com) {
>>>>>>> e925adc8bcc29a35e0c09e7f8509692a77db9b34
						ciudad.setInfeccion(ciudad.getInfeccion()-1);
						com = true;
					}
					if((ciudad.getEnfermedad().equals("Goblos") && vacuna.getColor().equals("Rojo")) && vacuna.isEstado() && com == false) {
						ciudad.setInfeccion(0);
<<<<<<< HEAD
						System.out.println("3");
					} else {
=======
						com = true;
					} else if(!com) {
>>>>>>> e925adc8bcc29a35e0c09e7f8509692a77db9b34
						ciudad.setInfeccion(ciudad.getInfeccion()-1);
						com = true;
					}
					if((ciudad.getEnfermedad().equals("Momias") && vacuna.getColor().equals("Negro")) && vacuna.isEstado() && com == false) {
						ciudad.setInfeccion(0);
<<<<<<< HEAD
						System.out.println("4");
					} else {
						ciudad.setInfeccion(ciudad.getInfeccion()-1);
						System.out.println("cosa");
=======
						com = true;
					} else if(!com) {
						ciudad.setInfeccion(ciudad.getInfeccion()-1);
						com = true;
>>>>>>> e925adc8bcc29a35e0c09e7f8509692a77db9b34
					}
					}
				}
			}
		}
		
	}

	public void gestionarVacuna(DatosPartida datosPartida, String nVacuna) {
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.getColor().equals(nVacuna)) {
				System.out.println("cosa");
				vacuna.setPorcentaje(vacuna.getPorcentaje()+datosPartida.getDerCon(3));
			}
		}
	}

	public void gestionarInfeccion(DatosPartida datosPartida, String nCiudad, int f) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.getNombre().equals(nCiudad)) {
				ciudad.setInfeccion(ciudad.getInfeccion()+f);
			}
		}
	}

	public void gestionarBrote(DatosPartida datosPartida) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.propagarInfeccion() || !ciudad.isActivado()) {
				ciudad.setActivado(true);
				datosPartida.setBrotes(datosPartida.getBrotes() + 1);
			}
		}
	}

	public boolean gestionarFinPartida(DatosPartida datosPartida) {
		if (datosPartida.getBrotes() >= datosPartida.getDerCon(2)) {
			return true;
		}
		return false;
	}

	public void gestionarHeroes() {

	}

	public void gestionarCura(DatosPartida datosPartida) {
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.getPorcentaje() >= 100) {
				vacuna.setEstado(true);
			}
		}
	}
}
