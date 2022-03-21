package com.interview.fruitproj.service.impl;

import com.interview.fruitproj.exceptions.FruitTypeNotFoundException;
import com.interview.fruitproj.model.FruitBasket;
import com.interview.fruitproj.repository.FruitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FruitServiceImplTest {

    @Mock
    private FruitRepository fruitRepository;
    @InjectMocks
    private FruitServiceImpl fruitServiceImpl;

    @BeforeEach
    void setUp() {
        fruits = Arrays.asList(
                new FruitBasket("apple", 10, new BigDecimal("9.99")),
                new FruitBasket("apple", 15, new BigDecimal("8.99")),
                new FruitBasket("banana", 20, new BigDecimal("19.99")),
                new FruitBasket("orange", 10, new BigDecimal("29.99")));
    }

    private List<FruitBasket> fruits;

    @Test
    void calcSumByFruitName() {

        final String fruitName = "apple";
        BigDecimal sum = fruits.stream()
                .filter(x -> x.getName().equals(fruitName))
                .map(fruit->fruit.getPrice().multiply(new BigDecimal(fruit.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        when(fruitRepository.getFruitsByName(fruitName)).thenReturn(fruits.stream().
                filter(x->x.getName().equals(fruitName))
                .collect(Collectors.toList()));

        assertEquals(sum,fruitServiceImpl.calcSumByFruitName(fruitName));

    }

    @Test
    void throwFruitTypeNotFoundExceptionWhenFruitTypeNotFound() {

        FruitTypeNotFoundException exception = assertThrows(FruitTypeNotFoundException.class, () -> {
            fruitServiceImpl.calcSumByFruitName("fruit");
        });
        assertEquals("Fruit not found", exception.getMessage());
    }

    @Test
    void getAllFruits() {
        when(fruitRepository.getAllFruits()).thenReturn(fruits);
        assertEquals(fruits,fruitServiceImpl.getAllFruits());
    }

    @Test
    void calcSumNullCheck() {

        final String fruitName = null;
        BigDecimal sum = fruits.stream()
                .filter(x -> x.getName().equals(fruitName))
                .map(fruit->fruit.getPrice().multiply(new BigDecimal(fruit.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        when(fruitRepository.getFruitsByName(fruitName)).thenReturn(fruits.stream().
                filter(x->x.getName().equals(fruitName))
                .collect(Collectors.toList()));

        assertEquals(sum,fruitServiceImpl.calcSumByFruitName(fruitName));

    }
}