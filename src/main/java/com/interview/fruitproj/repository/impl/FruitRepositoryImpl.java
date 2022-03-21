package com.interview.fruitproj.repository.impl;

import com.interview.fruitproj.model.FruitBasket;
import com.interview.fruitproj.repository.FruitRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FruitRepositoryImpl implements FruitRepository {


    private static List<FruitBasket> fruits = new ArrayList<>();

    static {
        fruits = Arrays.asList(
                new FruitBasket("apple", 10, new BigDecimal("9.99")),
                new FruitBasket("banana", 20, new BigDecimal("19.99")),
                new FruitBasket("orange", 10, new BigDecimal("29.99")),
                new FruitBasket("watermelon", 10, new BigDecimal("29.99")),
                new FruitBasket("papaya", 20, new BigDecimal("9.99")),
                new FruitBasket("apple", 10, new BigDecimal("9.99")),
                new FruitBasket("banana", 10, new BigDecimal("19.99")),
                new FruitBasket("apple", 20, new BigDecimal("9.99"))
        );
    }

    @Override
    public List<FruitBasket> getAllFruits() {
        return fruits;
    }

    @Override
    public List<FruitBasket> getFruitsByName(String name) {
        return fruits.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toList());
    }
}
