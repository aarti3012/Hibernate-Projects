package com.model;

import javax.persistence.Entity;

@Entity
public class DyPune extends DyPatil {
 private boolean hostelFcility;

public boolean isHostelFcility() {
	return hostelFcility;
}

public void setHostelFcility(boolean hostelFcility) {
	this.hostelFcility = hostelFcility;
}

@Override
public String toString() {
	return "DyPune [hostelFcility=" + hostelFcility + "]";
}
 
}
