package birt.dwes.apirest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import birt.dwes.apirest.dto.EquipoDTO;
import birt.dwes.apirest.entity.Equipo;
import jakarta.persistence.EntityManager;


@Repository
public class EquipoDAOImpl implements EquipoDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<EquipoDTO> getAll() {
		Session cs = entityManager.unwrap(Session.class);
		List<Object[]> resultados = cs.createQuery("""
				SELECT 
				   e.pokemon1.nombre,
				   e.pokemon2.nombre,
				   e.pokemon3.nombre,
				   e.pokemon4.nombre,
				   e.pokemon5.nombre,
				   e.pokemon6.nombre
			    FROM Equipo e
		""", Object[].class).getResultList();

		List<EquipoDTO> equipos = new ArrayList<>();
	    for (Object[] fila : resultados) {
	        equipos.add(new EquipoDTO(
	            (String) fila[0],
	            (String) fila[1],
	            (String) fila[2],
	            (String) fila[3],
	            (String) fila[4],
	            (String) fila[5]
	        ));
	    }
	  
	    return equipos;
	}

	@Override
	@Transactional
	public EquipoDTO getById(int id) {
		Session cs = entityManager.unwrap(Session.class);
		Query<EquipoDTO> query = cs.createQuery("""
				SELECT new birt.dwes.apirest.dto.EquipoDTO(
				   e.pokemon1.nombre,
				   e.pokemon2.nombre,
				   e.pokemon3.nombre,
				   e.pokemon4.nombre,
				   e.pokemon5.nombre,
				   e.pokemon6.nombre
				)
			    FROM Equipo e
			    WHERE e.id = :id
		""", EquipoDTO.class);
		
		query.setParameter("id", id);
		EquipoDTO equipo = query.getSingleResult();
		return equipo;
	}

	@Override
	@Transactional
	public EquipoDTO save(Equipo equipo) {
		Session cs = entityManager.unwrap(Session.class);
		Equipo resultado = cs.merge(equipo);
		return getById(resultado.getId());
	}
	
	@Override
	@Transactional
	public EquipoDTO update(int id, Equipo equipo) {
		Session cs = entityManager.unwrap(Session.class);
		Equipo existe = cs.find(Equipo.class, id);
		
		if(existe == null) {
			return null;
		}
		
		existe.setPokemon1(equipo.getPokemon1());
		existe.setPokemon2(equipo.getPokemon2());
		existe.setPokemon3(equipo.getPokemon3());
		existe.setPokemon4(equipo.getPokemon4());
		existe.setPokemon5(equipo.getPokemon5());
		existe.setPokemon6(equipo.getPokemon6());
		
		cs.merge(existe);
		
		EquipoDTO equipoDTO = getById(id);
		
		return equipoDTO;
	}

	@Override
	@Transactional
	public Equipo deleteById(int id) {
		Session cs = entityManager.unwrap(Session.class);
		Equipo existe = cs.find(Equipo.class, id);
		
		if(existe != null) {
			cs.remove(existe);
		}
		
		return existe;
	}

}
