package com.example.prueva.backend.store.controllers;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueva.backend.store.DTO.DeleteProductDTO;
import com.example.prueva.backend.store.DTO.SellProductDTO;
import com.example.prueva.backend.store.DTO.UpdateStock;
import com.example.prueva.backend.store.DTO.UserDTO;
import com.example.prueva.backend.store.models.Product;
import com.example.prueva.backend.store.models.Rol;
import com.example.prueva.backend.store.models.User;
import com.example.prueva.backend.store.models.Record;
import com.example.prueva.backend.store.pojos.RecordPojo;
import com.example.prueva.backend.store.services.ServiceD;

/*import com.example.prueva.backend.DTO.SellProductDTO;
import com.example.prueva.backend.DTO.UserDTO;
import com.example.prueva.backend.models.Rol;
import com.example.prueva.backend.services.IService;*/

@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	@Autowired ServiceD   service;
	/* 1._seller
	 * 2._storer
	 * 3._manager
	 */
	@PostMapping(value="/users")
	public String createUser(@RequestBody(required = true) UserDTO userDto ) {
		System.out.println("el user Dto es "+userDto);
		//System.out.println("rol "+this.service.getRol(userDto.getRol_id()));
		Rol rol=this.service.getRol(userDto.getRol_id()).get();
		System.out.println("el "+rol);
		User user=new User(userDto.getName(),userDto.getLast_name(),rol);
		System.out.println("user DTO "+user);
		User _user=this.service.setAddUser(user).get();
		System.out.println("el user es "+_user);
		return "";
	}
	
	/* 1._seller
	 * 2._storer
	 * 3._manager
	 */
	@PostMapping(value="/users/sell-products")
	public String SellProduct(@RequestBody(required=true) SellProductDTO sellProduct) {
		System.out.println("productos a vender "+sellProduct);
		//buscar usuario
		System.out.println("el usuario es "+this.service.getUser(sellProduct.getId_user()));
		User user=this.service.getUser(sellProduct.getId_user()).get();
		System.out.println("puede vender ::: "+user.getRol().getId());
		if(user.getRol().getId()==1 || user.getRol().getId()==3) {
			System.out.println("puede vender");
			//buscar el producto
			System.out.println("el product es "+this.service.getProduct(sellProduct.getId_user()));
			Product product=this.service.getProduct(sellProduct.getId_user()).get();
			Integer stock=product.getStock()-sellProduct.getQuantity_sale();
			System.out.println("el stock es "+stock);
			product.setStock(stock);
			this.service.updateProduct(product);
			RecordPojo record=new RecordPojo();
			record.setName_product(product.getName_product());
			record.setStatus("sell");
			System.out.println("pojo "+record);
			Record r=new Record(record.getName_product(),record.getStatus(),user);
			this.service.saveRecord(r);
			return "vendido";
		}
		else {
			return "no autorizado";
		}
	}
	
	/* 1._seller
	 * 2._storer
	 * 3._manager
	 */
	@PostMapping(value="/users/stock-products")
	public String UpdateStockProduct(@RequestBody(required=true) UpdateStock updateStock ) {
		System.out.println("Update Stock "+updateStock);
		//buscar usuario
		System.out.println("el usuario es "+this.service.getUser(updateStock.getId_user()));
		User user=this.service.getUser(updateStock.getId_user()).get();
		if(user.getRol().getId()==2 || user.getRol().getId()==3) {
			System.out.println("el product es "+this.service.getProduct(updateStock.getId_product()));
			Product product=this.service.getProduct(updateStock.getId_product()).get();
			
			if(updateStock.getAction().equalsIgnoreCase("sumar")) {
				Integer stock=product.getStock()+updateStock.getQuantity();
				System.out.println("el stock es "+stock);
				product.setStock(stock);
				System.out.println("sumar stock "+updateStock);
				this.service.updateProduct(product);
				RecordPojo record=new RecordPojo();
				record.setName_product(product.getName_product());
				record.setStatus("update stock");
				System.out.println("pojo "+record);
				Record r=new Record(record.getName_product(),record.getStatus(),user);
				this.service.saveRecord(r);
			}
			if(updateStock.getAction().equalsIgnoreCase("restar")) {
				Integer stock=product.getStock()-updateStock.getQuantity();
				System.out.println("el stock es "+stock);
				product.setStock(stock);
				System.out.println("sumar stock "+updateStock);
				this.service.updateProduct(product);
				System.out.println("restar stock "+updateStock);
				RecordPojo record=new RecordPojo();
				record.setName_product(product.getName_product());
				record.setStatus("update stock");
				System.out.println("pojo "+record);
				Record r=new Record(record.getName_product(),record.getStatus(),user);
				this.service.saveRecord(r);
			}
			return "stock actualizado";
		}
		else {
			return "no autorizado";
		}
	}
	
	@PostMapping(value="/users/delete-products")
	public String DeleteProduct(@RequestBody(required=true) DeleteProductDTO deleteProductDto) {
		System.out.println("delete product "+deleteProductDto);
		//buscar usuario
		System.out.println("el usuario es "+this.service.getUser(deleteProductDto.getId_user()));
		User user=this.service.getUser(deleteProductDto.getId_user()).get();
		if(user.getRol().getId()==3) {
			//buscar productos
			System.out.println("el product es "+this.service.getProduct(deleteProductDto.getId_product()));
			Product product=this.service.getProduct(deleteProductDto.getId_product()).get();
			
			this.service.deleteProduct(deleteProductDto.getId_product());
			RecordPojo record=new RecordPojo();
			record.setName_product(product.getName_product());
			record.setStatus("delete stock");
			System.out.println("pojo "+record);
			Record r=new Record(record.getName_product(),record.getStatus(),user);
			this.service.saveRecord(r);
			return "producto eliminado";
		}
		else {
			return "no autorizado";
		}
			
	}
	

	@PostMapping(value="/users/record-products")
	public Collection<Record> ListRecords(@RequestBody(required=true) HashMap<String,Integer> id_user) {
		System.out.println("id user "+id_user.get("id_user"));
		Integer id=id_user.get("id_user");
		Integer rol=id_user.get("rol_id");
		if(rol==3) {
			return this.service.getRecords(id);
			
		}
		else {
			return null ;
		}
	}
	
	
	
	
	
	
	
}