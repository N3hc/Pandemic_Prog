package Func_Partida;

import java.util.ArrayList;

public class DatosPartida {
	private ArrayList<Ciudad> ciudades = new ArrayList<>();
	private ArrayList<Virus> virus = new ArrayList<>();
	private ArrayList<Vacunas> vacunas = new ArrayList<>();
	private ArrayList<personaje> personajes = new ArrayList<>();
	private int brotes;
	private int rondas;
	private float pDesarrollo;
	private int acciones;

	public void modificarCiudad(String nCiudad, int modificacion) {

	}

	public void modificarVacuna(String nVacuna, float modificacion) {

	}

	public void cargarDatos() {

	}

	public void aumentarBrote() {
		for (Ciudad ciudad : this.ciudades) {
			if (ciudad.propagarInfeccion()) {
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

	public ArrayList<Vacunas> getVacunas() {
		return vacunas;
	}

	public void setVacunas(ArrayList<Vacunas> vacunas) {
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
}
