
class Jugador {
    private String nombre;
    private String país;

    public Jugador(String nombre, String país) {
        this.nombre = nombre;
        this.país = país;
    }

    public String toString() {
        return "Nombre: " + nombre + ", País: " + país;
    }
}
