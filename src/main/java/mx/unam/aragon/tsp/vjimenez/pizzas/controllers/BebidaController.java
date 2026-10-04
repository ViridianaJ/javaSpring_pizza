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

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Bebida;
import mx.unam.aragon.tsp.vjimenez.pizzas.servicios.ServicioBebida;

@RestController
@RequestMapping("/api/v1/bebidas")
public class BebidaController {

    private final ServicioBebida servicioBebida;

    public BebidaController(ServicioBebida servicioBebida) {
        this.servicioBebida = servicioBebida;
    }

    // GET - Obtener todas las bebidas
    @GetMapping
    public List<Bebida> obtenerTodas() {
        return servicioBebida.obtenerTodas();
    }

    // GET - Obtener bebida por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bebida> obtenerPorId(
            @PathVariable("id") int id) {

        Bebida bebida = servicioBebida.obtenerPorId(id);

        if (bebida == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bebida);
    }

    // POST - Crear bebida
    @PostMapping
    public ResponseEntity<Bebida> agregarBebida(
            @RequestBody Bebida bebida) {

        Bebida nuevaBebida = servicioBebida.agregarBebida(bebida);

        return ResponseEntity.status(201).body(nuevaBebida);
    }

    // PUT - Actualizar bebida
    @PutMapping("/{id}")
    public ResponseEntity<Bebida> actualizarBebida(
            @PathVariable("id") int id,
            @RequestBody Bebida bebida) {

        Bebida bebidaActualizada = servicioBebida.actualizarBebida(id, bebida);

        if (bebidaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bebidaActualizada);
    }

    // DELETE - Eliminar bebida
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBebida(
            @PathVariable("id") int id) {

        boolean eliminado = servicioBebida.eliminarBebida(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}