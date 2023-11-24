package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

public class Puntaje {
	private static final int PUNTOS = 1;

	private static final int PUNTOS_EXTRA_RONDA = 2;

	private static final int PUNTOS_EXTRA_MEDIA_RONDA = 1;

	public static int getPuntos() {
		return PUNTOS;
	}

	public static int getPuntosExtraRonda() {
		return PUNTOS_EXTRA_RONDA;
	}

	public static int getPuntosExtraMediaRonda() {
		return PUNTOS_EXTRA_MEDIA_RONDA;
	}
}
