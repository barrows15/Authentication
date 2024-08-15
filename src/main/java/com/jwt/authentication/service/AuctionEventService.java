package com.jwt.authentication.service;

import com.jwt.authentication.dto.AddAuctionEventRequest;
import com.jwt.authentication.model.AuctionEvent;

public interface AuctionEventService {

	public AuctionEvent addAuctionEvent(AddAuctionEventRequest addAuctionEventRequest);
}
