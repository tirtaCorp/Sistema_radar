package cdu1.CrearExpediente.src.Dominio;

public class Expediente {

	private int id;
	private String matricula;
	private double velocidad;
	private int limiteVelocidad;
	private String lugar;
	private String propietario;
	
	public Expediente(int id, String matricula, double velocidad, int limiteVelocidad, String lugar, String propietario) {
		this.id = id;
		this.matricula = matricula;
		this.velocidad = velocidad;
		this.limiteVelocidad = limiteVelocidad;
		this.lugar = lugar;
		this.propietario = propietario;
	}

	public String getMatricula() {
		return matricula;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public int getLimiteVelocidad() {
		return limiteVelocidad;
	}

	public String getLugar() {
		return lugar;
	}

	public String getPropietario() {
		return propietario;
	}
	
	

}
