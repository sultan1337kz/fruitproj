package com.interview.fruitproj.service;

import com.interview.fruitproj.model.FruitBasket;

import java.math.BigDecimal;
import java.util.List;

public interface FruitService {

    public BigDecimal calcSumByFruitName(String name);
    public List<FruitBasket> getAllFruits();
}
