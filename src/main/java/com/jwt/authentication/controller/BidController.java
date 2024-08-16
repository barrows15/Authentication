package com.jwt.authentication.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jwt.authentication.dto.BidDetailRequest;
import com.jwt.authentication.dto.ProductRequest;
import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.ImageModel;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.service.BidDetailService;
import com.jwt.authentication.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BidController {

	@Autowired
	BidDetailService bidDetailService;

	@PostMapping(value = {"/bid/add" })
	public ResponseEntity<BidDetail> addBidDetail(
		@RequestBody BidDetailRequest addBidDetailRequest) {
	return ResponseEntity.ok(bidDetailService.addBidDetail(addBidDetailRequest));
	}

	@GetMapping("/bid/getAll")
	public ResponseEntity<List<BidDetail>> getAllBids() {
		try {
			return ResponseEntity.ok(bidDetailService.getAllBidDetail());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	@GetMapping("/bid/getByProduct/{productId}")
	public ResponseEntity<List<BidDetail>> getByProduct(@PathVariable("productId") Long productId) {
		try {
			return ResponseEntity.ok(bidDetailService.getByProduct(productId));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
