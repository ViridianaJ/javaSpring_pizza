package mx.unam.aragon.tsp.vjimenez.pizzas.dtos;

public class IdDto {
    int id;
    String mensaje;

    public IdDto(int id, String mensaje) {
        this.id = id;
        this.mensaje = mensaje;
    }

    public IdDto(Object id2, Object mensaje2) {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
