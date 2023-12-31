package com.discount.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.model.BookInfo;
import com.discount.model.DiscountEntity;
import com.discount.services.BookServiceClient;
import com.discount.services.DiscountService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/discount_service")
public class DiscountContoller {

	@Autowired
	BookServiceClient bookclient;

	@Autowired
	DiscountService service;

	@PostMapping("/discount_price")
	public ResponseEntity getDiscount(@RequestBody DiscountEntity discountEntity) {

		List<BookInfo> list = bookclient.getAllBooks().block();

		
		  BookInfo i= list.stream(). filter(item->item.title().
		  equalsIgnoreCase(discountEntity.getItem_name()))
		  .findFirst().orElseThrow(()->new RuntimeException("Item not found"));
		 
		discountEntity.setOriginal_price(i.price());

		double dis = i.price() - (i.price() / 10);

		discountEntity.setDiscnt_price(dis);

		return service.getDiscountPrice(discountEntity);

	}

}
