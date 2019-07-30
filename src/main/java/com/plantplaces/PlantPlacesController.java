package com.plantplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plantplaces.DTO.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@Controller
public class PlantPlacesController {
	
	@Autowired
	private ISpecimenService specimenServiceStub;
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET, headers= {"Content-Type=text/json"})
	public String readJSON() {
		return "start";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public SpecimenDTO read(Model model) {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		model.addAttribute("specimenDTO", specimenDTO);
		return specimenDTO;
	}
	
	/**
	 * Handle the /index endpoint
	 * @return
	 */
	@PostMapping("/start")
	public String create() {
		return "start";
	}
	

	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET, params = {"loyalty=blue"})
	public String readBlue() {
		System.out.println("blue is read");
		return "start";
	}
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET, params = {"loyalty=silver"})
	public ModelAndView readSilver() {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("start");
		modelAndView.addObject("specimenDTO", specimenDTO);
		
		return modelAndView;
	}
	
	/**
	 * Handle the /index endpoint
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "start ";
	}
	
	
	/**
	 * Handle the /start endpoint
	 * @return
	 */
	@RequestMapping(value="/addSpecimen", method=RequestMethod.GET)
	public String addSpecimen(Model model, @RequestParam(value="latitude", required=false, defaultValue="0.0") String latitude) {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		
		return "start";
	}
}
