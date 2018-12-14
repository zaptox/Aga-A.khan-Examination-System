package com.aghakhan.model;

public class Group {
Integer id;
String name;

String created_at;
String updated_at;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public Group(Integer id, String name,  String created_at, String updated_at) {
	super();
	this.id = id;
	this.name = name;

	this.created_at = created_at;
	this.updated_at = updated_at;
}
public Group(){}


}
