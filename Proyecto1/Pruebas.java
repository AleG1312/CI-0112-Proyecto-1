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
public class Pruebas{   
    public static void mostrarMenu(){
        System.out.println("Seleccione el juego que desea jugar: ");
        System.out.println("1. CuatroEnLinea");
        System.out.println("2. Salir");
    }
    public static int seleccionarJuego(){
        Scanner input = new Scanner(System.in);
        int juego;
        do{
            juego = input.nextInt();
        }while(juego != 1 && juego != 2);
        return juego;
    }
    public static void jugar(int juego){
        if (juego == 1){
            Scanner input = new Scanner(System.in);
            CuatroEnLinea nuevoJuego = new CuatroEnLinea();
    
            boolean juegoTerminado = false;
            while(juegoTerminado == false){
                nuevoJuego.mostrarTablero();
                
                System.out.println("Ingrese una columna para hacer su movimiento");
                int columna = input.nextInt(); 
                boolean movimientoValido = nuevoJuego.movimientoValido(columna);
                if (movimientoValido == false){
                    do{
                        nuevoJuego.mostrarTablero();
                        System.out.println("Ingrese una columna válida para hacer su movimiento");
                        columna = input.nextInt(); 
                        movimientoValido = nuevoJuego.movimientoValido(columna);
                    }while(movimientoValido == false);
                }
                nuevoJuego.hacerMovimiento(columna);
                
                //Compruebo si hay un ganador
                String ganador = nuevoJuego.esGanador();
                //Compruebo si hay un empate
                boolean empate = nuevoJuego.esEmpate(ganador);
                //Compruebo el fin del juego
                juegoTerminado = nuevoJuego.esJuegoTerminado(ganador, empate);
                //En caso de que el juego continúe
                if(juegoTerminado == false){
                    nuevoJuego.cambiarJugador(); 
                }
                //Protocolo de fin del juego
                else{
                    nuevoJuego.mostrarTablero();
                    nuevoJuego.resultadosFinDelJuego(ganador, empate);
                }
            }
        }
    }
    public static void main(String[] args){
        int juego;
        do{
            mostrarMenu();
            juego = seleccionarJuego();
            if (juego != 2){
                jugar(juego);
            }
        }while(juego != 2);
        System.out.println("Saliendo de la simulación");
    }
}