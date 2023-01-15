package org.jajworld.theshinylog.service;

import org.jajworld.theshinylog.model.Person;
import org.jajworld.theshinylog.model.Pokemon;
import org.jajworld.theshinylog.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jajworld.theshinylog.repository.PersonRepository;

@Service
public class ValidationService 
{
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PokemonRepository pokemonRepository;
	
	public boolean validatePokemon(String pokename)
	{
		boolean real = false;
		
		Pokemon p = pokemonRepository.findByPokename(pokename);
		
		if(p != null)
		{
			real = true;
		}
		
		return real;
	}
	
	public boolean validatePerson(String name)
	{
		boolean real = false;
		
		Person p = personRepository.findByPname(name);
		
		if(p != null)
		{
			real = true;
		}
		
		return real;
	}
	
	public static boolean isNumeric(String strNum) 
	{
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
