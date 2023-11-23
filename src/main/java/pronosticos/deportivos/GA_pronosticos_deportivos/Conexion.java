package pronosticos.deportivos.GA_pronosticos_deportivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String DB = "pronostico_deportivo";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB;
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch(ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
		} 
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion=DriverManager.getConnection(URL, USUARIO, PASSWORD);
			if(conexion != null) {
				System.out.println("Conexion Exitosa a la DB: " + DB);
			}
		}
			catch(SQLException e) {
			System.out.println("Error en la conexión");
		}
		
		return conexion;
	}
}
