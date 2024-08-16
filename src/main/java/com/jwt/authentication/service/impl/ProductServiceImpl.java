package com.jwt.authentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.authentication.dto.ProductRequest;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.respository.ProductRepository;
import com.jwt.authentication.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(ProductRequest addProductRequest) {
		Product product = new Product();
		product.setName(addProductRequest.getName());
		product.setProdDesc(addProductRequest.getProdDesc());
		product.setPrice(addProductRequest.getPrice());
		product.setDiscountPrice(addProductRequest.getDiscountPrice());
		product.setExpiryDate(addProductRequest.getExpiryDate());
		product.setProductImages(addProductRequest.getProductImages());
		productRepository.save(product);
		return product;
	}
	
	public List<Product> getAllProducts() {
		return (List<Product>)productRepository.findAll();
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
}
