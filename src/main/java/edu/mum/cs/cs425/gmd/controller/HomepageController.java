package edu.mum.cs.cs425.gmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String homepage() {
		return "homepage/index";
	}
}
