package com.example.prueva.backend.store.DTO;

public class UpdateStock {

	Integer id_user;
	
	Integer quantity;
	
	Integer  id_product;
	
	String  action;

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "UpdateStock [id_user=" + id_user + ", quantity=" + quantity + ", id_product=" + id_product + ", action="
				+ action + "]";
	}
	
	
	
	
}
