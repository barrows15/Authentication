package com.jwt.authentication.respository;

import org.springframework.stereotype.Repository;

import com.jwt.authentication.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
