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

import mx.unam.aragon.tsp.vjimenez.pizzas.modelos.Tamano;
import mx.unam.aragon.tsp.vjimenez.pizzas.servicios.ServicioTamano;

@RestController
@RequestMapping("/api/v1/tamanos")
public class TamanoController {

    private final ServicioTamano servicioTamano;

    public TamanoController(ServicioTamano servicioTamano) {
        this.servicioTamano = servicioTamano;
    }

    // GET - Obtener todos los tamaños
    @GetMapping
    public List<Tamano> obtenerTodos() {
        return servicioTamano.obtenerTodos();
    }

    // GET - Obtener tamaño por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tamano> obtenerPorId(
            @PathVariable("id") int id) {

        Tamano tamano = servicioTamano.obtenerPorId(id);

        if (tamano == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tamano);
    }

    // POST - Crear tamaño
    @PostMapping
    public ResponseEntity<Tamano> agregarTamano(
            @RequestBody Tamano tamano) {

        Tamano nuevoTamano = servicioTamano.agregarTamano(tamano);

        return ResponseEntity.status(201).body(nuevoTamano);
    }

    // PUT - Actualizar tamaño
    @PutMapping("/{id}")
    public ResponseEntity<Tamano> actualizarTamano(
            @PathVariable("id") int id,
            @RequestBody Tamano tamano) {

        Tamano tamanoActualizado = servicioTamano.actualizarTamano(id, tamano);

        if (tamanoActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tamanoActualizado);
    }

    // DELETE - Eliminar tamaño
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTamano(
            @PathVariable("id") int id) {

        boolean eliminado = servicioTamano.eliminarTamano(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}