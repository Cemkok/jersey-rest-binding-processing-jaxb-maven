package com.godoro.restbinding.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class JsonClient {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client
				.target("http://localhost:8089/restbinding/rest")
				.path("Xml")
				.path("binding");
		
		String plain=target.request("application/xml; charset=UTF-8")
				.get(String.class);
		System.out.println("Düz:\n"+plain);
		
		
	}

}
