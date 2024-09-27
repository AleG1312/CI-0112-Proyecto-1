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
        while (continuar){
            
            System.out.println("Fila:");
            int fila = input.nextInt();
            
            System.out.println("Columna");
            int columna = input.nextInt();
            
            nuevoJuego.HacerMovimiento(fila,columna);
            nuevoJuego.CambiarJugador();
            String[] resultados = nuevoJuego.Ganador();
            System.out.println("Hay ganador: " + resultados[0] + ".El ganador es: " + resultados[1]);
            
            nuevoJuego.MostrarTablero();
            
            
            System.out.println("Desea salir (1:Si, 2:No)");
            int eleccion = input.nextInt();
            if (eleccion == 1){
                continuar = false;
            }
        }
    }
}