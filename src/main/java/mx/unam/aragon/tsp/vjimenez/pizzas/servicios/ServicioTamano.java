package mx.unam.aragon.tsp.vjimenez.pizzas.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Tamano;

@Service
public class ServicioTamano {

    private final List<Tamano> tamanos = new ArrayList<>();

    private int siguienteId = 1;

    // CREATE
    public Tamano agregarTamano(Tamano tamano) {

        tamano.setId(siguienteId++);

        tamanos.add(tamano);

        return tamano;
    }

    // READ - obtener todos
    public List<Tamano> obtenerTodos() {

        return tamanos;
    }

    // READ - obtener por ID
    public Tamano obtenerPorId(int id) {

        for (Tamano tamano : tamanos) {

            if (tamano.getId() == id) {
                return tamano;
            }
        }

        return null;
    }

    // UPDATE
    public Tamano actualizarTamano(int id, Tamano datos) {

        Tamano tamano = obtenerPorId(id);

        if (tamano == null) {
            return null;
        }

        tamano.setNombre(datos.getNombre());
        tamano.setPrecio(datos.getPrecio());

        return tamano;
    }

    // DELETE
    public boolean eliminarTamano(int id) {

        Tamano tamano = obtenerPorId(id);

        if (tamano == null) {
            return false;
        }

        tamanos.remove(tamano);

        return true;
    }
}