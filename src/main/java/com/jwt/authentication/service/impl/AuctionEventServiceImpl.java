package com.jwt.authentication.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.authentication.dto.AddAuctionEventRequest;
import com.jwt.authentication.dto.ProductRequest;
import com.jwt.authentication.model.AuctionEvent;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.respository.AuctionEventRepository;
import com.jwt.authentication.respository.ProductRepository;
import com.jwt.authentication.service.AuctionEventService;
import com.jwt.authentication.service.ProductService;

@Service
public class AuctionEventServiceImpl implements AuctionEventService{

	@Autowired
	AuctionEventRepository auctionEventRepository;
	

	public AuctionEvent addAuctionEvent(AddAuctionEventRequest addAuctionEventRequest) {
		AuctionEvent auctionEvent = new AuctionEvent();
		auctionEvent.setName(addAuctionEventRequest.getName());
		auctionEvent.setStartdate(addAuctionEventRequest.getStartdate());
		auctionEvent.setEnddate(addAuctionEventRequest.getEnddate());
		auctionEvent.setEventflag(addAuctionEventRequest.getEventflag());
		auctionEvent.setEventImage(addAuctionEventRequest.getEventImage());
		
		auctionEventRepository.save(auctionEvent);
		return auctionEvent;
	}
}
