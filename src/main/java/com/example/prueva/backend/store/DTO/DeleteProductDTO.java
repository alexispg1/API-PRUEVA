package com.example.prueva.backend.store.DTO;

public class DeleteProductDTO {
	
	Integer id_user;
	
	Integer  id_product;
	
	
	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	@Override
	public String toString() {
		return "DeleteProduct [id_user=" + id_user + ", id_product=" + id_product + "]";
	}
	
	

}
