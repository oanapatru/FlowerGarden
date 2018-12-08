package com.garden.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Plant extends BaseEntity {
	private String plantType;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Painter> painters;

	private float origX;
	private float origY;
	private float height;
	private float width;

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(final String plantType) {
		this.plantType = plantType;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(final float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(final float width) {
		this.width = width;
	}

	public float getOrigX() {
		return origX;
	}

	public void setOrigX(final float origX) {
		this.origX = origX;
	}

	public float getOrigY() {
		return origY;
	}

	public void setOrigY(final float origY) {
		this.origY = origY;
	}

	public Set<Painter> getPainters() {
		if (painters == null) {
			painters = new HashSet<>();
		}
		return painters;
	}

	public void setPainters(final Set<Painter> painters) {
		this.painters = painters;
	}

	@Override
	public String toString() {
		return "Plant [id=" + id + ", plantType=" + plantType + ", painters=" + painters + ", origX=" + origX
				+ ", origY=" + origY + ", height=" + height + ", width=" + width + "]";
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
		Plant other = (Plant) obj;
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
