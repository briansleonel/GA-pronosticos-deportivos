package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private Integer id;
	private String nombre;
	private List<Pronostico> pronosticos;

	public Usuario() {
		this.pronosticos = new ArrayList<Pronostico>();
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.pronosticos = new ArrayList<Pronostico>();
	}

	public void agregarPronostico(Pronostico pronostico) {
		this.pronosticos.add(pronostico);
	}

	// List<Resultado> resultado
	public int puntos() {
		int puntos = 0;
		for (Pronostico p : this.pronosticos) {
			puntos += p.puntos();
		}
		return puntos;
	}

	public int puntosRonda(Ronda ronda) {
		int puntos = 0;
		int aciertosTotales = 0;
		List<Pronostico> listadoPronosticoRonda = new ArrayList<>();

		for (Pronostico p : pronosticos) {
			if (p.getPartido().getRonda() == ronda.getNro()) {
				listadoPronosticoRonda.add(p);
			}
		}

		for (Pronostico p : listadoPronosticoRonda) {
			puntos += p.puntos();
			if (p.acierto()) {
				aciertosTotales++;
			}
		}

		/*
		 * Agregamos puntos extra si se acierta todos los pronosticos de una ronda En el
		 * caso de que acierte solo la mitad, agregamos los puntos correspondientes
		 */
		if (ronda.cantidadPartidoRonda(ronda.getNro()) == listadoPronosticoRonda.size()) {
			puntos += Puntaje.getPuntosExtraRonda();
		} else if (aciertosTotales >= ronda.cantidadPartidoRonda(ronda.getNro()) / 2) {
			puntos += Puntaje.getPuntosExtraMediaRonda();
		}

		return puntos;
	}
	
	public int puntosExtraRonda(Ronda ronda) {
		int puntos = 0;
		int aciertosTotales = 0;
		List<Pronostico> listadoPronosticoRonda = new ArrayList<>();

		for (Pronostico p : pronosticos) {
			if (p.getPartido().getRonda() == ronda.getNro()) {
				listadoPronosticoRonda.add(p);
			}
		}

		for (Pronostico p : listadoPronosticoRonda) {
			if (p.acierto()) {
				aciertosTotales++;
			}
		}

		/*
		 * Agregamos puntos extra si se acierta todos los pronosticos de una ronda En el
		 * caso de que acierte solo la mitad, agregamos los puntos correspondientes
		 */
		if (ronda.cantidadPartidoRonda(ronda.getNro()) == listadoPronosticoRonda.size()) {
			puntos += Puntaje.getPuntosExtraRonda();
		} else if (aciertosTotales >= ronda.cantidadPartidoRonda(ronda.getNro()) / 2) {
			puntos += Puntaje.getPuntosExtraMediaRonda();
		}

		return puntos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pronostico> getPronosticos() {
		return pronosticos;
	}

	public void setPronosticos(List<Pronostico> pronosticos) {
		this.pronosticos = pronosticos;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pronosticos=" + pronosticos + "]";
	}

}
