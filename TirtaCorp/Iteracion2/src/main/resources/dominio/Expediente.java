package cdu2.src.dominio;
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
	}
	public double getVelocidad() {
	}
	public int getLimiteVelocidad() {
	}
	public String getLugar() {
	}
	public String getPropietario() {
	}
	public int getID(){
	}
	public boolean isSancionado(){
	}
	public void sancionar(){
	}
	public String toString(){
	}
}
