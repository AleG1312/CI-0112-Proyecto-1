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
        nuevoJuego.mostrarTablero();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Turno del jugador: " + nuevoJuego.getJugadorActual());
            System.out.println("Fila:");
            int fila = input.nextInt();
            System.out.println("Columna:");
            int columna = input.nextInt();

            boolean movimientoValido = nuevoJuego.hacerMovimiento(fila, columna);
            if (movimientoValido) {
                nuevoJuego.cambiarJugador();
                boolean resultadoGanador2Aux = nuevoJuego.JuegoTerminado();
                String[] resultadoGanador = nuevoJuego.ganador();
                if (!resultadoGanador2Aux) {
                        System.out.println("Aún no hay resultados.");
                } else if (resultadoGanador[0].equals("True")) {
                    System.out.println("El juego ha terminado, el ganador es: " + resultadoGanador[1]);
                    continuar = false;
                } else if (nuevoJuego.empate()) {
                    System.out.println("El juego ha terminado, es un empate.");
                    continuar = false;
                }
                } else {
                    System.out.println("La casilla ya está ocupada, por favor elija otra.");
                }
                nuevoJuego.mostrarTablero();
            }
    }
    private static void jugarCuatroEnLinea(){
            Scanner input = new Scanner(System.in);
            CuatroEnLinea nuevoJuego = new CuatroEnLinea();

            boolean juegoTerminado = false;
            while(juegoTerminado == false){
                nuevoJuego.mostrarTablero();
                
                System.out.println("Ingrese una columna dentro del rango [0," + (nuevoJuego.getTablero()[0].length-1) + "] para hacer su movimiento");
                int columna = input.nextInt(); 
                
                //Me verifica que el movimiento sea válido
                boolean movimientoValido = nuevoJuego.movimientoValido(columna);
                if(movimientoValido == false){
                    do{
                        nuevoJuego.mostrarTablero();
                        System.out.println("La columna: " + columna + " es inválida. Por favor ingrese una dentro del rango [0," + (nuevoJuego.getTablero()[0].length-1) + "]");
                        columna = input.nextInt(); 
                        movimientoValido = nuevoJuego.movimientoValido(columna);
                    }while(movimientoValido == false);
                }
    
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