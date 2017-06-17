package cdu4.src.persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Agente {

	protected static Agente mInstancia = null;
	protected Connection mBD;
	protected String driver = "com.mysql.jdbc.Driver";
	protected String url = "sun.jdbc.odbc.JdbcOdbcDriver";

	protected Agente() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		mBD = (Connection) DriverManager.getConnection(url);
	}
	
	public Connection getBD() throws SQLException {
		if(mBD.isClosed())
			mBD = (Connection) DriverManager.getConnection(url);
		return mBD;
	}
	public void getAgente(){
		
	}
	public void desconectar(){
		
	}
//	public int insert(){
//		
//	}
//	public int delete(){
//		
//	}
//	public int update(){
//		
//	}
//	public int select(){
//		
//	}
}