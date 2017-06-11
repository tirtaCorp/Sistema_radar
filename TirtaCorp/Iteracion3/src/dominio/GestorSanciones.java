package cdu3.src.dominio;

import java.util.ArrayList;
import cdu3.src.persistencia.Agente;

public class GestorSanciones {
	private ArrayList<Sancion> sanciones;
	private Agente agenteSancion;
	private int id;
	
	public GestorSanciones(){
		sanciones=new ArrayList<Sancion>();
		id=0;
	}
	
	public void crearSancion(Expediente expediente){

	}
	
	private double calcularMulta(Expediente expediente){
	
	}
	
	private int calcularPuntos(Expediente expediente){
		
	}
	
	public Sancion buscarSancion(int ID){
	}
	
	public void pagar(Sancion san){
		
	}
	
	public Sancion[] getSanciones(){

	}

	public boolean guardarSancion(Sancion san){
		
	}
}
