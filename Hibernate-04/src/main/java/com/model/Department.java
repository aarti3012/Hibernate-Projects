package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
    private int did;
    private String dname;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL) // Use mappedBy for bi-directional mapping
    private Set<Employe> eSet = new HashSet<>();

    // Getters and Setters
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Set<Employe> geteSet() {
        return eSet;
    }

    public void seteSet(Set<Employe> eSet) {
        this.eSet = eSet;
    }

    @Override
    public String toString() {
        return "Department [did=" + did + ", dname=" + dname + "]";
    }
}