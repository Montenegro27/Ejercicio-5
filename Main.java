public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Torneo
        Torneo torneo = new Torneo();

        // Agregar jugadores (puedes hacerlo según tus necesidades)
        torneo.agregarJugador(new Líbero("Nombre1", "País1", 5, 3, 100, 90));
        torneo.agregarJugador(new Pasador("Nombre2", "País2", 10, 2, 120, 100));
        // Agrega más jugadores según tus necesidades

        // Mostrar jugadores
        torneo.mostrarJugadores();

        // Contar pasadores con más del 80% de efectividad
        int pasadoresCon80Porciento = torneo.contarPasadores();
        System.out.println("Cantidad de pasadores con más del 80% de efectividad: " + pasadoresCon80Porciento);

        // Guardar en un archivo CSV (debes implementar esta lógica)
        torneo.guardarEnCSV("jugadores.csv");

        // Cargar desde un archivo CSV (debes implementar esta lógica)
        torneo.cargarDesdeCSV("jugadores.csv");
    }
}
