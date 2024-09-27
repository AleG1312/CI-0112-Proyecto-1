/**
 * Write a description of class TicTacToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToe
{
    private String tablero[][]; 
    
    //Los jugadores seran representados por un 1 y un 0
    private String jugadorActual;
    
    /**
     * Metodo: 
     * Funcion: 
     * Parametros de entrada:
     *      Nombre parametro 1, tipo parametro 1
     *Parametros de salida:
     *      Parametro de salida 1, tipo parametro 1
     */
    
    public TicTacToe(){
        this.jugadorActual = "X";
        this.tablero = new String[3][3];
    }
    
    public void HacerMovimiento(int fila, int columna){
        if (this.tablero[fila][columna] != null){
            System.out.println("La casilla ya esta ocupada, por favor elija otra.");
        }
        else{
            this.tablero[fila][columna] = this.jugadorActual;
        }            
    } 
    
    public void MostrarTablero(){
        String fila = "";
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero.length; j++){
                if(tablero[i][j] == null){
                    fila += " ";
                }
                else{
                    fila += tablero[i][j];
                }
                fila += "|";
            }
            System.out.println(fila);
            System.out.println("----------------");
            fila = "";
        }
    } 
    
        public String[] Ganador() {
        // resultados = [si hay ganador, cual es el ganador]
        String[] resultados = new String[2];
        resultados[0] = "False";
        String primerElemento;
        String jugadorGanador;
        // Revisamos si hay ganador en cada fila
        for (int i = 0; i < this.tablero.length; i++) {
            primerElemento = this.tablero[i][0];
            if (primerElemento != null) {
                boolean filaIgual = true;
                for (int j = 1; j < this.tablero.length; j++) {
                    // Verificamos que la celda no sea null antes de compararla
                    if (this.tablero[i][j] == null || !this.tablero[i][j].equals(primerElemento)) {
                        filaIgual = false;
                        break;
                    }
                }
                if (filaIgual) {
                    resultados[0] = "True";
                    resultados[1] = primerElemento;
                    return resultados;
                }
            }
        }
    
        // Revisamos si hay ganador en cada columna
        for (int i = 0; i < this.tablero.length; i++) {
            primerElemento = this.tablero[0][i];
            if (primerElemento != null) {
                boolean columnaIgual = true;
                for (int j = 1; j < this.tablero.length; j++) {
                    // Verificamos que la celda no sea null antes de compararla
                    if (this.tablero[j][i] == null || !this.tablero[j][i].equals(primerElemento)) {
                        columnaIgual = false;
                        break;
                    }
                }
                if (columnaIgual) {
                    resultados[0] = "True";
                    resultados[1] = primerElemento;
                    return resultados;
                }
            }
        }
    
        // Revisamos si hay ganador en la diagonal principal
        primerElemento = this.tablero[0][0];
        if (primerElemento != null) {
            boolean diagonalPrincipal = true;
            for (int i = 1; i < this.tablero.length; i++) {
                // Verificamos que la celda no sea null antes de compararla
                if (this.tablero[i][i] == null || !this.tablero[i][i].equals(primerElemento)) {
                    diagonalPrincipal = false;
                    break;
                }
            }
            if (diagonalPrincipal) {
                resultados[0] = "True";
                resultados[1] = primerElemento;
                return resultados;
            }
        }
    
        // Revisamos si hay ganador en la diagonal secundaria
        primerElemento = this.tablero[0][this.tablero.length - 1];
        if (primerElemento != null) {
            boolean diagonalSecundaria = true;
            for (int i = 1; i < this.tablero.length; i++) {
                // Verificamos que la celda no sea null antes de compararla
                if (this.tablero[i][this.tablero.length - 1 - i] == null || !this.tablero[i][this.tablero.length - 1 - i].equals(primerElemento)) {
                    diagonalSecundaria = false;
                    break;
                }
            }
            if (diagonalSecundaria) {
                resultados[0] = "True";
                resultados[1] = primerElemento;
                return resultados;
            }
        }
    
        // Si no hay ganador
        resultados[0] = "False";
        resultados[1] = null;
        return resultados;
    }

    public void CambiarJugador(){
        if (this.jugadorActual=="X"){
            jugadorActual = "O";
        }        
        else{
            this.jugadorActual="X";
        }
    }
}

     
        