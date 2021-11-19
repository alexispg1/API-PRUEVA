package com.example.prueva.backend.store.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="records")
public class Record implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column(name="product")
	String name_product;
	
	@Column(name="status")
	String status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	User user; //user_id
 
	
	
	public Record(String name_product, String status, User user) {
		super();
		this.name_product = name_product;
		this.status = status;
		this.user = user;
	}
	
	


	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
		return "Record [id=" + id + ", name_product=" + name_product + ", status=" + status + ", user=" + user + "]";
	}
	
	





	
	
	
	
}
