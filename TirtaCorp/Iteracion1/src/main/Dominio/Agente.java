package cdu1.CrearExpediente.src.Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Agente {
	String userName;
	String password;
	String portNumber;
	
	String serverName;
	String dbName;
	String dbms;
	
	public Agente (){
	}
	
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    if (this.dbms.equals("mysql")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + "://" +
	                   this.serverName +
	                   ":" + this.portNumber + "/",
	                   connectionProps);
	    } else if (this.dbms.equals("derby")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + ":" +
	                   this.dbName +
	                   ";create=true",
	                   connectionProps);
	    }
	    System.out.println("Connected to database");
	    return conn;
	}
}


