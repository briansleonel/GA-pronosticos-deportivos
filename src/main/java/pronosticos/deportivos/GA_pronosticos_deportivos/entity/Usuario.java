package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

import java.util.List;

public class Usuario {
	private String nombre;
	private List<Pronostico> pronosticos;

	public Usuario() {
	}

	public Usuario(String nombre, List<Pronostico> pronosticos) {
		super();
		this.nombre = nombre;
		this.pronosticos = pronosticos;
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
