package birt.dwes.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birt.dwes.apirest.dao.EquipoDAO;
import birt.dwes.apirest.dto.EquipoDTO;
import birt.dwes.apirest.entity.Equipo;
import jakarta.persistence.NoResultException;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoDAO equipoDAO;
	
	@Override
	public List<EquipoDTO> getAll() {
		List<EquipoDTO> listaEquipo = equipoDAO.getAll();
		return listaEquipo;
	}

	@Override
	public EquipoDTO getById(int id) {
		EquipoDTO equipo = equipoDAO.getById(id);
		return equipo;
	}

	@Override
	public EquipoDTO save(Equipo equipo) {
		return equipoDAO.save(equipo);
	}
	
	@Override
	public EquipoDTO update(int id, Equipo equipo) {
		EquipoDTO existe = equipoDAO.update(id, equipo);
		
		if(existe == null) {
			throw new NoResultException("Equipo no encontrado");
		}
		
		return existe;
	}

	@Override
	public EquipoDTO deleteById(int id) {
		EquipoDTO equipo = equipoDAO.getById(id);
		Equipo existe = equipoDAO.deleteById(id);
		
		if(existe == null) {
			throw new NoResultException("Equipo no encontrado");
		}
		
		return equipo;
	}

}
