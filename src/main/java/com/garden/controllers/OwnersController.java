package com.garden.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garden.data.GardenOwnerRepository;

@Controller
@RequestMapping("/owners")
public class OwnersController {

	private GardenOwnerRepository repository;

	public OwnersController(final GardenOwnerRepository repository) {
		this.repository = repository;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listOwners(final Model model) {
		model.addAttribute("owners", repository.findAll());
		return "owners/index";

	}

}
