package pronosticos.deportivos.GA_pronosticos_deportivos;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;

/**
 * Hello world!
 *
 */
public class App {
	public static final String PATH_CSV_RESULTADOS = "./resultados.csv";
	public static final String PATH_CSV_EQUIPOS = "./equipos.csv";

	public static void main(String[] args) throws IOException {
		List<Equipo> listadoEquipos = getEquipos();
		List<Partido> listadoPartidos = getPartidos(listadoEquipos);

		for (Partido e : listadoPartidos) {
			System.out.println(e);
		}
	}

	public static List<Partido> getPartidos(List<Equipo> listadoEquipos) throws IOException {
		List<Partido> partidos = new ArrayList<Partido>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(PATH_CSV_RESULTADOS));

			@SuppressWarnings("resource")
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord csvRecord : csvParser) {
				Equipo equipo1 = new Equipo();
				Equipo equipo2 = new Equipo();

				for (Equipo e : listadoEquipos) {
					if (e.getNombre().equalsIgnoreCase(csvRecord.get(0))) {
						equipo1 = e;
						break;
					}
				}

				for (Equipo e : listadoEquipos) {
					if (e.getNombre().equalsIgnoreCase(csvRecord.get(3))) {
						equipo2 = e;
						break;
					}
				}

				Partido partido = new Partido();
				partido.setEquipo1(equipo1);
				partido.setEquipo2(equipo2);
				partido.setGolesEquipo1(Integer.parseInt(csvRecord.get(1)));
				partido.setGolesEquipo2(Integer.parseInt(csvRecord.get(2)));

				partidos.add(partido);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return partidos;
	}

	public static List<Equipo> getEquipos() throws IOException {
		List<Equipo> equipos = new ArrayList<Equipo>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(PATH_CSV_EQUIPOS));

			@SuppressWarnings("resource")
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord csvRecord : csvParser) {
				Equipo equipo = new Equipo();
				equipo.setNombre(csvRecord.get(0));
				equipo.setDescripcion(csvRecord.get(1));

				equipos.add(equipo);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return equipos;
	}
}
