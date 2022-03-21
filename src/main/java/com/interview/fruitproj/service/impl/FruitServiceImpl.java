package com.interview.fruitproj.service.impl;

import com.interview.fruitproj.exceptions.FruitTypeNotFoundException;
import com.interview.fruitproj.model.FruitBasket;
import com.interview.fruitproj.repository.FruitRepository;
import com.interview.fruitproj.service.FruitService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {


    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public BigDecimal calcSumByFruitName(String name) {

        if (fruitRepository.getFruitsByName(name).isEmpty()) {
            throw new FruitTypeNotFoundException("Fruit not found");
        }

        return fruitRepository.getFruitsByName(name).stream()
                .map(fruit->fruit.getPrice().multiply(new BigDecimal(fruit.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<FruitBasket> getAllFruits() {
        return fruitRepository.getAllFruits();
    }
}
