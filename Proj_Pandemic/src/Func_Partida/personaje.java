package Func_Partida;

public class personaje {
	private String nombre;
	private	String posActual;
	private int rol;
	private static int cooldown;
	
	public static void pasiva(int rol) {
		
	}
	public static int reduccionCooldown() {
		return cooldown;
	} 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public String getPosActual() {
		return posActual;
	}
	public void setPosActual(String posActual) {
		this.posActual = posActual;
	}
	@Override
	public String toString() {
		return "personaje [nombre=" + nombre + ", posActual=" + posActual + ", rol=" + rol + "]";
	}
}
