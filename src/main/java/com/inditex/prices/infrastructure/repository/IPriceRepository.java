package com.inditex.prices.infrastructure.repository;

import com.inditex.prices.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPriceRepository extends JpaRepository<Price, Integer> {
}