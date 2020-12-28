package com.vastika.uis.model;

import java.util.Date;

public class User {
private int id;
private String userName;
private String password;
private long mobineNo;
private Date dob;
private double salary;
private boolean isActive;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getMobineNo() {
	return mobineNo;
}
public void setMobineNo(long mobineNo) {
	this.mobineNo = mobineNo;
}

public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}

}
