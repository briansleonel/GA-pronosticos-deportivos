package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

public class Resultado {
	private ResultadoEnum Resultado;
	private int Puntos;
	
	public ResultadoEnum getResultado() {
		return Resultado;
	}
	public void setResultado(ResultadoEnum resultado) {
		Resultado = resultado;
	}
	public int getPuntos() {
		return Puntos;
	}
	public void setPuntos(int puntos) {
		Puntos = puntos;
	}
	
	
}
