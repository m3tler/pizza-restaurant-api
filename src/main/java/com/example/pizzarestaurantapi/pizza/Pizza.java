package com.example.pizzarestaurantapi.pizza;

import com.example.pizzarestaurantapi.config.conv.ToppingListConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pizzas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Convert(converter = ToppingListConverter.class)
    @NotEmpty
    @NotNull
    private List<Topping> toppings;
}
