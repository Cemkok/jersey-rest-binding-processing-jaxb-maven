package com.godoro.restbinding.document;

import javax.xml.bind.annotation.XmlRootElement;

//Plain old Java Object = POJO
@XmlRootElement
public class Product {
	
	private long productId;
	private String productName;
	private double salesPrice;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", salesPrice=" + salesPrice + "]";
	}
	

}
