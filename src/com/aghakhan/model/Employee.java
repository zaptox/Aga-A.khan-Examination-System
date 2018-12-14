package com.aghakhan.model;

public class Employee {
 private Integer id;
 private String picture;
 private  String name;
 private String password;
 private String dob;
 private String gender;
 private String contact;
 private String created_at;
 private String updated_at;
 
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getCreated_at() {
	return created_at;
}
public void setCreated_at(String created_at) {
	this.created_at = created_at;
}
public String getUpdated_at() {
	return updated_at;
}
public void setUpdated_at(String updated_at) {
	this.updated_at = updated_at;
}
public Employee(Integer id, String picture, String name, String password, String dob, String gender, String contact,
		String created_at, String updated_at) {
	super();
	this.id = id;
	this.picture = picture;
	this.name = name;
	this.password = password;
	this.dob = dob;
	this.gender = gender;
	this.contact = contact;
	this.created_at = created_at;
	this.updated_at = updated_at;
}
 
public Employee(){}
}
