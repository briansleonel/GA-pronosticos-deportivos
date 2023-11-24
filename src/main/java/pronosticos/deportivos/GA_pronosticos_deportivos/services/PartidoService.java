package pronosticos.deportivos.GA_pronosticos_deportivos.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pronosticos.deportivos.GA_pronosticos_deportivos.Conexion;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;

public class PartidoService {
	private Conexion conexion = new Conexion();
	private EquipoService equipoService = new EquipoService();

	public Partido getPartidoById(int id) throws SQLException {
		Connection cnn = null;
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			String query = "SELECT * FROM partidos WHERE id = " + id + ";";
			ResultSet rs = stm.executeQuery(query);

			Partido partido = new Partido();

			if (rs.next()) {
				Equipo equipo1 = equipoService.getEquipoById(rs.getInt("equipo_1"));
				Equipo equipo2 = equipoService.getEquipoById(rs.getInt("equipo_2"));

				partido.setId(Integer.parseInt(rs.getString("id")));
				partido.setEquipo1(equipo1);
				partido.setEquipo2(equipo2);
				partido.setGolesEquipo1(rs.getInt("goles_equipo_1"));
				partido.setGolesEquipo2(rs.getInt("goles_equipo_2"));
				partido.setRonda(rs.getInt("ronda_id"));
			}
			return partido;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			cnn.close();
		}
		return null;
	}
}
