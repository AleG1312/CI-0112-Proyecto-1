//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;

//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;
/**
 * Write a description of class Pruebas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pruebas
{
    public static void main(String[] args) throws IOException, InterruptedException{
        
        Scanner input = new Scanner(System.in);
        CuatroEnLinea nuevoJuego = new CuatroEnLinea();
        
        String[][] tablero = nuevoJuego.getTablero();
        
        while (true){
            nuevoJuego.MostrarTablero();
            
            System.out.println("Ingrese la columna para hacer su movimiento");
            int columna = input.nextInt();
                    
            nuevoJuego.HacerMovimiento(columna);
            String ganador = nuevoJuego.EsGanador();
            nuevoJuego.CambiarJugador();   
            
            if (ganador != null){
                nuevoJuego.MostrarTablero();
                System.out.println("El ganador es: " + ganador);
                break;
            }   
            else{
                //Limpio la pantalla
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            }
        }
    }
}
