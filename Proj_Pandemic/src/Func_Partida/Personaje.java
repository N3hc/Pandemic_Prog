package Func_Partida;

public class Personaje {
	private String posActual;
	private int rol;
	private int cooldown;

	public Personaje () {
		this.setPosActual("");
		this.setRol((int) (Math.random()*3));
		this.setCooldown(0);
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
		return "personaje [posActual=" + posActual + ", rol=" + rol + "]";
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
}