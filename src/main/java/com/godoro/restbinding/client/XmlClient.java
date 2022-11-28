package com.godoro.restbinding.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlClient {
public static void main(String[] args) {
		
		Client clientXml = ClientBuilder.newClient();
		
		WebTarget target = clientXml
				.target("http://localhost:8089/restbinding/rest")
				.path("Xml")
				.path("binding");
		
		String plain=target.request("application/xml; charset=UTF-8")
				.get(String.class);
		System.out.println("Düz:\n"+plain);
		
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
			
}
}
