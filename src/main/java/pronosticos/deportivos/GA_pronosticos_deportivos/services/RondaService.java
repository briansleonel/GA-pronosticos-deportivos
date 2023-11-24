package pronosticos.deportivos.GA_pronosticos_deportivos.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pronosticos.deportivos.GA_pronosticos_deportivos.Conexion;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Ronda;

public class RondaService {
	private Conexion conexion = new Conexion();
	private PartidoService partidoService = new PartidoService();

	public Ronda getRondaById(int id) throws SQLException {
		Connection cnn = null;
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			String query = "SELECT p.id as partido_id , p.ronda_id, R.id as nro FROM pronostico_deportivo.partidos AS P INNER JOIN pronostico_deportivo.rondas as R ON R.id = P.ronda_id and R.id = "
					+ id + ";";
			ResultSet rs = stm.executeQuery(query);

			Ronda ronda = new Ronda();

			while (rs.next()) {
				Partido partido = partidoService.getPartidoById(rs.getInt("partido_id"));
				ronda.agregarPartido(partido);

				if (ronda.getId() == null) {
					ronda.setNro(rs.getInt("nro"));
					ronda.setId(rs.getInt("ronda_id"));
				}
			}

			return ronda;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			cnn.close();
		}
		return null;
	}
}
