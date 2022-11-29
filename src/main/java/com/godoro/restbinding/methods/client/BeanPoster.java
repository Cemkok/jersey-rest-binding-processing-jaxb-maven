package com.godoro.restbinding.methods.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import com.godoro.restbinding.document.Product;

public class BeanPoster {
	public static void main(String[] args) {
		

		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client
				.target("http://localhost:8089/restbinding/rest")
				.path("method")
				.path("binding");
	
			
			Product product = new Product();
			product.setProductId(401L);
			product.setProductName("Cep telefonu");
			product.setSalesPrice(1460.0);
			
				target.request("application/json; charset=UTF-8") 
				                 //gönderi        //media typ                     //return typ
			 .post(Entity.entity(product, "application/json; charset=UTF-8"), Void.class);
		
				
			
			
		}

}
