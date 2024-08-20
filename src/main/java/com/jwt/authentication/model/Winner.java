package com.jwt.authentication.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Winner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Double winningPrice;
	private String bidStatus;
	private Date winningDate; 
	@ManyToOne 
	private Product product;
	@ManyToOne 
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getWinningPrice() {
		return winningPrice;
	}
	public void setWinningPrice(Double winningPrice) {
		this.winningPrice = winningPrice;
	}
	public Date getWinningDate() {
		return winningDate;
	}
	public void setWinningDate(Date winningDate) {
		this.winningDate = winningDate;
	}
}
