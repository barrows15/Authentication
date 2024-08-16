package com.jwt.authentication.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.authentication.config.JwtAuthenticationFilter;
import com.jwt.authentication.dto.BidDetailRequest;
import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.model.User;
import com.jwt.authentication.respository.BidDetailRepository;
import com.jwt.authentication.respository.ProductRepository;
import com.jwt.authentication.respository.UserRepository;
import com.jwt.authentication.service.BidDetailService;

@Service
public class BidDetailServiceImpl implements BidDetailService{

	@Autowired
	BidDetailRepository bidDetailRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public BidDetail addBidDetail(BidDetailRequest addBidDetailRequest) {
		BidDetail bidDetail = new BidDetail();
		bidDetail.setBidPrice(addBidDetailRequest.getBidPrice());
		bidDetail.setBidStatus(addBidDetailRequest.getBidStatus());
		Product product = productRepository.
				findById(addBidDetailRequest.getProductId()).get();
		bidDetail.setProduct(product);
		String username = JwtAuthenticationFilter.CURRENT_USER;
		System.out.println("CURRENT_USER:"+username);
		User user = userRepository.findByEmail(username).get();
		bidDetail.setUser(user);
		bidDetailRepository.save(bidDetail);
		return bidDetail;
	}
	
	public List<BidDetail> getAllBidDetail() {
		return (List<BidDetail>) bidDetailRepository.findAll();
	}
	
	public List<BidDetail> getByProduct(Long producId){
				Product product = new Product();
				product = productRepository.findById(producId).get();
				
				List<BidDetail> list = new ArrayList<BidDetail>();
//				
//	ArrayList<StudentInformation> infos = new ArrayList<StudentInformation>();
//	// fill array
//	Collections.sort(infos, 
//		Comparator.comparingInt(StudentInformation::getBirthYear).reversed());
//				
				
		list = (List<BidDetail>) bidDetailRepository.findByProduct(product);
			
		Collections.sort(list, 
			Comparator.comparingDouble(BidDetail::getBidPrice).reversed());
				
		return list;
	};
	
}
