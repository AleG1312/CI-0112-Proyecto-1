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
    private static void mostrarMenu(){
        System.out.println("Seleccione el juego que desea jugar: ");
        System.out.println("1. CuatroEnLinea");
        System.out.println("2. Salir");
    }
    private static int seleccionarJuego(){
        Scanner input = new Scanner(System.in);
        int juego;
        do{
            juego = input.nextInt();
        }while(juego != 1 && juego != 2);
        return juego;
    }
    private static void jugar(int juego){
        if (juego == 1){
            Scanner input = new Scanner(System.in);
            CuatroEnLinea nuevoJuego = new CuatroEnLinea();
            
            boolean juegoTerminado = false;
            while(juegoTerminado == false){
                nuevoJuego.mostrarTablero();
                
                System.out.println("Ingrese una columna para hacer su movimiento");
                int columna = input.nextInt(); 
                
                //Me verifica que la columna no esté llena
                boolean columnaLlena = nuevoJuego.columnaLlena(columna);
                if (columnaLlena == true){
                    do{
                        nuevoJuego.mostrarTablero();
                        System.out.println("La columna: " + columna + " está llena. Ingrese una diferente para hacer su movimiento");
                        columna = input.nextInt(); 
                        columnaLlena = nuevoJuego.columnaLlena(columna);
                    }while(columnaLlena == true);
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
                    nuevoJuego.resultadosFinales(ganador, empate);
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
    public static void main2(){
        CuatroEnLinea juego = new CuatroEnLinea();
        juego.mostrarTablero();
        String[][] tableroEmpate = matrizEmpate();
        juego.setTablero(tableroEmpate);
        //Compruebo si hay un ganador
        String ganador = juego.esGanador();
        //Compruebo si hay un empate
        boolean empate = juego.esEmpate(ganador);
        //Compruebo el fin del juego
        boolean juegoTerminado = juego.esJuegoTerminado(ganador, empate);
        if(juegoTerminado == true){
            juego.mostrarTablero();
            juego.resultadosFinales(ganador, empate);
        }
    }
    private static String[][] matrizEmpate(){
        int alternador = 1;
        String[][] tablero = new String[6][7];
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j <= 6; j++){
                String elemento = (alternador == 1)? "1":"2";
                tablero[i][j] = elemento;
                alternador *= -1;
            }
        }
        return tablero;
    }
}