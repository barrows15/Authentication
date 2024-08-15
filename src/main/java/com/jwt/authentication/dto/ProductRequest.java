package com.jwt.authentication.dto;

import java.util.Set;

import com.jwt.authentication.model.ImageModel;

public class ProductRequest {
	
	private String name;
	private String prodDesc;
	private Double price;
	private Double discountPrice;
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

	public ProductRequest(String name, String prodDesc, Double price, Double discountPrice,
			Set<ImageModel> productImages) {
		this.name = name;
		this.prodDesc = prodDesc;
		this.price = price;
		this.discountPrice = discountPrice;
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", prodDesc=" + prodDesc + ", price=" + price + ", discountPrice="
				+ discountPrice + ", productImages=" + productImages + "]";
	}
	
	
	
}
