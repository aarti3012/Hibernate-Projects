package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Account {
	@Id
	private long acNo;
	private String acNme;
	private String Address;
	private long mobileNo;
	private long aadharNo;
	private String panNo;
	private double balance;
	private String acType;
	private String gender;
	
	public long getAcNo() {
		return acNo;
	}
	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}
	public String getAcNme() {
		return acNme;
	}
	public void setAcNme(String acNme) {
		this.acNme = acNme;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Account [acNo=" + acNo + ", acNme=" + acNme + ", Address=" + Address + ", mobileNo=" + mobileNo
				+ ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", balance=" + balance + ", acType=" + acType
				+ ", gender=" + gender + "]";
	}
	
	
}
