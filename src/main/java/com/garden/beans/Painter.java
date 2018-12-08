package com.garden.beans;

import java.awt.Color;

import javax.persistence.Entity;

@Entity
public class Painter extends BaseEntity {

	private String label;
	private String shape;
	private Integer red;
	private Integer green;
	private Integer blue;
	private Integer alpha;

	public Painter() {

	}

	public Painter(final Color color) {
		this(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}

	public Painter(final int red, final int green, final int blue) {
		this(red, green, blue, 255);
	}

	public Painter(final int red, final int green, final int blue, final int alpha) {
		this();
		this.red = red;
		this.blue = blue;
		this.green = green;
		this.alpha = alpha;
	}

	public Color getColor() {
		return new Color(red, blue, green, alpha);
	}

	public Integer getRed() {
		return red;
	}

	public void setRed(final Integer red) {
		this.red = red;
	}

	public Integer getBlue() {
		return blue;
	}

	public void setBlue(final Integer blue) {
		this.blue = blue;
	}

	public Integer getGreen() {
		return green;
	}

	public void setGreen(final Integer green) {
		this.green = green;
	}

	public Integer getAlpha() {
		return alpha;
	}

	public void setAlpha(final Integer alpha) {
		this.alpha = alpha;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(final String shape) {
		this.shape = shape;
	}

	@Override
	public String toString() {
		return "Painter [id=" + getId() + ", red=" + red + ", green=" + green + ", blue=" + blue + ", alpha=" + alpha
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getId() == null ? 0 : getId().hashCode());
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
		Painter other = (Painter) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

}
