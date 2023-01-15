package org.jajworld.theshinylog.repository;

import java.util.List;

import org.jajworld.theshinylog.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Integer>{
	
	List<Pokemon> findAll();
	
	Pokemon findByPokename(String pokename);
	Pokemon findByPokenum(Integer pokenum);
}
