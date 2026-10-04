package mx.unam.aragon.tsp.vjimenez.pizzas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Pizza;
import mx.unam.aragon.tsp.vjimenez.pizzas.servicios.ServicioPizza;

@RestController
@RequestMapping("/api/v1/pizzas")
public class PizzaController {

    private final ServicioPizza servicioPizza;

    public PizzaController(ServicioPizza servicioPizza) {
        this.servicioPizza = servicioPizza;
    }

    // GET - Obtener todas las pizzas
    @GetMapping
    public List<Pizza> obtenerTodas() {
        return servicioPizza.obtenerTodas();
    }

    // GET - Obtener una pizza por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> obtenerPorId(
            @PathVariable("id") int id) {

        Pizza pizza = servicioPizza.obtenerPorId(id);

        if (pizza == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pizza);
    }

    // POST - Crear una pizza
    @PostMapping
    public ResponseEntity<Pizza> agregarPizza(
            @RequestBody Pizza pizza) {

        Pizza nuevaPizza = servicioPizza.agregarPizza(pizza);

        return ResponseEntity.status(201).body(nuevaPizza);
    }

    // PUT - Actualizar una pizza
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> actualizarPizza(
            @PathVariable("id") int id,
            @RequestBody Pizza pizza) {

        Pizza pizzaActualizada = servicioPizza.actualizarPizza(id, pizza);

        if (pizzaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pizzaActualizada);
    }

    // DELETE - Eliminar una pizza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPizza(
            @PathVariable("id") int id) {

        boolean eliminado = servicioPizza.eliminarPizza(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}