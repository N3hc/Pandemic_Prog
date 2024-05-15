package Func_Partida;

import java.util.Arrays;
/**
 * Representa una ciudad en el juego con sus atributos y métodos para gestionar infecciones y relaciones con otras ciudades.
 */
public class Ciudad {
	private String nombre;
	private int[] coordenadas;
	private String plaga;
	private int infeccion;
	private String[] CiudadesColindantes;
	private boolean activado;

	/**
	 * Constructor de la clase Ciudad para la generación de ciudades.
	 * 
	 * @param nombre Nombre del lugar.
	 * @param coordenadas Coordenadas donde se sitúan.
	 * @param plaga Enfermedad que afecta a la ciudad.
	 * @param CiudadesColindantes Ciudades colindantes a esta ciudad.
	 */
	public Ciudad(String nombre, int[] coordenadas, String plaga, String[] CiudadesColindantes) {
		setEnfermedad(plaga);
		setCoordenadas(coordenadas);
		setNombre(nombre);
		setInfeccion(0);
		setCiudadesColindantes(CiudadesColindantes);
		setActivado(false);
	}

	/**
	 * Obtiene el nombre de la ciudad.
	 * 
	 * @return El nombre de la ciudad.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la ciudad.
	 * 
	 * @param nombre El nombre de la ciudad.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene las coordenadas de la ciudad.
	 * 
	 * @return Las coordenadas de la ciudad.
	 */
	public int[] getCoordenadas() {
		return coordenadas;
	}

	/**
	 * Establece las coordenadas de la ciudad.
	 * 
	 * @param coordenadas Las coordenadas de la ciudad.
	 */
	public void setCoordenadas(int[] coordenadas) {
		this.coordenadas = coordenadas;
	}

	/**
	 * Obtiene la enfermedad que afecta a la ciudad.
	 * 
	 * @return La enfermedad de la ciudad.
	 */
	public String getEnfermedad() {
		return plaga;
	}

	/**
	 * Establece la enfermedad que afecta a la ciudad.
	 * 
	 * @param enfermedad La enfermedad de la ciudad.
	 */
	public void setEnfermedad(String enfermedad) {
		this.plaga = enfermedad;
	}

	/**
	 * Obtiene el nivel de infección de la ciudad.
	 * 
	 * @return El nivel de infección de la ciudad.
	 */
	public int getInfeccion() {
		return infeccion;
	}

	/**
	 * Establece el nivel de infección de la ciudad.
	 * 
	 * @param infeccion El nivel de infección de la ciudad.
	 */
	public void setInfeccion(int infeccion) {
		this.infeccion = infeccion;
	}

	/**
	 * Obtiene las ciudades colindantes a esta ciudad.
	 * 
	 * @return Las ciudades colindantes.
	 */
	public String[] getCiudadesColindantes() {
		return CiudadesColindantes;
	}

	/**
	 * Establece las ciudades colindantes a esta ciudad.
	 * 
	 * @param ciudadesColindantes Las ciudades colindantes.
	 */
	public void setCiudadesColindantes(String[] ciudadesColindantes) {
		CiudadesColindantes = ciudadesColindantes;
	}

	/**
	 * Comprueba las infecciones de la ciudad. Si hay más de tres, devuelve true.
	 * 
	 * @return Devuelve un booleano indicando si la infección se ha propagado (true) o no (false).
	 */
	public boolean propagarInfeccion() {
		if (this.infeccion > 3) {
			setInfeccion(3);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Obtiene el estado de activación de la ciudad.
	 * 
	 * @return true si la ciudad está activada, false en caso contrario.
	 */
	public boolean isActivado() {
		return activado;
	}

	/**
	 * Establece el estado de activación de la ciudad.
	 * 
	 * @param activado El estado de activación de la ciudad.
	 */
	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", coordenadas=" + Arrays.toString(coordenadas) + ", Plaga=" + plaga
				+ ", infeccion=" + infeccion + ", CiudadesColindantes=" + Arrays.toString(CiudadesColindantes) + "]";
	}
}
