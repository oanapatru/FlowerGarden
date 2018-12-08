package com.garden.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class GardenDesigner extends Person {
	private String degree;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "designer_specialties", joinColumns = @JoinColumn(name = "designer_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Specialty> specialties;

	private String companyName;

	@OneToMany(mappedBy = "designer")
	private Set<Garden> gardens;

	public String getDegree() {
		return degree;
	}

	public void setDegree(final String degree) {
		this.degree = degree;
	}

	public Set<Specialty> getSpecialties() {
		if (specialties == null) {
			specialties = new HashSet<>();
		}
		return specialties;
	}

	public void setSpecialties(final Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	public Set<Garden> getGardens() {
		if (gardens == null) {
			gardens = new HashSet<>();
		}
		return gardens;
	}

	public void setGardens(final Set<Garden> gardens) {
		this.gardens = gardens;
	}

	@Override
	public String toString() {
		return "GardenDesigner [degree=" + degree + ", specialties=" + getSpecialties() + ", companyName=" + companyName
				+ ", gardens=" + gardens + "]";
	}

}
