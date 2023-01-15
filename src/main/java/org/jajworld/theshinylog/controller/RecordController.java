package org.jajworld.theshinylog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.jajworld.theshinylog.service.AddService;
import org.jajworld.theshinylog.service.ListHunts;
import org.jajworld.theshinylog.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecordController {
	@Autowired
	private HuntsRepository huntsRepository;
	@Autowired
	ListHunts lhService;
	@Autowired
	ValidationService vService;
	@Autowired
	AddService aService;
	
	@RequestMapping(value="/records", method = RequestMethod.GET)
	public String bootRecordPage(ModelMap model ) {
		List<Hunts> hunts = huntsRepository.findAll();
		List<FormattedHunts> fhunts = lhService.huntsToFhunts(hunts);
		model.put("hunts", fhunts);
		return "records";
	}
		
	@RequestMapping(value="/records", method = RequestMethod.POST)
	public String reloadRecordPage(ModelMap model, @RequestParam String pokemon, 
									@RequestParam String generation, @RequestParam String hunter, HttpServletRequest request) {
		if(request.getSession().getAttribute("loginName") == null)
		{
			//if the session is killed, instead of reloading this page go back to login page
			return("redirect:/login");
		}
		
		request.setAttribute("loginName", request.getSession().getAttribute("loginName"));
		List<FormattedHunts> hunts = lhService.determineReturnList(pokemon, generation, hunter);
		model.put("hunts", hunts);
		return "records";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addHuntPage(ModelMap model, HttpServletRequest request) {
		request.setAttribute("loginName", request.getSession().getAttribute("loginName"));
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addHuntPage(ModelMap model, @RequestParam String pokemon, 
								@RequestParam String generation, @RequestParam String encounters, HttpServletRequest request) {
		request.setAttribute("loginName", request.getSession().getAttribute("loginName"));
		
		String success = "Could not add hunt";
		
		if(pokemon != null && generation != null && encounters != null && request.getSession().getAttribute("loginName") != null)
		{
			String username = (String) request.getSession().getAttribute("loginName");
			if(vService.validatePerson(username) && vService.validatePokemon(pokemon) && vService.isNumeric(encounters))
			{
				aService.addHunt(pokemon, generation, encounters, username);
				success = " ** Hunt added **";
			}
		}
		model.put("outcome", success);
		
		return "add";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteHuntPage(ModelMap model, @RequestParam int hid, HttpServletRequest request)
	{
		List<FormattedHunts> thisHunt = new ArrayList<FormattedHunts>();
		
		thisHunt = lhService.huntsToFhunts(huntsRepository.findByHid(hid));
		model.put("hid", hid);
		model.put("hunts", thisHunt);
		
		return "delete";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String deleteHuntAction(ModelMap model, @RequestParam(value="hid") int hid, HttpServletRequest request)
	{
		huntsRepository.deleteById(hid);
		
		return "records";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String aboutHuntPage(ModelMap model, @RequestParam int hid, HttpServletRequest request)
	{
		List<FormattedHunts> thisHunt = new ArrayList<FormattedHunts>();
		
		thisHunt = lhService.huntsToFhunts(huntsRepository.findByHid(hid));
		model.put("hid", hid);
		model.put("hunts", thisHunt);
		
		return "about";
	}
}
