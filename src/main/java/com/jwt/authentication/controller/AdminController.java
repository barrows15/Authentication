package com.jwt.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.dto.Message;
import com.jwt.authentication.dto.AddAuctionEventRequest;
import com.jwt.authentication.dto.ProductRequest;
import com.jwt.authentication.model.AuctionEvent;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.service.AuctionEventService;
import com.jwt.authentication.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	AuctionEventService auctionEventService;
	
	
	@GetMapping
	public ResponseEntity<Message> sayHello(){
		Message message = new Message();
		message.setId("admin1");
		message.setMessage("Hi Admin");
		System.out.println(message);
		return ResponseEntity.ok(message);
	}
	
	
	@PostMapping("/addauctionevent")
	public ResponseEntity<AuctionEvent> addAuctionEvent(@RequestBody AddAuctionEventRequest addAuctionEventRequest ){	
		return ResponseEntity.ok(auctionEventService.addAuctionEvent(addAuctionEventRequest));
		
	}
	
}
