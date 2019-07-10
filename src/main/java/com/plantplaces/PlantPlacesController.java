package com.plantplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlantPlacesController {
	
	/**
	 * Handle the /start endpoin
	 * @return
	 */
	@RequestMapping("/start")
	public String start() {
		return "start";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
