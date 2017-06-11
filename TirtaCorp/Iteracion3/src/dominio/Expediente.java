package cdu3.src.dominio;
public class Expediente {
	
	private int ID;
	private String matricula;
	private double velocidad;
	private int limiteVelocidad;
	private String lugar;
	private String propietario;
	private boolean sancionado;
	
	public Expediente(int ID, String matricula, double velocidad, int limiteVelocidad, String lugar, String propietario) {
		this.ID=ID;
		this.matricula = matricula;
		this.velocidad = velocidad;
		this.limiteVelocidad = limiteVelocidad;
		this.lugar = lugar;
		this.propietario = propietario;
		
		sancionado=false;
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
	public int getID(){
		return ID;
	}
	public boolean isSancionado(){
		return sancionado;
	}
	public void sancionar(){
		sancionado=true;
	}
	public String toString(){
		return "Expediente nº "+ID;
	}
}
