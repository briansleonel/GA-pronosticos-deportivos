package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

public class Partido {

	private int ronda;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;

	/**
	 * ------- CONSTRUCTORES -------
	 */

	public Partido() {
	}

	public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
	}

	/**
	 * ------- METODOS -------
	 */

	public ResultadoEnum resultado(Equipo equipo) {
		if (equipo.getNombre().equalsIgnoreCase(equipo1.getNombre())) {
			return getResultado(golesEquipo1, golesEquipo2);
		} else {
			return getResultado(golesEquipo2, golesEquipo1);
		}
	}

	public ResultadoEnum getResultado(int goles1, int goles2) {
		if (goles1 == goles2) {
			return ResultadoEnum.EMPATE;
		} else if (goles1 > goles2) {
			return ResultadoEnum.GANADOR;
		} else {
			return ResultadoEnum.PERDEDOR;
		}
	}

	/**
	 * ------- GETTERS AND SETTERS -------
	 */

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	@Override
	public String toString() {
		return "Partido [ronda=" + ronda + ",equipo1=" + equipo1.getNombre() + ", equipo2=" + equipo2.getNombre()
				+ ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + "]";
	}	
}
