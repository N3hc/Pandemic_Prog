package Func_Partida;

import java.util.Random;

public class control_de_partida {
	public void iniciarPartida() {
		
	}
	public void iniciarPartidaGuardada(String id) {
		
	}
	public void gestionarTurno(DatosPartida datosPartida, int valor_momento) {
		datosPartida.setRondas(datosPartida.getRondas()+1);
		Random random = new Random();
		int [] ciudades_ya = new int [(int) datosPartida.getDerCon(valor_momento)];
		for (int i = 0; i < datosPartida.getDerCon(valor_momento); i++) {
			int indiceAleatorio = random.nextInt(datosPartida.getCiudades().size());
			for (int j = 0; j < datosPartida.getDerCon(valor_momento); j++ ) {
				while(ciudades_ya[j] == indiceAleatorio) {
					indiceAleatorio = random.nextInt(datosPartida.getCiudades().size());
				}
				ciudades_ya[i] = indiceAleatorio;
			}
	        Ciudad ciudadAleatoria = datosPartida.getCiudades().get(indiceAleatorio);
			gestionarInfeccion(datosPartida, ciudadAleatoria.getNombre(), (int) datosPartida.getDerCon(4));
		}
	}
	public void gestionarVacuna(DatosPartida datosPartida, String nVacuna) {
		for(Vacuna vacuna : datosPartida.getVacunas()) {
			if(vacuna.getColor().equals(nVacuna)) {
		vacuna.setPorcentaje(datosPartida.getDerCon(3));
			}
		}
	}
	public void gestionarInfeccion(DatosPartida datosPartida, String nCiudad, int inf) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if (ciudad.getNombre().equals(nCiudad)) {
				ciudad.modificarInfección(inf);
			}
		}
	}
	public void gestionarBrote(DatosPartida datosPartida) {
		for (Ciudad ciudad : datosPartida.getCiudades()) {
			if(ciudad.propagarInfeccion() || !ciudad.isActivado()) {
				ciudad.setActivado(true);
				datosPartida.setBrotes(datosPartida.getBrotes()+1);
			}
		}
	}
	public boolean gestionarFinPartida(DatosPartida datosPartida) {
		if(datosPartida.getBrotes() >= datosPartida.getDerCon(2)) {
			return true;
		}
		return false;
	}
	public void gestionarHeroes () {
		
	}
	public void gestionarCura(DatosPartida datosPartida) {
		for(Vacuna vacuna : datosPartida.getVacunas()) {
			if(vacuna.getPorcentaje()>= 100) {
				vacuna.setEstado(true);
			}
		}
	}
}
