package pronosticos.deportivos.GA_pronosticos_deportivos.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pronosticos.deportivos.GA_pronosticos_deportivos.Conexion;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;

public class UsuarioService {
	private Conexion conexion = new Conexion();
	PronosticoService pronosticoService = new PronosticoService();

	public Usuario getUsuarioById(int id) throws SQLException {
		Connection cnn = null;
		Usuario usuario = new Usuario();
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM usuarios WHERE id = " + id);

			if (rs.next()) {
				List<Pronostico> pronosticos = pronosticoService.getPronosticosByUsuarioId(id);

				usuario.setPronosticos(pronosticos);
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			cnn.close();
		}
		return usuario;
	}

	public List<Usuario> getAllUsuarios() throws SQLException {
		Connection cnn = null;
		List<Usuario> usuarios = new ArrayList<>();
		try {
			cnn = conexion.conectar();
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				Usuario usuario = new Usuario();
				List<Pronostico> pronosticos = pronosticoService.getPronosticosByUsuarioId(rs.getInt("id"));

				usuario.setPronosticos(pronosticos);
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));

				usuarios.add(usuario);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			cnn.close();
		}
		return usuarios;
	}
}
