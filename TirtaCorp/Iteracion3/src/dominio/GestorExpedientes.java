package cdu3.src.dominio;


import java.util.ArrayList;

public class GestorExpedientes {
	private ArrayList<Expediente> expedientes;
	
	public GestorExpedientes(){
		expedientes = new ArrayList<Expediente>();
	}
	
	public void crearExpediente(int id, String matricula, double velocidad, int limiteVelocidad, String lugar, String propietario){
		Expediente exp = new Expediente(id, matricula, velocidad, limiteVelocidad, lugar, propietario);
		expedientes.add(exp);
	}
	
	public Expediente buscarExpediente(int id){
		return expedientes.get(id);
	}
	
	public Expediente[] getExpedientes(){
		Expediente[] exps = new Expediente [expedientes.size()];
		for(int i=0; i<expedientes.size(); i++){
			exps[i]=expedientes.get(i);
		}
		
		return exps;
	}
	//private void guardarExpediente() [en bbdd]
}
