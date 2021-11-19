package com.example.prueva.backend.store.pojos;

import javax.persistence.Column;

public class RecordPojo {
	
	String name_product;
	
	String status;


	public RecordPojo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName_product() {
		return name_product;
	}



	public void setName_product(String name_product) {
		this.name_product = name_product;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "RecordPojo [name_product=" + name_product + ", status=" + status + "]";
	}
	
	

}
