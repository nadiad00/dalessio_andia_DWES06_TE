package birt.dwes.apirest.dao;

import java.util.List;

import birt.dwes.apirest.dto.EquipoDTO;
import birt.dwes.apirest.entity.Equipo;

public interface EquipoDAO {

	public List<EquipoDTO> getAll();
	
	public EquipoDTO getById(int id);
	
	public EquipoDTO save(Equipo equipo);
	
	public EquipoDTO update(int id, Equipo equipo);
	
	public Equipo deleteById(int id);
}
