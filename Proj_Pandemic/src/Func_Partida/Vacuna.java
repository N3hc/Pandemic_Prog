package Func_Partida;

public class Vacuna {
	private String color;
	private String arma;
	private int porcentaje;
	private boolean estado;
	
	public Vacuna (String Color, String Nombre) {
		this.setColor(Color);
		this.setArma(Nombre);
		this.setPorcentaje(0);
		this.setEstado(false);
	}
	
	public void desarrollarVacuna ( float porcentage) {
		setPorcentaje(this.porcentaje+porcentaje);		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String nombre) {
		this.color = nombre;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String color) {
		this.arma = color;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Vacuna [Color= " + color + ", Arma= " + arma + ", porcentaje= " + porcentaje + "]";
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
