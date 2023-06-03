package com.example.pizzarestaurantapi.config.conv;

import com.example.pizzarestaurantapi.pizza.Topping;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class ToppingListConverter implements AttributeConverter<List<Topping>, String> {
    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<Topping> toppings) {
        return toppings.stream().map(Enum::name).collect(Collectors.joining(DELIMITER));
    }

    @Override
    public List<Topping> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(DELIMITER)).map(Topping::valueOf).toList();
    }
}
