package com.interview.fruitproj.service.impl;

import com.interview.fruitproj.exceptions.FruitTypeNotFoundException;
import com.interview.fruitproj.model.FruitBasket;
import com.interview.fruitproj.repository.FruitRepository;
import com.interview.fruitproj.repository.impl.FruitRepositoryImpl;
import com.interview.fruitproj.service.FruitService;
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
class FruitServiceImplTest2 {

    private FruitRepository fruitRepository = new FruitRepositoryImpl();

    private FruitService fruitService = new FruitServiceImpl(fruitRepository);

    @Test
    void calcSumByFruitName() {

        final String fruitName = "apple";
        BigDecimal sum = fruitRepository.getFruitsByName(fruitName).stream()
                .filter(x -> x.getName().equals(fruitName))
                .map(fruit->fruit.getPrice().multiply(new BigDecimal(fruit.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        assertEquals(sum,fruitService.calcSumByFruitName(fruitName));

    }

    @Test
    void throwFruitTypeNotFoundExceptionWhenFruitTypeNotFound() {

        FruitTypeNotFoundException exception = assertThrows(FruitTypeNotFoundException.class, () -> {
            fruitService.calcSumByFruitName("fruit");
        });
        assertEquals("Fruit not found", exception.getMessage());
    }

    @Test
    void getAllFruits() {
        assertEquals(fruitRepository.getAllFruits().stream().count(),8);
    }
}