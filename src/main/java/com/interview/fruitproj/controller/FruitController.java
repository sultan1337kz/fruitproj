package com.interview.fruitproj.controller;

import com.interview.fruitproj.model.FruitBasket;
import com.interview.fruitproj.service.FruitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {

	private final FruitService fruitService;

	public FruitController(FruitService fruitService) {
		this.fruitService = fruitService;
	}

	@GetMapping("/allFruits")
	public List<FruitBasket> findAll() {
		return fruitService.getAllFruits();
	}

	@GetMapping("/calcSumByFruitName/{fruitName}")
	public BigDecimal findAll(@PathVariable String fruitName) {
		return fruitService.calcSumByFruitName(fruitName);
	}

}










