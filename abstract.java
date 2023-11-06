

// Clase base abstracta para los diferentes tipos de jugadores
abstract class JugadorMasValioso {
    private double efectividad;

    public JugadorMasValioso() {
    }

    public JugadorMasValioso(String nombre, String país) {
    }

    public double getEfectividad() {
        return efectividad;
    }

    // Método abstracto que se implementará en las clases derivadas
    public abstract void calcularEfectividad();

    public String toString() {
        return "Efectividad: " + efectividad;
    }
}
