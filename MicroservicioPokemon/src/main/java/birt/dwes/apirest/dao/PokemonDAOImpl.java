package birt.dwes.apirest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import birt.dwes.apirest.entity.Pokemon;
import jakarta.persistence.EntityManager;

@Repository
public class PokemonDAOImpl implements PokemonDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Pokemon> getAll() {
		Session cs = entityManager.unwrap(Session.class);
		Query<Pokemon> query = cs.createQuery("from Pokemon", Pokemon.class);
		List<Pokemon> pokemon = query.getResultList();
		return pokemon;
	}

	@Override
	@Transactional
	public Pokemon getById(int id) {
		Session cs = entityManager.unwrap(Session.class);
		Pokemon pokemon = cs.find(Pokemon.class, id);
		return pokemon;
	}

	@Override
	@Transactional
	public List<Pokemon> getByType(String tipo) {
		Session cs = entityManager.unwrap(Session.class);
		Query<Pokemon> query = cs.createQuery("FROM Pokemon WHERE tipo Like :tipo", Pokemon.class);
		query.setParameter("tipo", "%" + tipo + "%");
		List<Pokemon> pokemon = query.getResultList();
		return pokemon;
	}

	@Override
	@Transactional
	public List<Pokemon> getByGen(int gen){
		Session cs = entityManager.unwrap(Session.class);
		Query<Pokemon> query = cs.createQuery("FROM Pokemon WHERE generacion = :gen", Pokemon.class);
		query.setParameter("gen", gen);
		List<Pokemon> pokemon = query.getResultList();
		return pokemon;
	}

}
