package com.jwt.authentication.service;

import java.util.List;

import com.jwt.authentication.dto.WinnerDetailRequest;
import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.Winner;

public interface WinnerService {
	public Winner getWinner(Long productId);
	
	  public List<Winner> getAllWinnerDetail(); 
	  public Winner addWinner(WinnerDetailRequest winnerDetailRequest);
	 
}
