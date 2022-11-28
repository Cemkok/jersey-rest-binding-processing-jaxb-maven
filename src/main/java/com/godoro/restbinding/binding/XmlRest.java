package com.godoro.restbinding.binding;

import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.glassfish.jersey.jaxb.internal.DocumentBuilderFactoryInjectionProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Path("/Xml")
public class XmlRest {
	
	
	@GET
	@Path("processing")
	@Produces("application/xml; charset=UTF-8")
	public String getPlain() {
		try {
		
		/**
		 * Aşağıdaki işlem bir DocumentBuilderFactory > DocumentBuilder > Document > Element
		 * Element  (üretebilmek için gerekli işlemler)
		 */
		
		DocumentBuilderFactory builderFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		Document document = builder.newDocument();
		Element product = document.createElement("product");
		document.appendChild(product);
		product.setAttribute("productId", Long.toString(401L));
		
		Element productName=document.createElement("productName");
		// < ...>"setTextContent" <.... >
		productName.setTextContent("Cep Telefonu");
		product.appendChild(productName);
		
		Element salesPrice = document.createElement("salesPrice");
		salesPrice.setTextContent(Double.toString(1300.0));
		product.appendChild(salesPrice);
		
		/**
		 * Aşağıdaki işlem bir document tipi bir StringWriter tip'e atarak, String'e çevirir.
		 */
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer =transformerFactory.newTransformer();
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(document), new StreamResult(writer));
		return writer.toString();
		
		} catch (Exception e) {
			e.printStackTrace();
			
		return "";
		}	
		}
	@GET
	@Path("binding")
	@Produces("application/xml; charset=UTF-8")
	//JsonB (binding) kullanıyoruz
	public Product getBinding() {
		
		Product product = new Product();
		product.setProductId(401L);
		product.setProductName("Cep telefonu");
		product.setSalesPrice(1457.0);
		
		
		return product;}
				
				
}





















