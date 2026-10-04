package mx.unam.aragon.tsp.vjimenez.pizzas.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Cliente;

@Service
public class ServicioCliente {

    private final List<Cliente> clientes = new ArrayList<>();

    private int siguienteId = 1;

    // CREATE
    public Cliente agregarCliente(Cliente cliente) {

        cliente.setId(siguienteId++);

        clientes.add(cliente);

        return cliente;
    }

    // READ - obtener todos
    public List<Cliente> obtenerTodos() {

        return clientes;
    }

    // READ - obtener por ID
    public Cliente obtenerPorId(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    // UPDATE
    public Cliente actualizarCliente(int id, Cliente datos) {

        Cliente cliente = obtenerPorId(id);

        if (cliente == null) {
            return null;
        }

        cliente.setNombre(datos.getNombre());
        cliente.setTelefono(datos.getTelefono());
        cliente.setEmail(datos.getEmail());

        return cliente;
    }

    // DELETE
    public boolean eliminarCliente(int id) {

        Cliente cliente = obtenerPorId(id);

        if (cliente == null) {
            return false;
        }

        clientes.remove(cliente);

        return true;
    }
}