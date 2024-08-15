package com.jwt.authentication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jwt.authentication.dto.BidDetailRequest;
import com.jwt.authentication.model.BidDetail;

public interface BidDetailService {

	public BidDetail addBidDetail(BidDetailRequest addBidDetailRequest);
	public List<BidDetail> getAllBidDetail();
	
}
