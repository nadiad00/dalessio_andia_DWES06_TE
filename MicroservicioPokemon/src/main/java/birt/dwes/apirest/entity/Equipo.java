package birt.dwes.apirest.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate
@Table(name="equipos")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idequipo")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="pokemon1")
	private Pokemon pokemon1;
	
	@ManyToOne
	@JoinColumn(name="pokemon2")
	private Pokemon pokemon2;
	
	@ManyToOne
	@JoinColumn(name="pokemon3")
	private Pokemon pokemon3;
	
	@ManyToOne
	@JoinColumn(name="pokemon4")
	private Pokemon pokemon4;
	
	@ManyToOne
	@JoinColumn(name="pokemon5")
	private Pokemon pokemon5;
	
	@ManyToOne
	@JoinColumn(name="pokemon6")
	private Pokemon pokemon6;

	public Equipo(int id, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5,
			Pokemon pokemon6) {
		super();
		this.id = id;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.pokemon3 = pokemon3;
		this.pokemon4 = pokemon4;
		this.pokemon5 = pokemon5;
		this.pokemon6 = pokemon6;
	}
	
	public Equipo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pokemon getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(Pokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public Pokemon getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(Pokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public Pokemon getPokemon3() {
		return pokemon3;
	}

	public void setPokemon3(Pokemon pokemon3) {
		this.pokemon3 = pokemon3;
	}

	public Pokemon getPokemon4() {
		return pokemon4;
	}

	public void setPokemon4(Pokemon pokemon4) {
		this.pokemon4 = pokemon4;
	}

	public Pokemon getPokemon5() {
		return pokemon5;
	}

	public void setPokemon5(Pokemon pokemon5) {
		this.pokemon5 = pokemon5;
	}

	public Pokemon getPokemon6() {
		return pokemon6;
	}

	public void setPokemon6(Pokemon pokemon6) {
		this.pokemon6 = pokemon6;
	}

	

}
