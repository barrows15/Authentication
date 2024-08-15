package com.jwt.authentication.respository;

import org.springframework.stereotype.Repository;

import com.jwt.authentication.model.AuctionEvent;


import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AuctionEventRepository extends JpaRepository<AuctionEvent, Long>{

}
