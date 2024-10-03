
/**
 * Write a description of class CuatroEnLinea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuatroEnLinea
{
    // instance variables - replace the example below with your own
    private String[][] tablero;
    private String jugadorActual;

    /**
     * Método Constructor
     */
    public CuatroEnLinea(){
        this.tablero = new String[6][7];
        this.jugadorActual = "1"; 
    }

    public void HacerMovimiento(int columna){
        for (int fila = this.tablero.length-1; fila >= 0; fila --){
            if(this.tablero[0][columna] != null){
                System.out.println("No se pudo hacer el movimiento correctamente");
                CambiarJugador();
                break;
            }
            if (this.tablero[fila][columna] == null){
                this.tablero[fila][columna] = this.jugadorActual;
                break;
            }            
        }
    }
    
    public void MostrarTablero(){
        String primeraFila;
        for (String[] fila : tablero){
            primeraFila = "|";
            for(String elemento : fila){
                if (elemento == null){
                    primeraFila += " ";
                }
                else{
                    primeraFila += elemento;
                }
                primeraFila += "|";
            }
            System.out.println(primeraFila); 
        }
    }
    
    public void CambiarJugador(){
        if(this.jugadorActual == "1"){
            this.jugadorActual = "2";
        }
        else{
            this.jugadorActual = "1";
        }
    }
}
