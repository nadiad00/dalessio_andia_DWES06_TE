package birt.dwes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import birt.dwes.apirest.dto.EquipoDTO;
import birt.dwes.apirest.entity.Equipo;
import birt.dwes.apirest.service.EquipoService;
import birt.dwes.apirest.utils.ApiResponse;
import jakarta.persistence.NoResultException;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/get")
	public ApiResponse getAll() {
		List<EquipoDTO> listaEquipo = equipoService.getAll();
		
		if(listaEquipo == null || listaEquipo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		} 
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				listaEquipo
		);
	}
	
	@GetMapping("/get/{id}")
	public ApiResponse getById(@PathVariable int id) {
		EquipoDTO equipo = equipoService.getById(id);
		
		if(equipo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		}
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				equipo
		);
	}
	
	@PostMapping("/post")
	public ApiResponse save(@RequestBody Equipo equipo) {
		EquipoDTO equipoDTO = equipoService.save(equipo);
		
		if(equipoDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		}
		
		return new ApiResponse(
				"success",
				200,
				"Datos obtenidos correctamente",
				equipoDTO
		);
	}
	
	@PutMapping("put/{id}")
	public ApiResponse update(@PathVariable int id, @RequestBody Equipo equipo) {
		
		try {
			EquipoDTO equipoDTO = equipoService.update(id, equipo);
			return new ApiResponse(
					"success",
					200,
					"Datos obtenidos correctamente",
					equipoDTO
			);
		
		} catch(NoResultException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ApiResponse update(@PathVariable int id) {
		
		try {
			EquipoDTO equipoDTO = equipoService.deleteById(id);
			return new ApiResponse(
					"success",
					200,
					"Datos obtenidos correctamente",
					equipoDTO
			);
		
		} catch(NoResultException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al obtener los datos");
		}
	}
	
}
