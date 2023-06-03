package com.example.pizzarestaurantapi.pizza;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Long id, Pizza updatedPizza) {
        pizzaRepository.getReferenceById(id);
        updatedPizza.setId(id);
        return pizzaRepository.save(updatedPizza);
    }

    public void deletePizzaById(Long id) {
        pizzaRepository.getReferenceById(id);
        pizzaRepository.deleteById(id);
    }
}
