package Func_Partida;

public class personaje {
	private String nombre;
	private String posActual;
	private int rol;
	private int cooldown;
		String[] nombres = { "Guerrero", "Exploradora", "Hechicera", "Berserker", "Domadora", "Musa", "Maehwa", "Valquiria",
			"Kunoichi", "Ninja", "Mago", "Maga", "Luchador", "Misticaa", "Lahn", "Montaraz", "Adalid Oscura", "Shai",
			"Guardiana", "Hashashin", "Nova", "Sabio", "Corsaria", "Drakania", "Wusa", "Maegu", "Erudita" };
	
	public personaje (String Nombre) {
		this.setNombre(Nombre);
		this.setPosActual("");
		this.setRol((int) (Math.random()*3));
		this.setCooldown(0);

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
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
}
}
