package Func_Partida;

public class Ciudad {
	private String nombre;
	private int[] coordenadas;
	private String enfermedad;
	private int infeccion;
	private String[] CiudadesColindantes;

	public Ciudad(String nombre, int[] Coordenadas, String Enfermedad, int Infeccion, String[] CiudadesColindantes) {
		setEnfermedad(nombre);
		setCoordenadas(Coordenadas);
		setEnfermedad(Enfermedad);
		setInfeccion(Infeccion);
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
		if ((this.infeccion += valor) > 3) {
		setInfeccion(3);
		} else {
			setInfeccion(this.infeccion += valor);
		}
	}
	
	public void disminuirInfeccion (int Valor) {
		
	}
	
	public boolean propagarInfeccion () {
		return true;
	}
}
