package pe.edu.ucs.SistemaVentasRestaurante.modelo;

public class Pedido {

    private String cliente;
    private String plato;
    private int cantidad;

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con parámetros
    public Pedido(String cliente, String plato, int cantidad) {
        this.cliente = cliente;
        this.plato = plato;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // toString opcional
    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", plato=" + plato + ", cantidad=" + cantidad + "]";
    }
}


