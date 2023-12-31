package com.discount.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.discount.model.DiscountEntity;

@Repository
public interface DiscountRepo extends JpaRepository<DiscountEntity,  Integer> {

}
