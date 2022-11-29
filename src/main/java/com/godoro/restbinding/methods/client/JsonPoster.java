package com.godoro.restbinding.methods.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class JsonPoster {
	public static void main(String[] args) {
		

	
	Client client = ClientBuilder.newClient();
	
	WebTarget target = client
			.target("http://localhost:8089/restbinding/rest")
			.path("method")
			.path("plain");
	
	String plain="{\n" +
	"\t\"productId\":401, \n"+
			"\t\"productName\":\"Cep Telefonu\",\n"+
			"\t\"salesPrice\":1300.0\n"	+
			 "}";
			target.request("application/json; charset=UTF-8") 
			                 //gönderi        //media typ                     //return typ
		 .post(Entity.entity(plain, "application/json; charset=UTF-8"), Void.class);
	
			System.out.println("Düz:\n"+ plain);
		
	}
}
