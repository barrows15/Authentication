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

import com.jwt.authentication.dto.ProductRequest;
import com.jwt.authentication.model.ImageModel;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping(value = { "/product/add" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Product> addProduct(

			@RequestPart("product") ProductRequest addProductRequest, @RequestPart("ImageFile") MultipartFile[] file

	) {
		try {
			Set<ImageModel> images = uploadImage(file);
			addProductRequest.setProductImages(images);
			return ResponseEntity.ok(productService.addProduct(addProductRequest));
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;
		}

	}

	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();

		for (MultipartFile file : multipartFiles) {
			ImageModel imageModel = new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			imageModels.add(imageModel);
		}
		return imageModels;
	}

	@GetMapping("/product/getAll")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			return ResponseEntity.ok(productService.getAllProducts());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@DeleteMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/product/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(productService.getProductById(id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}
