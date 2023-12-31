package com.discount.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.discount.model.DiscountEntity;
import com.discount.repos.DiscountRepo;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	DiscountRepo discountRepo;
	@Override
	public ResponseEntity getDiscountPrice(DiscountEntity entity) {
		// TODO Auto-generated method stub
		return ResponseEntity.accepted().body(discountRepo.save(entity));
	}

}
