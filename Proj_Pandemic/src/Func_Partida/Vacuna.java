package Func_Partida;

public class Vacuna {
	private String nombre;
	private String color;
	private float porcentaje;
	
	public Vacuna (String Nombre, String Color) {
		this.setNombre(Nombre);
		this.setColor(Color);
		this.setPorcentaje(0);
	}
	
	public void desarrollarVacuna ( float porcentage) {
		setPorcentaje(this.porcentaje+porcentaje);		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje += porcentaje;
	}

	@Override
	public String toString() {
		return "Vacuna [Color= " + nombre + ", Arma= " + color + ", porcentaje= " + porcentaje + "]";
	}

}
