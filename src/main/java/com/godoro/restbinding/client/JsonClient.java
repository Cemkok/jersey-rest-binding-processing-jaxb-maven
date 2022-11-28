package com.godoro.restbinding.client;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class JsonClient {
	
	public static void main(String[] args) {
		
//		Client clientXml = ClientBuilder.newClient();
//		
//		WebTarget target = clientXml
//				.target("http://localhost:8089/restbinding/rest")
//				.path("Xml")
//				.path("binding");
//		
//		String plain=target.request("application/xml; charset=UTF-8")
//				.get(String.class);
//		System.out.println("Düz:\n"+plain);
			
		
		/**
		 * Aşağıdaki işlemler bir Client oluşuturup, path verip , 
		 * çekeceği veri tipini tanımlayıp, 
		 * String'e çevirip, çıktıyı console' a yazdırır.
		 */
		Client clientJson = ClientBuilder.newClient();
			WebTarget target = clientJson
				.target("http://localhost:8089/restbinding/rest")
				.path("json")
				.path("binding");
		
			String plain=target.request("application/json; charset=UTF-8")
				.get(String.class);
			System.out.println("Düz:\n"+plain);
			
			
/**
 * Aşağıdaki işlmeler String bir veriyi Json olarak okumak için yapılıyor.
 */
			StringReader stringReader= new StringReader(plain);
			JsonReader jsonReader=Json.createReader(stringReader);
			JsonObject jsonObject=jsonReader.readObject();
			//jsonReader bir stream olduğu için close() methodu ile kapatmak gerekiyor.
			jsonReader.close();
			
			long productId = jsonObject.getJsonNumber("productId").longValue();
			String productName = jsonObject.getString("productName");
			double salesPrice = jsonObject.getJsonNumber("salesPrice").doubleValue();
			
			System.out.println("Ürün: "+productId+" "+productName+" "+salesPrice);
			
			
			
			
			
			
		
		
		
	}
	

}
