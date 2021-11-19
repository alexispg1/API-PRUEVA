package com.example.prueva.backend.store.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueva.backend.store.models.Product;
import com.example.prueva.backend.store.models.Rol;
import com.example.prueva.backend.store.models.User;
import com.example.prueva.backend.store.models.Record;
import com.example.prueva.backend.store.repository.RolRepository;
import com.example.prueva.backend.store.repository.UserRepository;
import com.example.prueva.backend.store.repository.ProductRepository;
import com.example.prueva.backend.store.repository.RecordRepository;


@Service
public class ServiceD {
	@Autowired UserRepository userRepository;
	@Autowired RolRepository rolRepository;
	@Autowired ProductRepository productRepository;
	@Autowired RecordRepository recordRepostitory;


	public Optional<User> setAddUser(User user){
		User _user=this.userRepository.save(user);
		return Optional.of(_user);
	}

	public Optional<User> getUser(Integer id) {
		return Optional.of(this.userRepository.getById(id));
	}
	
	
	public Optional<Rol> getRol(Integer id) {
		Rol rol =this.rolRepository.getById(id);
		return Optional.of(rol);
	}
	
	public Optional<Product> updateProduct(Product product){
		return Optional.of(this.productRepository.save(product));
	}
	
	public Optional<String> deleteProduct(Integer id){
		this.productRepository.deleteById(id);
		return Optional.of("eliminado");
	}
	
	public Optional<Product> getProduct(Integer id){
		return Optional.of(this.productRepository.getById(id));
	}
	
	public Optional<Record> saveRecord(Record record){
		return Optional.of(this.recordRepostitory.save(record));
	}
	
	public Collection<Record> getRecords(Integer user_id){
		return this.recordRepostitory.getRecords(user_id);
	}

	
}
