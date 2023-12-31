package com.discount.services;

import org.springframework.http.ResponseEntity;

import com.discount.model.DiscountEntity;

public interface DiscountService {

	public ResponseEntity getDiscountPrice(DiscountEntity entity);
}
