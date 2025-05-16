package birt.dwes.apirest.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate
@Table(name="pokemon")
public class Pokemon {

	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpokemon")
	private int id;
	
	@Column(name="namepkm")
	private String nombre;
	
	@Column(name="typepkm")
	private String tipo;
	
	@Column(name="generation")
	private int generacion;
	
	public Pokemon(int id, String nombre, String tipo, int generacion) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.generacion = generacion;
	}
	
	public Pokemon() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getGeneracion() {
		return generacion;
	}

	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}
		
}
