package com.jwt.authentication.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.authentication.config.JwtAuthenticationFilter;
import com.jwt.authentication.dto.BidDetailRequest;
import com.jwt.authentication.dto.WinnerDetailRequest;
import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.model.User;
import com.jwt.authentication.model.Winner;
import com.jwt.authentication.respository.BidDetailRepository;
import com.jwt.authentication.respository.ProductRepository;
import com.jwt.authentication.respository.UserRepository;
import com.jwt.authentication.respository.WinnerRepository;
import com.jwt.authentication.service.BidDetailService;
import com.jwt.authentication.service.WinnerService;

@Service
public class WinnerServiceImpl implements WinnerService {

	@Autowired
	BidDetailRepository bidDetailRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	WinnerRepository winnerRepository;
	
	@Autowired
	BidDetailService bidDetailService;

	public Winner addWinner(WinnerDetailRequest winnerDetailRequest) {
		Winner winner = new Winner();

		Product product = productRepository.findById(winnerDetailRequest.getProductId()).get();
		winner.setProduct(product);
		List<BidDetail> bList = bidDetailService.getByProduct(winnerDetailRequest.getProductId());
		BidDetail maxBidDetail = bList.getFirst();
		String username = maxBidDetail.getUser().getUsername();
		System.out.println("WINNING_USER:" + username);
		User user = userRepository.findByEmail(username).get();
		winner.setUser(user);
		winner.setWinningDate(product.getExpiryDate());
		winner.setWinningPrice(maxBidDetail.getBidPrice());
		winner.setBidStatus(maxBidDetail.getBidStatus());
		winnerRepository.save(winner);
		return winner;
	}

	
	public List<Winner> getAllWinnerDetail() {
		return (List<Winner>) winnerRepository.findAll();
	}
	 

	@Override
	public Winner getWinner(Long productId) {
		Winner winner = new Winner();
		Product product = new Product();
		product = productRepository.findById(productId).get();
		winner = winnerRepository.findByProduct(product);
		return winner;
	};

}
