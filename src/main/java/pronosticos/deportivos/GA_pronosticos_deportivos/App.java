package pronosticos.deportivos.GA_pronosticos_deportivos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Resultado;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.ResultadoEnum;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;
import pronosticos.deportivos.GA_pronosticos_deportivos.services.LectorArchivoService;

public class App {
	public static final String PATH_CSV_USUARIOS = "./usuarios.csv";
	public static final String PATH_CSV_RESULTADOS = "./resultados.csv";
	public static final String PATH_CSV_EQUIPOS = "./equipos.csv";
	public static final String PATH_CSV_PRONOSTICOS = "./pronostico.csv";

	
	public static void main(String[] args) throws IOException {
		
		Conexion conexion = new Conexion();
	    Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		List<Usuario> listadoUsuarios = LectorArchivoService.leerArchivoUsuarios(PATH_CSV_USUARIOS);
		List<Equipo> listadoEquipos = LectorArchivoService.leerArchivoEquipos(PATH_CSV_EQUIPOS);
		List<Partido> listadoPartidos = LectorArchivoService.leerArchivoPartidos(PATH_CSV_RESULTADOS, listadoEquipos);
		List<Resultado> listadoResultados = consultarResultado();
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM pronosticos");

			List<Pronostico> listadoPronosticos = LectorArchivoService.leerArchivoPronosticosDB(rs,
					listadoPartidos, listadoUsuarios);
		
			// Listado de pronosticos
			System.out.println("Listado de pronosticos:");
			for (Pronostico pronostico : listadoPronosticos) {
				System.out.println(pronostico);
			}

			System.out.println("\nPuntaje de usuarios:");
			listadoUsuarios.forEach(u -> {
				System.out.println(u.getNombre() + ": " + u.puntos(listadoResultados) + "pts.");
			});
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Resultado> consultarResultado() {
		List<Resultado> listadoPuntajes = new ArrayList<Resultado>();
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i < ResultadoEnum.values().length; i++) {
			System.out.println("Ingrese puntos para el resultado " + ResultadoEnum.values()[i]);
			Resultado res = new Resultado();
			res.setResultado(ResultadoEnum.values()[i]);
			res.setPuntos(scanner.nextInt());
			listadoPuntajes.add(res);
		}
		
		return listadoPuntajes;
	}
}
