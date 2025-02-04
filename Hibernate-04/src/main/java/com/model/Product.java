package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Product {
	@Id
		private int pid;
		private String pname;
		private String color;
		@ManyToMany
		private Set<Customer> cSet;
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public Set<Customer> getcSet() {
			return cSet;
		}
		public void setcSet(Set<Customer> cSet) {
			this.cSet = cSet;
		}
		@Override
		public String toString() {
			return "Customer [pid=" + pid + ", pname=" + pname + ", color=" + color + ", cSet=" + cSet + "]";
		}
		public Product(int pid, String pname, String color, Set<Customer> cSet) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.color = color;
			this.cSet = cSet;
		}
		public Product() {
			super();
			
		}
		
	}


