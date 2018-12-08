package com.garden.beans;

import javax.persistence.Entity;

@Entity
public class ResidentialAddress extends BaseEntity {

	private String streetName;
	private Integer streetNumber;
	private Integer appartmentNumber;
	private String city;
	private String addressState;
	private String zipCode;
	private String residenceType;

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(final String residenceType) {
		this.residenceType = residenceType;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(final String streetName) {
		this.streetName = streetName;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(final Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Integer getAppartmentNumber() {
		return appartmentNumber;
	}

	public void setAppartmentNumber(final Integer appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(final String addressState) {
		this.addressState = addressState;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "ResidentialAddress [id=" + id + ", streetName=" + streetName + ", streetNumber=" + streetNumber
				+ ", appartmentNumber=" + appartmentNumber + ", city=" + city + ", addressState=" + addressState
				+ ", zipCode=" + zipCode + ", residenceType=" + residenceType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ResidentialAddress other = (ResidentialAddress) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
