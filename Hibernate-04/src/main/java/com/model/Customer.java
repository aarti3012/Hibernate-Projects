package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
@Id
	private int cid;
    private String cname;
    private String mono;
    
    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Product> pSet;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMono() {
		return mono;
	}

	public void setMono(String mono) {
		this.mono = mono;
	}

	public Set<Product> getpSet() {
		return pSet;
	}

	public void setpSet(Set<Product> pSet) {
		this.pSet = pSet;
	}

	public Customer(int cid, String cname, String mono, Set<Product> pSet) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.mono = mono;
		this.pSet = pSet;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", mono=" + mono + ", pSet=" + pSet + "]";
	}
	
 
    
	
}
