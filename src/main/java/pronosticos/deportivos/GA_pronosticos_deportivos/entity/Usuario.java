package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
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

	public int puntos(List<Resultado> resultado) {
		int puntos = 0;
		for (Pronostico p : this.pronosticos) {
			for (Resultado r : resultado) {
				if(p.getResultado() == r.getResultado()) {
					System.out.println(r.getPuntos());
					puntos += r.getPuntos();
				}	
			}
		}
		return puntos;
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
