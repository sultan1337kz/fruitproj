package com.interview.fruitproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FruitBasket {

	private String name;
	private long quantity;
	private BigDecimal price;

}











