import java.util.Scanner;
/**
 * Write a description of class Pruebas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pruebas
{
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        CuatroEnLinea nuevoJuego = new CuatroEnLinea();
        
        boolean continuar = true;
        while (continuar){
            nuevoJuego.MostrarTablero();
            
            System.out.println("Ingrese la columna para hacer su movimiento");
            int columna = input.nextInt();
            
            nuevoJuego.HacerMovimiento(columna);
            
            nuevoJuego.CambiarJugador();
            
            System.out.println("Desea salir (1:Si, 2:No)");
            int eleccion = input.nextInt();
            if (eleccion == 1){
                continuar = false;
            }
        }
    }
}
