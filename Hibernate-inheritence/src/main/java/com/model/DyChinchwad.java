package com.model;

import javax.persistence.Entity;

@Entity
public class DyChinchwad extends DyPatil{

	private boolean busFacility;

	public boolean isBusFacility() {
		return busFacility;
	}

	public void setBusFacility(boolean busFacility) {
		this.busFacility = busFacility;
	}

	@Override
	public String toString() {
		return "DyChinchwad [busFacility=" + busFacility + "]";
	}
	
}
