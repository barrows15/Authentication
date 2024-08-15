package com.jwt.authentication.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String prodDesc;
	private Double price;
	private Double discountPrice;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinTable(name="product_images",
		joinColumns=@jakarta.persistence.JoinColumn(name="prod_id", referencedColumnName="id"),
		inverseJoinColumns=@jakarta.persistence.JoinColumn(name="image_id",referencedColumnName="id")
	)
	private Set<ImageModel> productImages;
	
	public Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
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

	public Product(String name, String prodDesc, Double price, Double discountPrice, Set<ImageModel> productImages) {
		this.name = name;
		this.prodDesc = prodDesc;
		this.price = price;
		this.discountPrice = discountPrice;
		this.productImages = productImages;
	}

	
	
	
}
