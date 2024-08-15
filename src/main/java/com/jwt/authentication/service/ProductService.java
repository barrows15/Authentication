package com.jwt.authentication.service;

import java.util.List;

import com.jwt.authentication.dto.ProductRequest;
import com.jwt.authentication.model.Product;

public interface ProductService {

	public Product addProduct(ProductRequest addProductRequest);
	public List<Product> getAllProducts();
	public void deleteProduct(Long id);
	public Product getProductById(Long id);
}
