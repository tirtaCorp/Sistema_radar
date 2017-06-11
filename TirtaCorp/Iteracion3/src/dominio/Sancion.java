package cdu3.src.dominio;

public class Sancion {
	private int IDExpediente;
	private int IDSancion;
	private String conductor;
	private double importe;
	private int puntos;
	private boolean pagada;
	
	public Sancion(int iDExpediente, String conductor, double importe, int puntos, int iDSancion) {
		IDExpediente = iDExpediente;
		this.conductor = conductor;
		IDSancion = iDSancion;
		this.importe=importe;
		this.puntos=puntos;
		
		pagada=false;
	}
	
	public void setMulta(double importe){
		
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getIDExpediente() {
		return IDExpediente;
	}
	public int getID() {
		return IDSancion;
	}
	public String getConductor() {
		return conductor;
	}
	public double getImporte() {
		return importe;
	}
	public boolean isPagada() {
		return pagada;
	}
	public void pagar(){
		pagada = true;
	}
	
	public String toString(){
		return "Sación nº "+IDSancion;
	}
}
