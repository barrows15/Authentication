package com.jwt.authentication.dto;

import java.util.Date;
import java.util.Set;

import com.jwt.authentication.model.ImageModel;

public class ProductRequest {
	
	private String name;
	private String prodDesc;
	private Double price;
	private Double discountPrice;
	private Date expiryDate;
	private Set<ImageModel> productImages;
	
	public ProductRequest() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Set<ImageModel> getProductImages() {
		return productImages;
	}
	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public ProductRequest(String name, String prodDesc, Double price, Double discountPrice, Date expiryDate,
			Set<ImageModel> productImages) {
		super();
		this.name = name;
		this.prodDesc = prodDesc;
		this.price = price;
		this.discountPrice = discountPrice;
		this.expiryDate = expiryDate;
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", prodDesc=" + prodDesc + ", price=" + price + ", discountPrice="
				+ discountPrice + ", expiryDate=" + expiryDate + ", productImages=" + productImages + "]";
	}

	
	
	
	
}
