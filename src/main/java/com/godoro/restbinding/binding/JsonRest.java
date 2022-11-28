package com.godoro.restbinding.binding;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.godoro.restbinding.document.Product;
//jax-p =  processing, jax-b jax binding
@Path("/json")
public class JsonRest {
	
	@GET
	@Path("processing")
	@Produces("application/json; charset=UTF-8")
	//JsonP (processing)
	public String getProcessing() {
		
		return Json.createObjectBuilder()
				.add("productId",401L )
				.add("productName","Cep TELEFONU")
				.add("salesPrice", 1300.0)
				.build()
				.toString()
				
				
				;
		
		
		
	}
	@GET
	@Path("binding")
	@Produces("application/json; charset=UTF-8")
	//JsonB (binding) kullanıyoruz
	public Product getBinding() {
		
		Product product = new Product();
		product.setProductId(401L);
		product.setProductName("Cep telefonu");
		product.setSalesPrice(1456.0);
		
		
		return product;
				
				
				
		
		
		
	}
	
	

}
