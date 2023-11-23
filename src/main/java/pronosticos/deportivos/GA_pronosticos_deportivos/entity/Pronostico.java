package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

public class Pronostico {
	private Integer id;
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;

	/**
	 * ------- CONSTRUCTORES -------
	 */

	public Pronostico() {
	}

	public Pronostico(Partido partido, Equipo equipo) {
		super();
		this.partido = partido;
		this.equipo = equipo;
	}

	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public int puntos() {
		if (partido.resultado(equipo) == (resultado))
			return 1;
		else
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

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Pronostico [partido=" + partido + ", equipo=" + equipo.getNombre() + ", resultado=" + resultado + "]";
	}

}
