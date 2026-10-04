package mx.unam.aragon.tsp.vjimenez.pizzas.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Bebida;

@Service
public class ServicioBebida {

    private final List<Bebida> bebidas = new ArrayList<>();

    private int siguienteId = 1;

    // CREATE
    public Bebida agregarBebida(Bebida bebida) {

        bebida.setId(siguienteId++);

        bebidas.add(bebida);

        return bebida;
    }

    // READ - obtener todas
    public List<Bebida> obtenerTodas() {

        return bebidas;
    }

    // READ - obtener por ID
    public Bebida obtenerPorId(int id) {

        for (Bebida bebida : bebidas) {

            if (bebida.getId() == id) {
                return bebida;
            }
        }

        return null;
    }

    // UPDATE
    public Bebida actualizarBebida(int id, Bebida datos) {

        Bebida bebida = obtenerPorId(id);

        if (bebida == null) {
            return null;
        }

        bebida.setNombre(datos.getNombre());
        bebida.setPrecio(datos.getPrecio());

        return bebida;
    }

    // DELETE
    public boolean eliminarBebida(int id) {

        Bebida bebida = obtenerPorId(id);

        if (bebida == null) {
            return false;
        }

        bebidas.remove(bebida);

        return true;
    }
}