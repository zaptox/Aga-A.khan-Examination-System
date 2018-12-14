package com.aghakhan.model;

public class Subjects {
	
	Integer id; 
	String name;
	String classs;
	String group;
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
	public Subjects(Integer id, String name, String classs, String group, String created_at, String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.classs = classs;
		this.group = group;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Subjects(){}

}
