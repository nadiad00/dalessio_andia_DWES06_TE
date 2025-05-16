package birt.dwes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import birt.dwes.apirest.service.PokemonService;
import birt.dwes.apirest.utils.ApiResponse;
import birt.dwes.apirest.entity.Pokemon;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/get")
	public ApiResponse getAll() {
		List<Pokemon> listaPkmn = pokemonService.getAll();
		
		if(listaPkmn == null || listaPkmn.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		} 
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				listaPkmn
			);
	}
	
	@GetMapping("/get/{idPkmn:[0-9]+}")
	public ApiResponse getById(@PathVariable int idPkmn) {
		Pokemon pokemon = pokemonService.getById(idPkmn);
		
		if(pokemon == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		} 
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				pokemon
			);
	}
	
	@GetMapping("/getType/{tipo}")
	public ApiResponse getByType(@PathVariable String tipo) {
		List<Pokemon> listaPkmn = pokemonService.getByType(tipo);
		
		if(listaPkmn == null || listaPkmn.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		} 
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				listaPkmn
			);
	}
	
	@GetMapping("/getGen/{gen}")
	public ApiResponse getByGen(@PathVariable int gen) {
		List<Pokemon> listaPkmn = pokemonService.getByGen(gen);
		
		if(listaPkmn == null || listaPkmn.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		} 
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				listaPkmn
			);
	}
	
	
}
