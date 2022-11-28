package com.godoro.restbinding.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.godoro.restbinding.document.Product;

public class BeanClient {
	
	
		
		public static void main(String[] args) {
			
			Client client = ClientBuilder.newClient();
			
			WebTarget target = client
					.target("http://localhost:8089/restbinding/rest")
					.path("json")
					.path("binding");
			
			Product product=target.request("application/json; charset=UTF-8")
					.get(Product.class);
			System.out.println("Düz:\n"+product);
				
			
			
		

	}}


