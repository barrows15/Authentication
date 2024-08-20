package com.jwt.authentication.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.Product;
import com.jwt.authentication.model.Winner;
@Repository
public interface WinnerRepository extends JpaRepository<Winner, Long>{
	Winner findByProduct(Product product);
}
