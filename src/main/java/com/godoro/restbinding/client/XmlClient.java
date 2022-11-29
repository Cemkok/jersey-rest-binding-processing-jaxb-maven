package com.godoro.restbinding.client;

import java.io.ByteArrayInputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.godoro.restbinding.document.Product;

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
			ByteArrayInputStream inputStream= new ByteArrayInputStream(plain.getBytes());
			Document document = documentBuilder.parse(inputStream);
			inputStream.close();
			
			Element product=document.getDocumentElement();
//			long productId=Long.parseLong(product.getAttribute("productId"));
//			System.out.println("productId :" + productId);
			long productId = Long.parseLong(
					product.getChildNodes().item(0).getTextContent());
			String productName = product.getChildNodes().item(1).getTextContent();
			double salesPrice =Double.parseDouble(
					product.getChildNodes().item(2).getTextContent());
			
			System.out.println("Ürün" +  productId+" " + productName + " "+ salesPrice);
			
			
	
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Object alma
		Product product=target.request("application/xml; charset=UTF-8")
				.get(Product.class);
		System.out.println("Ürün" +  product.getProductId()+" " + product.getProductName() + " "
				+ product.getSalesPrice());
		
			
		
		
			
}
}
