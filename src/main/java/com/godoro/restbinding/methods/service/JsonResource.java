package com.godoro.restbinding.methods.service;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.godoro.restbinding.document.Product;
import com.godoro.restbinding.document.Result;

@Path("/method")
public class JsonResource {
	
	@POST
	@Path("plain")
	@Consumes("application/json; charset=UTF-8")
	public void setPlain(String plain) {
		System.out.println("Düz: "+ plain);
		/**
		 * String olarak alınan nesneyi Json Objesine çeviriyor
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
		@POST
		@Path("binding")
		@Consumes("application/json; charset=UTF-8")
		public void setBinding(Product product) {
			System.out.println("Ürün Nesnesi : " + product.getProductId() +" "
					+product.getProductName()+ " "
					+product.getSalesPrice());
			
		}
		@POST
		@Path("trade")
		@Consumes("application/json; charset=UTF-8")
		@Produces("application/json; charset=UTF-8")
		public Result tradeBinding(Product product) {
			System.out.println("Ürün Nesnesi : " + product.getProductId() +" "
					+product.getProductName()+ " "
					+product.getSalesPrice());
			
			Result result = new Result();
			//Genellikle "0" hata olmadı demektir.
			result.setResultCode("0");
			result.setResultMessage(product.getProductName()+ "eklendi");
			return result;
			
			
			
			
		}
	
	

		
	}
	
	

