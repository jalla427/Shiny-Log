package org.jajworld.theshinylog.service;

import org.jajworld.theshinylog.model.Person;
import org.jajworld.theshinylog.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

import org.jajworld.theshinylog.model.FormattedHunts;
import org.jajworld.theshinylog.model.Hunts;
import org.jajworld.theshinylog.repository.PersonRepository;
import org.jajworld.theshinylog.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jajworld.theshinylog.repository.HuntsRepository;

@Service
public class ListHunts {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private HuntsRepository huntsRepository;
	@Autowired
	ValidationService vService;
	
	public List<FormattedHunts> determineReturnList(String pokemon, String generation, String hunter)
	{
		List<FormattedHunts> fhunts = null;
		
		if(pokemon != "" && generation != "" && hunter != "")
		{
			//All three fields were specified
			fhunts = listHuntsUsingPokemonGenerationHunter(pokemon, generation, hunter);
		}
		else
		{
			if(pokemon == "" && generation != "" && hunter != "")
			{
				//Generation and Hunter were specified
				fhunts = listHuntsUsingGenerationHunter(generation, hunter);
			}
			if(pokemon != "" && generation == "" && hunter != "")
			{
				//Pokemon and Hunter were specified
				fhunts = listHuntsUsingPokemonHunter(pokemon, hunter);
			}
			if(pokemon != "" && generation != "" && hunter == "")
			{
				//Pokemon and Generation were specified
				fhunts = listHuntsUsingPokemonGeneration(pokemon, generation);
			}
			if(pokemon == "" && generation != "" && hunter == "")
			{
				//Generation was specified
				fhunts = listHuntsUsingGeneration(generation);
			}
			if(pokemon == "" && generation == "" && hunter != "")
			{
				//Hunter was specified
				fhunts = listHuntsUsingHunter(hunter);
			}
			if(pokemon != "" && generation == "" && hunter == "")
			{
				//Pokemon was specified
				fhunts = listHuntsUsingPokemon(pokemon);
			}
			if(pokemon == "" && generation == "" && hunter == "")
			{
				//Nothing was specified
				fhunts = huntsToFhunts(huntsRepository.findAll());
			}
			
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingPokemonGenerationHunter(String pokemon, String generation, String hunter)
	{
		Integer pid = null;
		Integer pokenum = null;
		Integer gen = Integer.valueOf(generation);
		List<Hunts> hunts = null;
		List<FormattedHunts> fhunts = null;
		
		if(vService.validatePerson(hunter) && vService.validatePokemon(pokemon))
		{
			pid = personRepository.findByPname(hunter).getPid();
			pokenum = pokemonRepository.findByPokename(pokemon).getPokenum();
			hunts = huntsRepository.findByPidAndGenAndPokenum(pid, gen, pokenum);
			fhunts = huntsToFhunts(hunts);
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingPokemonGeneration(String pokemon, String generation)
	{
		Integer pokenum = null;
		Integer gen = Integer.valueOf(generation);
		List<Hunts> hunts = null;
		List<FormattedHunts> fhunts = null;
		
		if(vService.validatePokemon(pokemon))
		{
			pokenum = pokemonRepository.findByPokename(pokemon).getPokenum();
			hunts = huntsRepository.findByGenAndPokenum(gen, pokenum);
			fhunts = huntsToFhunts(hunts);
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingPokemonHunter(String pokemon, String hunter)
	{
		Integer pid = null;
		Integer pokenum = null;
		List<Hunts> hunts = null;
		List<FormattedHunts> fhunts = null;
		
		if(vService.validatePokemon(pokemon) && vService.validatePerson(hunter))
		{
			pid = personRepository.findByPname(hunter).getPid();
			pokenum = pokemonRepository.findByPokename(pokemon).getPokenum();
			hunts = huntsRepository.findByPidAndPokenum(pid, pokenum);
			fhunts = huntsToFhunts(hunts);
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingGenerationHunter(String generation, String hunter)
	{
		Integer pid = null;
		Integer gen = Integer.valueOf(generation);
		List<Hunts> hunts = null;
		List<FormattedHunts> fhunts = null;
		
		if(vService.validatePerson(hunter))
		{
			pid = personRepository.findByPname(hunter).getPid();
			hunts = huntsRepository.findByPidAndGen(pid, gen);
			fhunts = huntsToFhunts(hunts);
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingPokemon(String pokemon)
	{
		Integer pokenum = null;
		List<Hunts> hunts = null;
		List<FormattedHunts> fhunts = null;
		
		if(vService.validatePokemon(pokemon))
		{
			pokenum = pokemonRepository.findByPokename(pokemon).getPokenum();
			hunts = huntsRepository.findByPokenum(pokenum);
			fhunts = huntsToFhunts(hunts);
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingGeneration(String generation)
	{
		Integer gen = Integer.valueOf(generation);
		List<Hunts> hunts = huntsRepository.findByGen(gen);
		List<FormattedHunts> fhunts = null;
		
		fhunts = huntsToFhunts(hunts);
		
		return fhunts;
	}
	
	public List<FormattedHunts> listHuntsUsingHunter(String hunter)
	{
		Integer pid = null;
		List<Hunts> hunts = null;
		List<FormattedHunts> fhunts = null;
		
		if(vService.validatePerson(hunter))
		{
			pid = personRepository.findByPname(hunter).getPid();
			hunts = huntsRepository.findByPid(pid);
			fhunts = huntsToFhunts(hunts);
		}
		
		return fhunts;
	}
	
	public List<FormattedHunts> huntsToFhunts(List<Hunts> hunts)
	{
		FormattedHunts thishunt = null;
		List<FormattedHunts> fhunts = new ArrayList<FormattedHunts>();
		
		for(int i = 0; i < hunts.size(); i++)
		{
			thishunt = new FormattedHunts();
			thishunt.setHid(hunts.get(i).getHid());
			thishunt.setPokename(pokemonRepository.findByPokenum(hunts.get(i).getPokenum()).getPokename());
			thishunt.setGen(hunts.get(i).getGen());
			thishunt.setHunter(personRepository.findByPid(hunts.get(i).getPid()).getPname());
			thishunt.setEncounters(hunts.get(i).getEncounters());
			thishunt.setNotes(hunts.get(i).getNotes());
			
			fhunts.add(thishunt);
		}
		
		return fhunts;
	}
}
