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
    
    public String[] Ganador(){
        //resultados = [si hay ganador, cual es el ganador]
        String[] resultados = new String[2];
        resultados[0] = "False";
        String primerElemento;
        
        
        //Revisamos si hay ganador en cada fila
        for(int i = 0; i < this.tablero.length; i++){
            primerElemento = this.tablero[i][0];
            String jugadorGanador = this.tablero[i][0];
            for(int j = 1; j < this.tablero.length; j++){
                if(this.tablero[i][j] == primerElemento && this.tablero[i][j] != null){
                    resultados[0] = "True";
                    jugadorGanador = primerElemento;
                    resultados[1] = jugadorGanador;
                    //System.out.print("JugadorGanador: " + jugadorGanador);
                }
                else{
                    resultados[0] = "False";
                    jugadorGanador = null;
                }
            }
            
            if (resultados[0] == "True"){
                return resultados;
            }
        }
        
        //Revisamos si hay ganador en cada columna
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero.length; j++){
            }
        }
        
        //Revisamos si hay ganador en las diagonales
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero.length; j++){
            }
        }
        
        
        
        
        
        return resultados;
    }
    
    public void CambiarJugador(){
        if (this.jugadorActual == "X"){
            this.jugadorActual = "O";
        }        
        else{
            this.jugadorActual = "X";
        }         
    } 
}