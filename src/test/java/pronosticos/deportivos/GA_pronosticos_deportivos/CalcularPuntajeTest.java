package pronosticos.deportivos.GA_pronosticos_deportivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.LectorArchivoService;

public class CalcularPuntajeTest {
	public static final String PATH_CSV_USUARIOS = "./usuarios.csv";
	public static final String PATH_CSV_RESULTADOS = "./resultados.csv";
	public static final String PATH_CSV_EQUIPOS = "./equipos.csv";
	public static final String PATH_CSV_PRONOSTICOS = "./pronostico.csv";

	@Test
	public void calcularPuntajeMarianaAciertos() {
		List<Usuario> listadoUsuarios = LectorArchivoService.leerArchivoUsuarios(PATH_CSV_USUARIOS);
		List<Equipo> listadoEquipos = LectorArchivoService.leerArchivoEquipos(PATH_CSV_EQUIPOS);
		List<Partido> listadoPartidos = LectorArchivoService.leerArchivoPartidos(PATH_CSV_RESULTADOS, listadoEquipos);

		List<Pronostico> listadoPronosticos = LectorArchivoService.leerArchivoPronosticos(PATH_CSV_PRONOSTICOS,
				listadoPartidos, listadoUsuarios);

		int puntajeObjetnido = 0;

		for (Usuario u : listadoUsuarios) {
			if (u.getNombre().equalsIgnoreCase("Mariana")) {
				puntajeObjetnido = u.puntos();
				break;
			}
		}

		assertEquals(3, puntajeObjetnido);
	}
	
	@Test
	public void calcularPuntajePedroAciertos() {
		List<Usuario> listadoUsuarios = LectorArchivoService.leerArchivoUsuarios(PATH_CSV_USUARIOS);
		List<Equipo> listadoEquipos = LectorArchivoService.leerArchivoEquipos(PATH_CSV_EQUIPOS);
		List<Partido> listadoPartidos = LectorArchivoService.leerArchivoPartidos(PATH_CSV_RESULTADOS, listadoEquipos);

		List<Pronostico> listadoPronosticos = LectorArchivoService.leerArchivoPronosticos(PATH_CSV_PRONOSTICOS,
				listadoPartidos, listadoUsuarios);

		int puntajeObjetnido = 0;

		for (Usuario u : listadoUsuarios) {
			if (u.getNombre().equalsIgnoreCase("Pedro")) {
				puntajeObjetnido = u.puntos();
				break;
			}
		}

		assertEquals(1, puntajeObjetnido);
	}
}
