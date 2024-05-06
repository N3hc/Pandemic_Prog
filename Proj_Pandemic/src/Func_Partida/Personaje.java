package Func_Partida;

public class Personaje {
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
		return "personaje [ rol=" + rol + " cooldown = "+cooldown+" ]";
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
}