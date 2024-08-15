package com.jwt.authentication.respository;

import org.springframework.stereotype.Repository;

import com.jwt.authentication.model.BidDetail;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BidDetailRepository extends JpaRepository<BidDetail, Long>{

}
