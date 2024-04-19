package Func_Partida;

import java.util.Arrays;

public class Ciudad {
	private String nombre;
	private int[] coordenadas;
	private String plaga;
	private int infeccion;
	private String[] CiudadesColindantes;
	private boolean activado ;

	public Ciudad(String nombre, int[] Coordenadas, String Enfermedad, String[] CiudadesColindantes) {
		setEnfermedad(Enfermedad);
		setCoordenadas(Coordenadas);
		setNombre(nombre);
		setInfeccion(0);
		setCiudadesColindantes(CiudadesColindantes);
		setActivado(false);
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(int[] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getEnfermedad() {
		return plaga;
	}

	public void setEnfermedad(String enfermedad) {
		this.plaga = enfermedad;
	}

	public int getInfeccion() {
		return infeccion;
	}

	public void setInfeccion(int infeccion) {
		this.infeccion = infeccion;
	}

	public String[] getCiudadesColindantes() {
		return CiudadesColindantes;
	}

	public void setCiudadesColindantes(String[] ciudadesColindantes) {
		CiudadesColindantes = ciudadesColindantes;
	}
	
	public void modificarInfección (int valor) {
		setInfeccion(this.infeccion+valor);
	}

	public boolean propagarInfeccion () {		
		if (this.infeccion > 3) {
			setInfeccion(3);
			return true;
		} else {
		return false;
		}
	}
	
	public boolean isActivado() {
		return activado;
	}

	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", coordenadas=" + Arrays.toString(coordenadas) + ", Plaga="

				+ plaga + ", infeccion=" + infeccion + ", CiudadesColindantes="

				+ Arrays.toString(CiudadesColindantes) + "]";
	}

}
