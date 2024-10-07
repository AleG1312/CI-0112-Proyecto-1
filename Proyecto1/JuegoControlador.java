import java.util.Scanner;
/**
 * Write a description of class JuegoControlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JuegoControlador
{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        TicTacToe nuevoJuego = new TicTacToe();
        System.out.println("El tablero inicial es: ");
        nuevoJuego.MostrarTablero();
        
        boolean continuar = true;
        while (continuar) {
            // Pedimos la fila y columna para el movimiento
            System.out.println("Fila:");
            int fila = input.nextInt();
            
            System.out.println("Columna:");
            int columna = input.nextInt();
            
            // Realizamos el movimiento y verificamos si fue exitoso
            boolean movimientoValido = nuevoJuego.HacerMovimiento(fila, columna);
            
            if (movimientoValido) {
                // Solo cambiamos de jugador si el movimiento fue válido
                nuevoJuego.CambiarJugador();
                
                // Verificamos el estado del juego
                boolean resultadoGanador2Aux = nuevoJuego.JuegoTerminado();
                String[] resultadoGanador = nuevoJuego.Ganador();
                
                if (!resultadoGanador2Aux) {
                    System.out.println("Aún no hay resultados.");  // Mensaje si no hay ganador ni empate
                } else if (resultadoGanador[0].equals("True")) {
                    System.out.println("El juego ha terminado, el ganador es: " + resultadoGanador[1]);
                    continuar = false;  // Salimos del juego si hay un ganador
                } else if (nuevoJuego.Empate()) {
                    System.out.println("El juego ha terminado, es un empate.");
                    continuar = false;  // Salimos del juego si hay empate
                }
                
            } else {
                System.out.println("La casilla ya está ocupada, por favor elija otra.");
                // No cambiamos de jugador porque el movimiento no fue válido
            }
            
            // Mostramos el tablero actual después de cada turno
            nuevoJuego.MostrarTablero();
            
            // Preguntamos al jugador si desea continuar
            System.out.println("¿Desea salir? (1: Sí, 2: No)");
            int eleccion = input.nextInt();
            if (eleccion == 1) {
                continuar = false;  // Finalizamos el juego si elige salir
            }
        }
    }
}

