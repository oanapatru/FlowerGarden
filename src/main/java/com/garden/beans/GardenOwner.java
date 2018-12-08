package com.garden.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class GardenOwner extends Person {
	private String paymentType;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Garden> gardens;

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(final String paymentType) {
		this.paymentType = paymentType;
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
		return "GardenOwner [paymentType=" + paymentType + ", gardens=" + gardens + "]";
	}

}
