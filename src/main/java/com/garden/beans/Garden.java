package com.garden.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Garden extends NamedEntity {
	private String type;
	private Long gardenSquareFeet;

	@OneToOne
	private ResidentialAddress address;

	@ManyToOne
	private GardenOwner owner;

	@ManyToOne
	private GardenDesigner designer;

	@OneToMany
	private List<Plant> plants;

	@OneToMany
	private List<GardenOrnament> ornaments;

	public Long getGardenSquareFeet() {
		return gardenSquareFeet;
	}

	public void setGardenSquareFeet(final Long gardenSquareFeet) {
		this.gardenSquareFeet = gardenSquareFeet;
	}

	public GardenOwner getOwner() {
		return owner;
	}

	public void setOwner(final GardenOwner owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public List<Plant> getPlants() {
		if (plants == null) {
			plants = new ArrayList<>();
		}
		return plants;
	}

	public void setPlants(final List<Plant> plants) {
		this.plants = plants;
	}

	public List<GardenOrnament> getOrnaments() {
		if (ornaments == null) {
			ornaments = new ArrayList<>();
		}
		return ornaments;
	}

	public void setOrnaments(final List<GardenOrnament> ornaments) {
		this.ornaments = ornaments;
	}

	public ResidentialAddress getAddress() {
		return address;
	}

	public void setAddress(final ResidentialAddress address) {
		this.address = address;
	}

	public GardenDesigner getDesigner() {
		return designer;
	}

	public void setDesigner(final GardenDesigner designer) {
		this.designer = designer;
	}

}
