package pronosticos.deportivos.GA_pronosticos_deportivos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.LectorArchivoService;

public class TestConexion {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		List<Equipo> listadoEquipos = new ArrayList<>();;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM Equipo");
			
			
			while(rs.next()) {
				Equipo equipo = new Equipo(rs.getString("nombre"), rs.getString("descripcion"));
				listadoEquipos.add(equipo);
			}
			
			for (Equipo e : listadoEquipos)
	            System.out.println(e);
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stm != null) {
					stm.close();
				}
				if(cn != null) {
					cn.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
