//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;
//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;
/**
 * JuegoControlador
 * 
 * @author Luis Guido, Alejandro Guerra
 * @version 17-10-2024
 */
public class JuegoControlador{   
    private static void mostrarMenu(){
        System.out.println("Seleccione el juego que desea jugar: ");
        System.out.println("1. CuatroEnLinea");
        System.out.println("2. TicTacToe");
        System.out.println("3. Salir");
    }
    private static int seleccionarJuego(){
        Scanner input = new Scanner(System.in);
        int juego;
        juego = input.nextInt();
        return juego;
    }
    private static void jugar(int juego){
        if (juego == 1){
            jugarCuatroEnLinea();
        }
        else{   //En caso de que juego == 2
            jugarTicTacToe();
        }
    }
    private static void jugarTicTacToe(){
        Scanner input = new Scanner(System.in);
        TicTacToe nuevoJuego = new TicTacToe();
        
        System.out.println("El tablero inicial es: ");
        nuevoJuego.MostrarTablero();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Turno del jugador: " + nuevoJuego.getJugadorActual());
            System.out.println("Fila:");
            int fila = input.nextInt();
            System.out.println("Columna:");
            int columna = input.nextInt();

            boolean movimientoValido = nuevoJuego.HacerMovimiento(fila, columna);
            if (movimientoValido) {
            nuevoJuego.CambiarJugador();
            boolean resultadoGanador2Aux = nuevoJuego.JuegoTerminado();
            String[] resultadoGanador = nuevoJuego.Ganador();
            if (!resultadoGanador2Aux) {
                    System.out.println("Aún no hay resultados.");
            } else if (resultadoGanador[0].equals("True")) {
                System.out.println("El juego ha terminado, el ganador es: " + resultadoGanador[1]);
                continuar = false;
            } else if (nuevoJuego.Empate()) {
                System.out.println("El juego ha terminado, es un empate.");
                continuar = false;
            }
            } else {
                System.out.println("La casilla ya está ocupada, por favor elija otra.");
            }
                nuevoJuego.MostrarTablero();
            }
    }
    private static void jugarCuatroEnLinea(){
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
    public static void main(String[] args){
        int juego;
        do{
            mostrarMenu();
            juego = seleccionarJuego();
            if (juego != 3){
                jugar(juego);
            }
        }while(juego != 3);
        System.out.println("Saliendo de la simulación");
    }
}


/*public class JuegoControlador
{   private TicTacToe nuevoTicTacToe;
    private CuatroEnLinea nuevoCuatroEnLinea;
    
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
            
        }
    }
}*/

