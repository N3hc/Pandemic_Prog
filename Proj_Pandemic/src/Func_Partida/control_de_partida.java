package Func_Partida;

import java.util.Random;

import Swing.Panel_Partida;

public class control_de_partida {

	
	public void iniciarPartida() {

	}

	public void iniciarPartidaGuardada(String id) {

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
	        String datos = "Se ha infectado "+ciudadAleatoria.getNombre();
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
	
	public void ciudadesCura(DatosPartida datosPartida, String Ciudad) {
		datosPartida.setAcciones(datosPartida.getAcciones()-1);
	    for (Ciudad ciudad : datosPartida.getCiudades()) {
	        if (ciudad.getNombre().equals(Ciudad)) {
	            boolean com = false;
	            for (Vacuna vacuna : datosPartida.getVacunas()) {
	                if (ciudad.getInfeccion() > 0 && !com) {
	                    if ((ciudad.getEnfermedad().equals("Tritones") && vacuna.getColor().equals("Azul")) ||
	                        (ciudad.getEnfermedad().equals("Antarboles") && vacuna.getColor().equals("Verde")) ||
	                        (ciudad.getEnfermedad().equals("Goblos") && vacuna.getColor().equals("Rojo")) ||
	                        (ciudad.getEnfermedad().equals("Momias") && vacuna.getColor().equals("Negro"))) {
	                        if (vacuna.isEstado()) {
	                            ciudad.setInfeccion(0);
	                        } else {
	                            ciudad.setInfeccion(ciudad.getInfeccion() - 1);
	                        }
	                        com = true;
	                    }
	                }
	            }
	        }
	    }
	}

	public void gestionarVacuna(DatosPartida datosPartida, String nVacuna) {
		for (Vacuna vacuna : datosPartida.getVacunas()) {
			if (vacuna.getArma().equals(nVacuna)) {
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
			if (ciudad.propagarInfeccion() && !ciudad.isActivado()) {
				ciudad.setActivado(true);
				datosPartida.setBrotes(datosPartida.getBrotes() + 1);
				for (String ciudadColindante : ciudad.getCiudadesColindantes()) {
	                gestionarInfeccion(datosPartida, ciudadColindante, datosPartida.getDerCon(4));
	            }
			}
		}
	}
	
	public void actualizarEstado (DatosPartida datosPartida) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			ciudad.setActivado(false);
		}
	}

	public boolean gestionarFinPartida(DatosPartida datosPartida) {
		if (datosPartida.getBrotes() > datosPartida.getDerCon(2) || datosPartida.getBrotes() == datosPartida.getDerCon(2)) {
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
