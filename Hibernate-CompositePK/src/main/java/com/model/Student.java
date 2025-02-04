package com.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Student {
@EmbeddedId
	private StudentId studentId;
	
	private String name;
	private long mono;
	public StudentId getStudentId() {
		return studentId;
	}
	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMono() {
		return mono;
	}
	public void setMono(long mono) {
		this.mono = mono;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", mono=" + mono + "]";
	}
	
	
	
}
