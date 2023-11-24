package pronosticos.deportivos.GA_pronosticos_deportivos.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pronosticos.deportivos.GA_pronosticos_deportivos.Conexion;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.ResultadoEnum;

public class PronosticoService {
	Conexion conexion = new Conexion();
	EquipoService equipoService = new EquipoService();
	PartidoService partidoService = new PartidoService();

	public List<Pronostico> getAllPronosticos() throws SQLException {
		Connection cnn = null;
		List<Pronostico> pronosticos = new ArrayList<>();
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM pronosticos");

			while (rs.next()) {
				Pronostico pronostico = new Pronostico();
				Equipo equipo = equipoService.getEquipoById(rs.getInt("equipo_id"));
				Partido partido = partidoService.getPartidoById(rs.getInt("partido_id"));

				pronostico.setId(rs.getInt("id"));
				pronostico.setEquipo(equipo);
				pronostico.setPartido(partido);
				pronostico.setResultado(getResultado(rs.getString("resultado")));
				
				pronosticos.add(pronostico);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			cnn.close();
		}
		return pronosticos;
	}

	public List<Pronostico> getPronosticosByUsuarioId(int id) throws SQLException {
		Connection cnn = null;
		List<Pronostico> pronosticos = new ArrayList<>();
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM pronosticos WHERE usuario_id = " + id);

			while (rs.next()) {
				Pronostico pronostico = new Pronostico();
				Equipo equipo = equipoService.getEquipoById(rs.getInt("equipo_id"));
				Partido partido = partidoService.getPartidoById(rs.getInt("partido_id"));

				pronostico.setId(rs.getInt("id"));
				pronostico.setEquipo(equipo);
				pronostico.setPartido(partido);
				pronostico.setResultado(getResultado(rs.getString("resultado")));
				
				pronosticos.add(pronostico);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			cnn.close();
		}
		return pronosticos;
	}

	public static ResultadoEnum getResultado(String res) {
		if (res.equalsIgnoreCase(ResultadoEnum.EMPATE.toString())) {
			return ResultadoEnum.EMPATE;
		} else if (res.equalsIgnoreCase(ResultadoEnum.GANADOR.toString())) {
			return ResultadoEnum.GANADOR;
		} else {
			return ResultadoEnum.PERDEDOR;
		}
	}
}
