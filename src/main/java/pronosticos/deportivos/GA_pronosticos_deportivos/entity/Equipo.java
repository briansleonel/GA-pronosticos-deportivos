package pronosticos.deportivos.GA_pronosticos_deportivos.entity;

public class Equipo {
	private Integer id;
	private String nombre;
	private String descripcion;

	/**
	 * ------- CONSTRUCTORES -------
	 */

	public Equipo() {
	}

	public Equipo(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
