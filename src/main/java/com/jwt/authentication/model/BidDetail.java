package com.jwt.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class BidDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Double bidPrice;
	private String bidStatus;
	@ManyToOne 
	private Product product;
	@ManyToOne 
	private User user;
	
	public BidDetail() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	public BidDetail(Double bidPrice, String bidStatus, Product product, User user) {
		super();
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.product = product;
		this.user = user;
	}
	public BidDetail(Long id, Double bidPrice, String bidStatus, Product product, User user) {
		super();
		this.id = id;
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.product = product;
		this.user = user;
	}  
	
}
