package com.jwt.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.authentication.dto.BidDetailRequest;
import com.jwt.authentication.dto.WinnerDetailRequest;
import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.Winner;
import com.jwt.authentication.service.BidDetailService;
import com.jwt.authentication.service.WinnerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WinnerController {
	@Autowired
	WinnerService winnerService;
	
	@PostMapping(value = {"/winner/add" })
	public ResponseEntity<Winner> addWinner(
		@RequestBody WinnerDetailRequest addWinnerDetailRequest) {
	return ResponseEntity.ok(winnerService.addWinner(addWinnerDetailRequest));
	}
	
	@GetMapping("/bid/getWinner/{productId}")
	public ResponseEntity<Winner> getWinner(
			@PathVariable("productId") Long productId) {
		try {
			return ResponseEntity.ok(winnerService.getWinner(productId));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@GetMapping("/bid/getAllWinner")
	public ResponseEntity<List<Winner>> getAllWinner() {
		try {
			return ResponseEntity.ok(winnerService.getAllWinnerDetail());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
