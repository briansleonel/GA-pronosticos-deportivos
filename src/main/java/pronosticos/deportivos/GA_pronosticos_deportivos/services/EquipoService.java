package pronosticos.deportivos.GA_pronosticos_deportivos.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pronosticos.deportivos.GA_pronosticos_deportivos.Conexion;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;

public class EquipoService {
	private Conexion conexion = new Conexion();

	public Equipo getEquipoById(int id) throws SQLException {
		Connection cnn = null;
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			String query = "SELECT * FROM equipos WHERE id = " + id + ";";
			ResultSet rs = stm.executeQuery(query);

			Equipo equipo = new Equipo();

			if (rs.next()) {
				equipo.setId(Integer.parseInt(rs.getString("id")));
				equipo.setNombre(rs.getString("nombre"));
				equipo.setDescripcion(rs.getString("descripcion"));
			}

			return equipo;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			cnn.close();
		}
		return null;
	}
}
