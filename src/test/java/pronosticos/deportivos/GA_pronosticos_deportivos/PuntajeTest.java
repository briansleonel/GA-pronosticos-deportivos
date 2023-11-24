package pronosticos.deportivos.GA_pronosticos_deportivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Ronda;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.RondaService;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.UsuarioService;

public class PuntajeTest {
	private UsuarioService usuarioService = new UsuarioService();
	private RondaService rondaService = new RondaService();

	@Test
	public void puntajeDeUsuarioId1() {
		int idUsuario = 1;

		try {
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeObtenido = usuario.puntos();

			int puntajeEsperado = 6;

			assertEquals(puntajeEsperado, puntajeObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void puntajeExtraTodosAciertosRondaDeUsuarioId1() {
		int idUsuario = 1;

		try {
			Ronda ronda = rondaService.getRondaById(1);

			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeExtraObtenido = usuario.puntosExtraRonda(ronda);

			int puntajeEsperado = 2;

			assertEquals(puntajeEsperado, puntajeExtraObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void puntajeTotalTodosAciertosRondaDeUsuarioId1() {
		int idUsuario = 1;

		try {
			Ronda ronda = rondaService.getRondaById(1);

			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeTotalObtenido = usuario.puntosRonda(ronda);

			int puntajeEsperado = 8;

			assertEquals(puntajeEsperado, puntajeTotalObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void puntajeDeUsuarioId2() {
		int idUsuario = 2;

		try {
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeObtenido = usuario.puntos();

			int puntajeEsperado = 4;

			assertEquals(puntajeEsperado, puntajeObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void puntajeExtraTodosAciertosRondaDeUsuarioId2() {
		int idUsuario = 2;

		try {
			Ronda ronda = rondaService.getRondaById(1);

			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeExtraObtenido = usuario.puntosExtraRonda(ronda);

			int puntajeEsperado = 1;

			assertEquals(puntajeEsperado, puntajeExtraObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void puntajeTotalTodosAciertosRondaDeUsuarioId2() {
		int idUsuario = 2;

		try {
			Ronda ronda = rondaService.getRondaById(1);

			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeTotalObtenido = usuario.puntosRonda(ronda);

			int puntajeEsperado = 5;

			assertEquals(puntajeEsperado, puntajeTotalObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void puntajeDeUsuarioId3() {
		int idUsuario = 3;

		try {
			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeObtenido = usuario.puntos();

			int puntajeEsperado = 2;

			assertEquals(puntajeEsperado, puntajeObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void puntajeExtraTodosAciertosRondaDeUsuarioId3() {
		int idUsuario = 3;

		try {
			Ronda ronda = rondaService.getRondaById(1);

			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeExtraObtenido = usuario.puntosExtraRonda(ronda);

			int puntajeEsperado = 0;

			assertEquals(puntajeEsperado, puntajeExtraObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void puntajeTotalTodosAciertosRondaDeUsuarioId3() {
		int idUsuario = 3;

		try {
			Ronda ronda = rondaService.getRondaById(1);

			Usuario usuario = usuarioService.getUsuarioById(idUsuario);

			int puntajeTotalObtenido = usuario.puntosRonda(ronda);

			int puntajeEsperado = 2;

			assertEquals(puntajeEsperado, puntajeTotalObtenido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
