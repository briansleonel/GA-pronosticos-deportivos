package pronosticos.deportivos.GA_pronosticos_deportivos.services;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Equipo;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Partido;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Pronostico;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.PronosticoDto;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.ResultadoEnum;
import pronosticos.deportivos.GA_pronosticos_deportivos.entity.Usuario;

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
					if (e.getNombre().equalsIgnoreCase(csvRecord.get(1))) {
						equipo1 = e;
						break;
					}
				}

				for (Equipo e : listadoEquipos) {
					if (e.getNombre().equalsIgnoreCase(csvRecord.get(4))) {
						equipo2 = e;
						break;
					}
				}

				Partido partido = new Partido();
				partido.setRonda(Integer.parseInt(csvRecord.get(0)));
				partido.setEquipo1(equipo1);
				partido.setEquipo2(equipo2);
				partido.setGolesEquipo1(Integer.parseInt(csvRecord.get(2)));
				partido.setGolesEquipo2(Integer.parseInt(csvRecord.get(3)));

				partidos.add(partido);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return partidos;
	}

	public static List<Pronostico> leerArchivoPronosticos(String path, List<Partido> listadoPartidos,
			List<Usuario> listadoUsuarios) {
		List<Pronostico> pronosticos = new ArrayList<Pronostico>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

			@SuppressWarnings("resource")
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			// csvParser.getRecords()

			for (CSVRecord csvRecord : csvParser) {
				Partido partidoEncontrado = new Partido();

				for (Partido p : listadoPartidos) {
					if (p.getEquipo1().getNombre().equalsIgnoreCase(csvRecord.get(1))
							&& p.getEquipo2().getNombre().equalsIgnoreCase(csvRecord.get(3))) {
						partidoEncontrado = p;
						break;
					}
				}

				Pronostico pronostico = new Pronostico();

				pronostico.setPartido(partidoEncontrado);
				pronostico.setEquipo(partidoEncontrado.getEquipo1());
				pronostico.setResultado(ResultadoEnum.valueOf(csvRecord.get(2)));

				pronosticos.add(pronostico);

				for (Usuario u : listadoUsuarios) {
					if (csvRecord.get(0).equalsIgnoreCase(u.getNombre())) {
						u.agregarPronostico(pronostico);
						break;
					}
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pronosticos;
	}

	public static List<Usuario> leerArchivoUsuarios(String path) {
		List<Usuario> usuarios = new ArrayList<>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

			@SuppressWarnings("resource")
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord csvRecord : csvParser) {
				Usuario usuario = new Usuario();
				usuario.setNombre(csvRecord.get(0));

				usuarios.add(usuario);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return usuarios;
	}

	public static List<Pronostico> leerArchivoPronosticosDB(ResultSet pronosticos, List<Partido> listadoPartidos,
					List<Usuario> listadoUsuarios) {
				List<Pronostico> pronosticosList = new ArrayList<Pronostico>();
				List<PronosticoDto> pronosticoDtoList = new ArrayList<PronosticoDto>();
				try {
					
					while(pronosticos.next()) {
						PronosticoDto pronosticoDto = new PronosticoDto();
						pronosticoDto.setUsuario(pronosticos.getString("usuario"));
						pronosticoDto.setEquipo1(pronosticos.getString("equipo1"));
						pronosticoDto.setEquipo2(pronosticos.getString("equipo2"));
						pronosticoDto.setResultado(pronosticos.getString("resultado"));
						
						pronosticoDtoList.add(pronosticoDto);
					}

					for (PronosticoDto pl : pronosticoDtoList) {
						Partido partidoEncontrado = new Partido();

						for (Partido p : listadoPartidos) {
							if (p.getEquipo1().getNombre().equalsIgnoreCase(pl.getEquipo1())
									&& p.getEquipo2().getNombre().equalsIgnoreCase(pl.getEquipo2())) {
								partidoEncontrado = p;
								break;
							}
						}

						Pronostico pronostico = new Pronostico();

						pronostico.setPartido(partidoEncontrado);
						pronostico.setEquipo(partidoEncontrado.getEquipo1());
						pronostico.setResultado(ResultadoEnum.valueOf(pl.getResultado()));

						pronosticosList.add(pronostico);

						for (Usuario u : listadoUsuarios) {
							if (pl.getUsuario().equalsIgnoreCase(u.getNombre())) {
								u.agregarPronostico(pronostico);
								break;
							}
						}

					}

				} catch (Exception e) {
					System.out.println(e);
				}

				return pronosticosList;
			}


}
