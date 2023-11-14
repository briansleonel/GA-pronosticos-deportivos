package pronosticos.deportivos.GA_pronosticos_deportivos.services;

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
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.ResultadoEnum;

public class LectorArchivoService {
	public static List<Equipo> leerArchivoEquipos(String path) {
		List<Equipo> equipos = new ArrayList<Equipo>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

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

	public static List<Partido> leerArchivoPartidos(String path, List<Equipo> listadoEquipos) {
		List<Partido> partidos = new ArrayList<Partido>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

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

	public static List<Pronostico> leerArchivoPronosticos(String path, List<Partido> listadoPartidos) {
		List<Pronostico> pronosticos = new ArrayList<Pronostico>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

			@SuppressWarnings("resource")
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord csvRecord : csvParser) {
				Partido partidoEncontrado = new Partido();

				for (Partido p : listadoPartidos) {
					if (p.getEquipo1().getNombre().equalsIgnoreCase(csvRecord.get(0))
							&& p.getEquipo2().getNombre().equalsIgnoreCase(csvRecord.get(2))) {
						partidoEncontrado = p;
						break;
					}
				}

				Pronostico pronostico = new Pronostico();
				pronostico.setPartido(partidoEncontrado);
				pronostico.setEquipo(partidoEncontrado.getEquipo1());
				pronostico.setResultado(ResultadoEnum.valueOf(csvRecord.get(1)));

				pronosticos.add(pronostico);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return pronosticos;
	}
}