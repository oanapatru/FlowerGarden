package com.garden.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Juergen Hoeller
 *         Can be TREE, FLOWER, GRASS, BUSH...
 */
@Entity
@Table(name = "plant_type")
public class PlantType extends NamedEntity {
	public PlantType() {
		super();
	}

	public PlantType(final String aname) {
		this();
		setName(aname);
	}

}
