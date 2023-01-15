package org.jajworld.theshinylog.service;

import org.jajworld.theshinylog.model.FormattedHunts;
import org.jajworld.theshinylog.model.Hunts;
import org.jajworld.theshinylog.repository.HuntsRepository;
import org.jajworld.theshinylog.repository.PersonRepository;
import org.jajworld.theshinylog.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private HuntsRepository huntsRepository;
	@Autowired
	ValidationService vService;
	
	public void addHunt(String pokename, String generation, String encounters, String username)
	{
		Hunts thishunt = new Hunts();
		Integer gen = Integer.valueOf(generation);
		Integer pokenum = pokemonRepository.findByPokename(pokename).getPokenum();
		Integer pid = personRepository.findByPname(username).getPid();
		Integer encountersInteger = Integer.valueOf(encounters);
		String pokenumString = pokenum.toString();
		String pidString = pid.toString();
		Integer hidString = Integer.valueOf(pidString + pokenumString + encounters);
		
		thishunt.setHid(hidString);
		thishunt.setPid(pid);
		thishunt.setPokenum(pokenum);
		thishunt.setEncounters(encountersInteger);
		thishunt.setGen(gen);
		
		huntsRepository.save(thishunt);
	}
}
