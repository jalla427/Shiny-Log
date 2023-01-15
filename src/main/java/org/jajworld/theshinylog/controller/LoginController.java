package org.jajworld.theshinylog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jajworld.theshinylog.model.FormattedHunts;
import org.jajworld.theshinylog.model.Hunts;
import org.jajworld.theshinylog.model.Person;
import org.jajworld.theshinylog.model.Pokemon;
import org.jajworld.theshinylog.repository.HuntsRepository;
import org.jajworld.theshinylog.repository.PersonRepository;
import org.jajworld.theshinylog.repository.PokemonRepository;
import org.jajworld.theshinylog.service.ListHunts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private HuntsRepository huntsRepository;
	@Autowired
	ListHunts service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		//List<Person> list = personRepository.findAll();
		//model.put("list", list);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		
		Person p = personRepository.findByPnameAndPcode(username, password);
		
//		List<Person> list = personRepository.findAll();
//		String[] parts = new String[2];
//		String thisName;
//		String thisPass;
//		boolean match = false;
//		
//		for(int i=0; i < list.size(); i++)
//		{
//			parts = list.get(i).toString().split(" ", 2);
//			thisName = parts[0];
//			thisPass = parts[1];
//			
//			if(thisName.equals(username) && thisPass.equals(password))
//			{
//				match = true;
//				System.out.println("Login Successful");
//			}
//			
//			if(match)
//			{
//				break;
//			}
//		}

		if(p != null)
		{
			//If the password and username entered exist together in the database a new session is initiated.
			//Username is kept as a session variable
			HttpSession session = request.getSession();
			session.setAttribute("loginName", username);
			
			List<Hunts> hunts = huntsRepository.findAll();
			List<FormattedHunts> fhunts = service.huntsToFhunts(hunts);
			model.put("hunts", fhunts);
			
			return "records";
		}
		else
		{
			model.put("errorMessage", "Invalid login");
			return "login";
		}

	}
}
