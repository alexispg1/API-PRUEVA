package com.example.prueva.backend.store.DTO;

public class SellProductDTO {
	
	Integer id_user;
	
	Integer quantity_sale;
	
	Integer  id_product;
	
	public SellProductDTO() {
		super();
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getQuantity_sale() {
		return quantity_sale;
	}

	public void setQuantity_sale(Integer quantity_sale) {
		this.quantity_sale = quantity_sale;
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	@Override
	public String toString() {
		return "SellProduct [id_user=" + id_user + ", quantity_sale=" + quantity_sale + ", id_product=" + id_product
				+ "]";
	}

	
}

