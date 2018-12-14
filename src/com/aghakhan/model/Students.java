package com.aghakhan.model;

public class Students {
private int id ;
private String name;
private String father;
private String cast;
private int age ;
private String picture;
private String nic;
private String dob;
private String contact;
private String religion;
private String seatno;
private String created_at;
private String updated_at;
private String classs ;
private String group ;
private String subjects ;



public Students(){}



public Students(int id, String name, String father, String cast, int age, String picture, String nic, String dob,
		String contact, String religion, String seatno, String created_at, String updated_at) {
	super();
	this.id = id;
	this.name = name;
	this.father = father;
	this.cast = cast;
	this.age = age;
	this.picture = picture;
	this.nic = nic;
	this.dob = dob;
	this.contact = contact;
	this.religion = religion;
	this.seatno = seatno;
	this.created_at = created_at;
	this.updated_at = updated_at;
}



public Students(int id, String name, String father, String cast, int age, String picture, String nic, String dob,
		String contact, String religion, String seatno, String created_at, String updated_at, String classs,
		String group) {
	super();
	this.id = id;
	this.name = name;
	this.father = father;
	this.cast = cast;
	this.age = age;
	this.picture = picture;
	this.nic = nic;
	this.dob = dob;
	this.contact = contact;
	this.religion = religion;
	this.seatno = seatno;
	this.created_at = created_at;
	this.updated_at = updated_at;
	this.classs = classs;
	this.group = group;
}




public Students(int id, String name, String father, String cast, int age, String picture, String nic, String dob,
		String contact, String religion, String seatno, String created_at, String updated_at, String classs,
		String group, String subjects) {
	super();
	this.id = id;
	this.name = name;
	this.father = father;
	this.cast = cast;
	this.age = age;
	this.picture = picture;
	this.nic = nic;
	this.dob = dob;
	this.contact = contact;
	this.religion = religion;
	this.seatno = seatno;
	this.created_at = created_at;
	this.updated_at = updated_at;
	this.classs = classs;
	this.group = group;
	this.subjects = subjects;
}



public String getSubjects() {
	return subjects;
}



public void setSubjects(String subjects) {
	this.subjects = subjects;
}



public String getClasss() {
	return classs;
}



public void setClasss(String classs) {
	this.classs = classs;
}



public String getGroup() {
	return group;
}



public void setGroup(String group) {
	this.group = group;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFather() {
	return father;
}
public void setFather(String father) {
	this.father = father;
}
public String getCast() {
	return cast;
}
public void setCast(String cast) {
	this.cast = cast;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getNic() {
	return nic;
}
public void setNic(String nic) {
	this.nic = nic;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getReligion() {
	return religion;
}
public void setReligion(String religion) {
	this.religion = religion;
}
public String getSeatno() {
	return seatno;
}
public void setSeatno(String seatno) {
	this.seatno = seatno;
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






}
