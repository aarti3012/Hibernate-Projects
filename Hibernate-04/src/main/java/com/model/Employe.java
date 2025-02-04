package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employe {

    @Id
    private int eid;
    private String ename;
    private long mono;

    @ManyToOne
    private Department dept;

    // No-arg constructor (required by Hibernate)
    public Employe() {}

    // Constructor without department
    public Employe(int eid, String ename, long mono) {
        super();
        this.eid = eid;
        this.ename = ename;
        this.mono = mono;
    }

    // Constructor with department
    public Employe(int eid, String ename, long mono, Department dept) {
        super();
        this.eid = eid;
        this.ename = ename;
        this.mono = mono;
        this.dept = dept;
    }

    // Getters and Setters
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public long getMono() {
        return mono;
    }

    public void setMono(long mono) {
        this.mono = mono;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employe [eid=" + eid + ", ename=" + ename + ", mono=" + mono + "]";
    }
}