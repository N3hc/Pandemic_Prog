package Func_Partida;

import java.util.ArrayList;

public class DatosPartida {
	private ArrayList<Ciudad> ciudades = new ArrayList<>();
	private ArrayList<Virus> virus = new ArrayList<>();
	private ArrayList<Vacuna> vacunas = new ArrayList<>();
	private ArrayList<personaje> personajes = new ArrayList<>();
	private int brotes;
	private int rondas;
	private float pDesarrollo;
	private int acciones;


	public DatosPartida (int dificultad) {
		this.cargarDatos();
		this.setpDesarrollo((float)(Math.random()*5)*dificultad);
	}
	
	public void modificarCiudad(String nCiudad, int modificacion) {
		for (Ciudad ciudad : this.ciudades) {
			if (ciudad.getNombre().equals(nCiudad)) {
				ciudad.aumentarInfección(modificacion);
			}		

	}
	}
	
	public void modificarVacuna (String nVacuna, float modificacion) {
		for(Vacuna vacuna : this.getVacunas()) {
			if (vacuna.getNombre().equals(nVacuna)) {
				vacuna.setPorcentaje(modificacion);
			}
		}
	}

	public void cargarDatos() {
    
		this.setCiudades(control_de_datos.cargarCiudades());
		this.setVacunas(control_de_datos.cargarVacunas());
		this.setVirus(control_de_datos.cargarVirus());
		this.setBrotes(0);
		this.setRondas(0);
		this.setAcciones(4);
		
	}
	
	public void aumentarBrote() {
		for (Ciudad ciudad : this.ciudades) {
			if(ciudad.propagarInfeccion()) {
				this.setBrotes(1);
			}
		}
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
		this.brotes += brotes;
	}

	public int getRondas() {
		return rondas;
	}

	public void setRondas(int rondas) {
		this.rondas = rondas;
	}

	public float getpDesarrollo() {
		return pDesarrollo;
	}

	public void setpDesarrollo(float pDesarrollo) {
		this.pDesarrollo = pDesarrollo;
	}

	public int getAcciones() {
		return acciones;
	}

	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}

	public ArrayList<personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<personaje> personajes) {
		this.personajes = personajes;
	}
}
