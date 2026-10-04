package mx.unam.aragon.tsp.vjimenez.pizzas.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Pizza;

@Service
public class ServicioPizza {

    private final List<Pizza> pizzas = new ArrayList<>();

    private int siguienteId = 1;

    // CREATE
    public Pizza agregarPizza(Pizza pizza) {

        pizza.setId(siguienteId++);

        pizzas.add(pizza);

        return pizza;
    }

    // READ - obtener todas las pizzas
    public List<Pizza> obtenerTodas() {

        return pizzas;
    }

    // READ - obtener una pizza por ID
    public Pizza obtenerPorId(int id) {

        for (Pizza pizza : pizzas) {

            if (pizza.getId() == id) {
                return pizza;
            }
        }

        return null;
    }

    // UPDATE
    public Pizza actualizarPizza(int id, Pizza datos) {

        Pizza pizza = obtenerPorId(id);

        if (pizza == null) {
            return null;
        }

        pizza.setNombre(datos.getNombre());
        pizza.setIngredientes(datos.getIngredientes());

        return pizza;
    }

    // DELETE
    public boolean eliminarPizza(int id) {

        Pizza pizza = obtenerPorId(id);

        if (pizza == null) {
            return false;
        }

        pizzas.remove(pizza);

        return true;
    }
}