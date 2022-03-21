package com.interview.fruitproj.repository;

import com.interview.fruitproj.model.FruitBasket;

import java.math.BigDecimal;
import java.util.List;

public interface FruitRepository {

    public List<FruitBasket> getAllFruits();
    public List<FruitBasket> getFruitsByName(String name);
}
