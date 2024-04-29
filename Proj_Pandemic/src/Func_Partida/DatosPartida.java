	package Func_Partida;

import java.util.ArrayList;
import java.util.Arrays;

public class DatosPartida {
	private ArrayList<Ciudad> ciudades = new ArrayList<>();
	private ArrayList<Virus> virus = new ArrayList<>();
	private ArrayList<Vacuna> vacunas = new ArrayList<>();
	private ArrayList<Personaje> personajes = new ArrayList<>();
	private int brotes;
	private int rondas;
	private int acciones;
	private int[] DerCon;

	public void cargarDatos(String dific) {
		 String[] valoresDif = control_de_datos.Leer_Xml(dific);
		    int[] valoresInt = new int[valoresDif.length];
		    for (int i = 0; i < valoresDif.length; i++) {
		        valoresInt[i] = Integer.parseInt(valoresDif[i]);
		    }
		this.setDerCon(valoresInt);
		this.setCiudades(control_de_datos.cargarCiudades());
		this.setVacunas(control_de_datos.cargarVacunas());
		this.setVirus(control_de_datos.cargarVirus());
		this.setPersonajes(control_de_datos.cargarPersonajes());
		this.setBrotes(0);
		this.setRondas(0);
		this.setAcciones(4);
	}

	public String getVirusCiudad(String ciudadReq) {
		String virus = "";
		for (Ciudad ciudad : this.ciudades) {
			if (ciudad.getNombre().equals(ciudadReq)) {
				virus = ciudad.getEnfermedad();
			}
		}
		return virus;
	}
	
	public int getNivelInfeccionCiudad(String ciudadReq) {
		int nivel = 0;
		for (Ciudad ciudad : this.ciudades) {
			if (ciudad.getNombre().equals(ciudadReq)) {
				nivel = ciudad.getInfeccion();
			}
		}
		return nivel;
	}
	
	public int getNivelVacuna(String infeccion) {
		int nivel = 0;
		for (Vacuna vacuna : this.vacunas) {
			if (vacuna.getArma().equals(infeccion)) {
				nivel = (int) vacuna.getPorcentaje();
			}
		}
		return nivel;
	}
	
	public ArrayList<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public ArrayList<Virus> getVirus() {
		return virus;
	}

	public void setVirus(ArrayList<Virus> virus) {
		this.virus = virus;
	}

	public ArrayList<Vacuna> getVacunas() {
		return vacunas;
	}

	public void setVacunas(ArrayList<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

	public int getBrotes() {
		return brotes;
	}

	public void setBrotes(int brotes) {
		this.brotes = brotes;
	}

	public int getRondas() {
		return rondas;
	}

	public void setRondas(int rondas) {
		this.rondas = rondas;
	}

	public int getAcciones() {
		return acciones;
	}

	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}

	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

	public int getDerCon(int i) {
		return DerCon[i];
	}

	public void setDerCon(int[] valoresFloat) {
		DerCon = valoresFloat;
	}

	@Override
	public String toString() {
		return "DatosPartida [ciudades=" + ciudades + ", virus=" + virus + ", vacunas=" + vacunas + ", personajes="
				+ personajes + ", brotes=" + brotes + ", rondas=" + rondas + ", acciones=" + acciones + ", DerCon="
				+ Arrays.toString(DerCon) + "]";
	}
}
