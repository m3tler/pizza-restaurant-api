package com.example.pizzarestaurantapi.pizza;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pizzas")
public class PizzaController {
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas() {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        Pizza pizza = pizzaService.getPizzaById(id);
        return ResponseEntity.ok(pizza);
    }

    @PostMapping
    public ResponseEntity<Pizza> savePizza(@RequestBody Pizza pizza) {
        Pizza savedPizza = pizzaService.savePizza(pizza);
        return ResponseEntity.ok(savedPizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza updatedPizza) {
        Pizza pizza = pizzaService.updatePizza(id, updatedPizza);
        return ResponseEntity.ok(pizza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizzaById(@PathVariable Long id) {
        pizzaService.deletePizzaById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
