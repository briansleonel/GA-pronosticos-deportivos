package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

import java.util.List;

public class Ronda {
	private Integer id;
	private int nro;
	private List<Partido> partidos;

	/**
	 * ------- CONSTRUCTORES -------
	 */

	public Ronda() {
	}

	public Ronda(int nro, List<Partido> partidos) {
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public int cantidadPartidoRonda(int ronda) {
		if (ronda == this.getNro()) {
			return this.partidos.size();
		} else {
			return 0;
		}
	}

}
