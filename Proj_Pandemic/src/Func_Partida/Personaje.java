package Func_Partida;

public class Personaje {
	private String posActual;
	private int rol;
	private int cooldown;

	public Personaje (int i) {
		this.setRol(i);
		this.setCooldown(0);
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "personaje [posActual=" + posActual + ", rol=" + rol + "]";
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
}