package com.jwt.authentication.dto;

import java.util.Set;

import com.jwt.authentication.model.ImageModel;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.model.User;

public class BidDetailRequest {
	
	private Long productId;
	private Double bidPrice;
	private String bidStatus;
	
	public BidDetailRequest() {
	}

	public Double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BidDetailRequest(Double bidPrice, String bidStatus, 
			Long productId) {
		super();
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.productId = productId;
		
	}

	@Override
	public String toString() {
		return "BidDetailRequest [bidPrice=" + bidPrice + ", bidStatus=" + bidStatus + ", productId=" + productId
				+ "]";
	}

	
}
