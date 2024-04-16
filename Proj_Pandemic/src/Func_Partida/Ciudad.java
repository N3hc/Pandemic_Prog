package Func_Partida;

import java.util.Arrays;

public class Ciudad {
	private String nombre;
	private int[] coordenadas;
	private String enfermedad;
	private int infeccion;
	private String[] CiudadesColindantes;

	public Ciudad(String nombre, int[] Coordenadas, String Enfermedad, String[] CiudadesColindantes) {
		setEnfermedad(Enfermedad);
		setCoordenadas(Coordenadas);
		setNombre(nombre);
		setInfeccion(0);
		setCiudadesColindantes(CiudadesColindantes);
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
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
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
	
	public void aumentarInfección (int valor) {
		setInfeccion(this.infeccion+valor);
	}
	
	public void disminuirInfeccion (int Valor) {
		setInfeccion(this.infeccion-Valor);
	}
	
	public boolean propagarInfeccion () {		
		if (this.infeccion > 3) {
			setInfeccion(3);
			return true;
		} else {
		return false;
		}
	}


	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", coordenadas=" + Arrays.toString(coordenadas) + ", Plaga="
				+ enfermedad + ", infeccion=" + infeccion + ", CiudadesColindantes="
				+ Arrays.toString(CiudadesColindantes) + "]";
	}
}
