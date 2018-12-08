package com.garden.beans;

import javax.persistence.Entity;

@Entity
public class Specialty extends NamedEntity {
	public Specialty() {
		super();
	}

	public Specialty(final String aname) {
		this();
		setName(aname);
	}
}
