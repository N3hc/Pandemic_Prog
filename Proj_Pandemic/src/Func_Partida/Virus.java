package Func_Partida;

public class Virus {
	private String Identificador;
	private String Nombre;
	private String Color;
	/**
	 * Constructor de Virus
	 * @param Identificador Número associado
	 * @param Nombre Nombre
	 * @param Color Color del virus
	 */
	public Virus (String Identificador, String Nombre, String Color){
		this.setIdentificador(Identificador);
		this.setNombre(Nombre);
		this.setColor(Color);
	}
	//Getters y Setters
	public String getIdentificador() {
		return Identificador;
	}
	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}

	@Override
	public String toString() {
		return "Virus [Identificador=" + Identificador + ", Plaga=" + Nombre + ", Color=" + Color + "]";
	}
}
