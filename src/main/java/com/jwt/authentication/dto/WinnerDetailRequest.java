package com.jwt.authentication.dto;

import java.util.Date;

public class WinnerDetailRequest {
	
	private Long productId;
	private Date winnerDate;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Date getWinnerDate() {
		return winnerDate;
	}
	public void setWinnerDate(Date winnerDate) {
		this.winnerDate = winnerDate;
	}
	public WinnerDetailRequest(Long productId, Date winnerDate) {
		super();
		this.productId = productId;
		this.winnerDate = winnerDate;
	}
	@Override
	public String toString() {
		return "WinnerDetailRequest [productId=" + productId + ", winnerDate=" + winnerDate + "]";
	}
	
}
