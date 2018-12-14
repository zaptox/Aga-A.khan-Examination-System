package com.aghakhan.model;

public class Classes {
	Integer id;
	String name; 
	String type; 
	String created_at; 
	String updated_at;
	
	public Classes() {
		// TODO Auto-generated constructor stub
	}

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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Classes(Integer id, String name, String type, String created_at, String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 
		

}
