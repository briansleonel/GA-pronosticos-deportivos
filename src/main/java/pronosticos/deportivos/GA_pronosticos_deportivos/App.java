package pronosticos.deportivos.GA_pronosticos_deportivos;

import java.io.IOException;
import java.util.List;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.LectorArchivoService;

public class App {
	public static final String PATH_CSV_USUARIOS = "./usuarios.csv";
	public static final String PATH_CSV_RESULTADOS = "./resultados.csv";
	public static final String PATH_CSV_EQUIPOS = "./equipos.csv";
	public static final String PATH_CSV_PRONOSTICOS = "./pronostico.csv";

	public static void main(String[] args) throws IOException {
		List<Usuario> listadoUsuarios = LectorArchivoService.leerArchivoUsuarios(PATH_CSV_USUARIOS);
		List<Equipo> listadoEquipos = LectorArchivoService.leerArchivoEquipos(PATH_CSV_EQUIPOS);
		List<Partido> listadoPartidos = LectorArchivoService.leerArchivoPartidos(PATH_CSV_RESULTADOS, listadoEquipos);

		List<Pronostico> listadoPronosticos = LectorArchivoService.leerArchivoPronosticos(PATH_CSV_PRONOSTICOS,
				listadoPartidos, listadoUsuarios);

		// Listado de pronosticos
		System.out.println("Listado de pronosticos:");
		for (Pronostico pronostico : listadoPronosticos) {
			System.out.println(pronostico);
		}

		System.out.println("\nPuntaje de usuarios:");
		listadoUsuarios.forEach(u -> {
			System.out.println(u.getNombre() + ": " + u.puntos() + "pts.");
		});
	}
}
