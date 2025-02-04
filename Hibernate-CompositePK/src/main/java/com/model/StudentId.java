package com.model;

import java.io.Serializable;
import java.util.Objects;

public class StudentId implements Serializable {
	private int studentId;
	private int instituteId;
	
	public StudentId(int studentId,int instituteId) {
		this.studentId=studentId;
		this.instituteId=instituteId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instituteId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentId other = (StudentId) obj;
		return instituteId == other.instituteId && studentId == other.studentId;
	}

}
