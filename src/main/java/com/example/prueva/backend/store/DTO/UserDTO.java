package com.example.prueva.backend.store.DTO;

public class UserDTO {
	
	String name;
	
	String last_name;
	
	Integer rol_id;
	

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getRol_id() {
		return rol_id;
	}

	public void setRol_id(Integer rol_id) {
		this.rol_id = rol_id;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", last_name=" + last_name + ", rol_id=" + rol_id + "]";
	}
	
}
