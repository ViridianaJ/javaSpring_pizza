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

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Cliente;
import mx.unam.aragon.tsp.vjimenez.pizzas.servicios.ServicioCliente;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ServicioCliente servicioCliente;

    public ClienteController(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    // GET - Obtener todos los clientes
    @GetMapping
    public List<Cliente> obtenerTodos() {
        return servicioCliente.obtenerTodos();
    }

    // GET - Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(
            @PathVariable("id") int id) {

        Cliente cliente = servicioCliente.obtenerPorId(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    // POST - Crear cliente
    @PostMapping
    public ResponseEntity<Cliente> agregarCliente(
            @RequestBody Cliente cliente) {

        Cliente nuevoCliente = servicioCliente.agregarCliente(cliente);

        return ResponseEntity.status(201).body(nuevoCliente);
    }

    // PUT - Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable("id") int id,
            @RequestBody Cliente cliente) {

        Cliente clienteActualizado = servicioCliente.actualizarCliente(id, cliente);

        if (clienteActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteActualizado);
    }

    // DELETE - Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(
            @PathVariable("id") int id) {

        boolean eliminado = servicioCliente.eliminarCliente(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}