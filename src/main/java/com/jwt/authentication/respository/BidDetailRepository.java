package com.jwt.authentication.respository;

import org.springframework.stereotype.Repository;

import com.jwt.authentication.model.BidDetail;
import com.jwt.authentication.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BidDetailRepository extends JpaRepository<BidDetail, Long>{

	List<BidDetail> findByProduct(Product product);

}
