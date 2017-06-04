package cdu2.src.dominio;

import java.util.ArrayList;
import cdu2.src.persistencia.Agente;

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
	
	public Sancion[] getSanciones(){
	}
	
	private boolean guardarSacion(Sancion san){
		
	}

	private String buscarConductor(int idExp){
		
	}
}
