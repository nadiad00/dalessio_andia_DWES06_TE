package birt.dwes.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birt.dwes.apirest.dao.PokemonDAO;
import birt.dwes.apirest.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private PokemonDAO pokemonDAO;
	
	@Override
	public List<Pokemon> getAll() {
		List<Pokemon> listaPkmn = pokemonDAO.getAll();
		return listaPkmn;
	}

	@Override
	public Pokemon getById(int id) {
		Pokemon pokemon = pokemonDAO.getById(id);
		return pokemon;
	}

	@Override
	public List<Pokemon> getByType(String tipo) {
		List<Pokemon> listaPkmn = pokemonDAO.getByType(tipo);
		return listaPkmn;
	}
	
	
	@Override
	public List<Pokemon> getByGen(int gen) {
		List<Pokemon> listaPkmn = pokemonDAO.getByGen(gen);
		return listaPkmn;
	}

}
