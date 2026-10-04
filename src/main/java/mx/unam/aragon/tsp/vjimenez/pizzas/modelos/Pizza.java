package mx.unam.aragon.tsp.vjimenez.pizzas.modelos;

public class Pizza {

    private int id;
    private String nombre;
    private String ingredientes;

    public Pizza() {
    }

    public Pizza(int id, String nombre, String ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
}