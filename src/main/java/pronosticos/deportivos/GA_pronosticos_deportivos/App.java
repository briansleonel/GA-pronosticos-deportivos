package pronosticos.deportivos.GA_pronosticos_deportivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Resultado;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.ResultadoEnum;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Ronda;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.RondaService;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.UsuarioService;

public class App {
	public static final String PATH_CSV_USUARIOS = "./usuarios.csv";
	public static final String PATH_CSV_RESULTADOS = "./resultados.csv";
	public static final String PATH_CSV_EQUIPOS = "./equipos.csv";
	public static final String PATH_CSV_PRONOSTICOS = "./pronostico.csv";

	public static void main(String[] args) throws IOException {
		UsuarioService usuarioService = new UsuarioService();
		RondaService rondaService = new RondaService();
		/*
		 * Conexion conexion = new Conexion(); Connection cn = null; Statement stm =
		 * null; ResultSet rs = null;
		 * 
		 * List<Usuario> listadoUsuarios =
		 * LectorArchivoService.leerArchivoUsuarios(PATH_CSV_USUARIOS); List<Equipo>
		 * listadoEquipos = LectorArchivoService.leerArchivoEquipos(PATH_CSV_EQUIPOS);
		 * List<Partido> listadoPartidos =
		 * LectorArchivoService.leerArchivoPartidos(PATH_CSV_RESULTADOS,
		 * listadoEquipos); List<Resultado> listadoResultados = consultarResultado();
		 */

		try {
			Ronda ronda = rondaService.getRondaById(1);

			List<Usuario> listadoUsuarios = usuarioService.getAllUsuarios();

			System.out.println("\nPuntaje de usuarios:");
			listadoUsuarios.forEach(u -> {
				System.out.println("-------- " +u.getNombre() + " --------");
				System.out.println("Puntos: " + u.puntos() + " pts.");
				System.out.println("Puntos extra: " + u.puntosExtraRonda(ronda) + " pts.");
				System.out.println("Puntaje total: " + u.puntosRonda(ronda) + " pts.\n");
			});

			/*
			 * cn = conexion.conectar(); stm = cn.createStatement(); rs =
			 * stm.executeQuery("SELECT * FROM pronosticos");
			 * 
			 * List<Pronostico> listadoPronosticos =
			 * LectorArchivoService.leerArchivoPronosticosDB(rs, listadoPartidos,
			 * listadoUsuarios);
			 * 
			 * // Listado de pronosticos System.out.println("Listado de pronosticos:"); for
			 * (Pronostico pronostico : listadoPronosticos) {
			 * System.out.println(pronostico); }
			 * 
			 * System.out.println("\nPuntaje de usuarios:"); listadoUsuarios.forEach(u -> {
			 * System.out.println(u.getNombre() + ": " + u.puntos(listadoResultados) +
			 * "pts."); });
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Resultado> consultarResultado() {
		List<Resultado> listadoPuntajes = new ArrayList<Resultado>();

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < ResultadoEnum.values().length; i++) {
			System.out.println("Ingrese puntos para el resultado " + ResultadoEnum.values()[i]);
			Resultado res = new Resultado();
			res.setResultado(ResultadoEnum.values()[i]);
			res.setPuntos(scanner.nextInt());
			listadoPuntajes.add(res);
		}
		
		scanner.close();

		return listadoPuntajes;
	}
}
