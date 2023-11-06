package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

import java.util.List;

public class Ronda {
	private String nro;
	private List<Partido> partidos;

	/**
	 * ------- CONSTRUCTORES -------
	 */

	public Ronda() {
	}

	public Ronda(String nro, List<Partido> partidos) {
		super();
		this.nro = nro;
		this.partidos = partidos;
	}

	public int puntos() {
		return 0;
	}

	/**
	 * ------- GETTERS AND SETTERS -------
	 */

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}
