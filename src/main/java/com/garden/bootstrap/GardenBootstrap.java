package com.garden.bootstrap;

import java.awt.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.garden.beans.Garden;
import com.garden.beans.GardenDesigner;
import com.garden.beans.GardenOwner;
import com.garden.beans.Painter;
import com.garden.beans.Plant;
import com.garden.beans.ResidentialAddress;
import com.garden.beans.Specialty;
import com.garden.data.GardenDesignerRepository;
import com.garden.data.GardenOrnamentRepository;
import com.garden.data.GardenOwnerRepository;
import com.garden.data.GardenRepository;
import com.garden.data.PainterRepository;
import com.garden.data.PlantRepository;
import com.garden.data.ResidenceAddressRepository;
import com.garden.data.SpecialtyRepository;

@Component
public class GardenBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	// http://localhost:8080/h2-console
	// jdbc URL: jdbc:h2:mem:testdb

	@Autowired
	private PlantRepository plantRepository;

	@Autowired
	private PainterRepository paintRepository;

	@Autowired
	private GardenOwnerRepository ownerRepository;

	@Autowired
	private GardenDesignerRepository designerRepository;

	@Autowired
	private GardenOrnamentRepository ornamentRepository;

	@Autowired
	private ResidenceAddressRepository addressRepository;

	@Autowired
	private GardenRepository gardenRepository;

	@Autowired
	private SpecialtyRepository specialtyRepository;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {
		GardenOwner jim = createOwner("Jim", "Smith");
		ownerRepository.save(jim);
		GardenDesigner joe = createDesigner("Joe", "Acosta");
		for (Specialty spec : joe.getSpecialties()) {
			specialtyRepository.save(spec);
		}
		designerRepository.save(joe);

		ResidentialAddress address = createResidentialAddress("Scottsdale Rd", "85254");
		addressRepository.save(address);

		Garden garden = createGarden(address, jim, joe);

		gardenRepository.save(garden);
		ownerRepository.save(jim);
	}

	protected GardenOwner createOwner(final String firstName, final String lastName) {
		GardenOwner bean = new GardenOwner();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setPaymentType("CASH");
		return bean;
	}

	protected GardenDesigner createDesigner(final String firstName, final String lastName) {
		GardenDesigner bean = new GardenDesigner();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setCompanyName("BlueLagoon");
		bean.setDegree("1st");
		bean.getSpecialties().add(new Specialty("floral"));
		bean.getSpecialties().add(new Specialty("japanese"));
		return bean;
	}

	protected ResidentialAddress createResidentialAddress(final String streetName, final String zipCode) {
		return createResidentialAddress(false, streetName, zipCode);
	}

	protected ResidentialAddress createResidentialAddress(final boolean appartment, final String streetName,
			final String zipCode) {
		ResidentialAddress bean = new ResidentialAddress();

		bean.setStreetName(streetName);
		bean.setStreetNumber(22);
		if (appartment) {
			bean.setAppartmentNumber(201);
		}

		switch (zipCode) {
			case "11111":
				bean.setAddressState("NY");
				bean.setCity("New York");
				bean.setZipCode(zipCode);
				break;

			case "85254":
				bean.setAddressState("AZ");
				bean.setCity("Phoenix");
				bean.setZipCode(zipCode);
				break;
		}

		return bean;
	}

	protected Garden createGarden(final ResidentialAddress address, final GardenOwner owner,
			final GardenDesigner designer) {
		Garden bean = new Garden();

		bean.getPlants().add(createTree("OAK", 200, 200));
		bean.getPlants().add(createFlower("SIMPLE", Color.RED, 50, 150));
		bean.getPlants().add(createFlower("SIMPLE", Color.BLUE, 350, 180));
		bean.getPlants().add(createFlower("SIMPLE", Color.ORANGE, 250, 250));

		bean.setOwner(owner);
		bean.setDesigner(designer);
		bean.setAddress(address);
		bean.setGardenSquareFeet(25000L);
		bean.setName("main");
		return bean;
	}

	protected Plant createTree(final String type, final float x, final float y) {
		Plant oak = new Plant();
		oak.setPlantType("TREE");
		oak.setOrigX(x);
		oak.setOrigY(y);

		Painter leaf = new Painter(Color.GREEN);
		leaf.setShape(type);
		leaf.setLabel("LEAF");
		paintRepository.save(leaf);
		oak.getPainters().add(leaf);

		Painter stem = new Painter(125, 125, 0);
		stem.setShape(type);
		stem.setLabel("STEM");
		paintRepository.save(stem);
		oak.getPainters().add(stem);
		plantRepository.save(oak);
		return oak;
	}

	protected Plant createFlower(final String type, final Color color, final float x, final float y) {
		Plant flower = new Plant();
		flower.setPlantType("FLOWER");
		flower.setOrigX(x);
		flower.setOrigY(y);

		Painter petals = new Painter(color);
		petals.setShape(type);
		petals.setLabel("PETAL");
		paintRepository.save(petals);
		flower.getPainters().add(petals);

		Painter mid = new Painter(Color.YELLOW);
		mid.setShape(type);
		mid.setLabel("MID");
		paintRepository.save(mid);
		flower.getPainters().add(mid);

		Painter leaf = new Painter(Color.GREEN);
		leaf.setShape(type);
		leaf.setLabel("LEAF");
		paintRepository.save(leaf);
		flower.getPainters().add(leaf);
		plantRepository.save(flower);
		return flower;
	}
}
