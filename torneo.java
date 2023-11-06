import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Torneo {
    private static final Torneo torneo = null;
    private ArrayList<JugadorMasValioso> listaJugadores;

    public Torneo() {
        listaJugadores = new ArrayList<>();
    }

    public void agregarJugador(JugadorMasValioso jugador) {
        listaJugadores.add(jugador);
    }

    public void mostrarJugadores() {
        for (JugadorMasValioso jugador : listaJugadores) {
            System.out.println(jugador);
        }
    }

    public void mejoresLiberos() {
    // Ordena la lista de jugadores por efectividad en orden descendente
    listaJugadores.sort((jugador1, jugador2) -> Double.compare(jugador2.getEfectividad(), jugador1.getEfectividad()));

    // Selecciona los primeros 3 jugadores (líberos) de la lista
    List<JugadorMasValioso> mejoresLiberos = listaJugadores.stream()
            .filter(jugador -> jugador instanceof Líbero)
            .limit(3)
            .collect(Collectors.toList());

    System.out.println("Los 3 mejores líberos:");
    for (JugadorMasValioso jugador : mejoresLiberos) {
        System.out.println(jugador);
         }
    }

    public int contarPasadores() {
    int contadorPasadores = 0;
    for (JugadorMasValioso jugador : listaJugadores) {
        if (jugador instanceof Pasador) {
            Pasador pasador = (Pasador) jugador;
            pasador.calcularEfectividad(); // Asegurémonos de que la efectividad esté calculada
            if (pasador.getEfectividad() > 80.0) {
                contadorPasadores++;
                }
            }
        }
    return contadorPasadores;
    }

    public void guardarEnCSV(String nombreArchivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
        // Encabezado del archivo CSV
        writer.write("Nombre,País,Errores,Aces,TotalServicios,RecibosEfectivos\n");

        for (JugadorMasValioso jugador : listaJugadores) {
            if (jugador instanceof Líbero) {
                Líbero líbero = (Líbero) jugador;
                // Formato: Nombre,País,Errores,Aces,TotalServicios,RecibosEfectivos
                String linea = líbero.getNombre() + "," + líbero.getPaís() + ","
                        + líbero.getErrores() + "," + líbero.getAces() + ","
                        + líbero.getTotalServicios() + "," + líbero.getRecibosEfectivos();
                writer.write(linea + "\n");
                }
            // Agrega lógica similar para otros tipos de jugadores (Pasador, AuxiliarOpuesto, etc.)
            }
        System.out.println("Datos guardados en el archivo CSV: " + nombreArchivo);
        } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error al guardar los datos en el archivo CSV.");
        }
    }

    public void cargarDesdeCSV(String nombreArchivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length == 6) {
                // Verifica que los datos sean válidos antes de convertirlos
                try {
                    String nombre = datos[0];
                    String país = datos[1];
                    int errores = Integer.parseInt(datos[2]);
                    int aces = Integer.parseInt(datos[3]);
                    int totalServicios = Integer.parseInt(datos[4]);
                    int recibosEfectivos = Integer.parseInt(datos[5]);

                    // Crea el jugador y agrégalo a la lista
                    if (datos[0].equals("Líbero")) {
                        torneo.agregarJugador(new Líbero(nombre, país, errores, aces, totalServicios, recibosEfectivos));
                    } else if (datos[0].equals("Pasador")) {
                        torneo.agregarJugador(new Pasador(nombre, país, errores, aces, totalServicios, 0, 0));
                    }
                    // Agrega lógica similar para otros tipos de jugadores si es necesario
                } catch (NumberFormatException e) {
                    System.out.println("Error en los datos: " + linea);
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
