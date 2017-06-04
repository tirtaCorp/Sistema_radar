package cdu2.src.dominio;
public class Sancion {
	
	private int IDExpediente;
	private	String conductor;
	private double importe;
	private int puntos;
	private int IDSancion;
	private boolean pagada;
	
	public Sancion(int iDExpediente, String conductor, double importe, int puntos, int iDSancion) {
		IDExpediente = iDExpediente;
		this.conductor = conductor;
		IDSancion = iDSancion;
		this.importe=importe;
		this.puntos=puntos;
		
		pagada=false;
	}
	
	public int getPuntos() {
	}
	public void setPuntos(int puntos) {
	}
	public int getIDExpediente() {
	}
	public String getConductor() {
	}
	public double getImporte() {
	}
	public int getIDSancion() {
	
}
