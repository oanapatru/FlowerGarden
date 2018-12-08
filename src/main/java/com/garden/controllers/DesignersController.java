package com.garden.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garden.data.GardenDesignerRepository;

@Controller
@RequestMapping("/designers")
public class DesignersController {

	private GardenDesignerRepository repository;

	public DesignersController(final GardenDesignerRepository repository) {
		this.repository = repository;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listDesigners(final Model model) {
		model.addAttribute("designers", repository.findAll());
		return "designers/index";

	}

}
