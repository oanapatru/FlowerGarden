package com.garden.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garden.data.GardenRepository;

@Controller
@RequestMapping("/gardens")
public class GardenController {

	private GardenRepository repository;

	public GardenController(final GardenRepository repository) {
		this.repository = repository;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listGardens(final Model model) {
		model.addAttribute("gardens", repository.findAll());
		return "gardens/index";

	}

}
