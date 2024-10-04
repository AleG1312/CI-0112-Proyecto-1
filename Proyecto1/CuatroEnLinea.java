
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
    
    public String[][] getTablero(){
        return this.tablero;
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
    
    
    public String GanadorFila(){
        String ganador = null;
        
        //Revisión de filas:
        for (int i = 5; i >= 0; i--){
            //Voy a revisar desde el elemento inicial de la fila, hasta el elemento máximo de revisión de la misma fila
            for(int j = 0; j <= 3; j++){
                //Defino el ganador como el primer elemento que estoy revisando en la fila
                ganador = this.tablero[i][j];
                //Solo hago la revisión si el elemento que estoy revisando no está vacío
                if(ganador != null){
                    //Para el elemento en el que estoy, reviso los cuatro elementos posteriores incluyendo en el que estoy
                    for(int elemento = j; elemento <= (j+3); elemento++){
                        //El valor de comparación es uno de los 3 elementos posteriores a mi valor inicial
                        String valorDeComparacion = this.tablero[i][elemento];
                        //Si es diferente, finalizo la comparación del primero intento de  en línea de la fila
                        if (valorDeComparacion != ganador){
                            ganador = null;
                            break;
                        }                    
                    }
                }
                
                //Si encontró un ganador en la fila, devuelvo el valor, sino paso al siguiente valor de comparación de la misma fila
                if (ganador != null){
                    return ganador;
                }
            }
        }
        return ganador;        
    }
    
    
    public String GanadorColumna(){
        String ganador = null;
        
        //Revisión de columnas:
        for (int j = 0; j <= 6; j++){
            //Voy a revisar desde el último elemento de la fila, hasta la tercera posición desde el suelo
            for(int i = 5; i >= 3; i--){
                //Defino el ganador como el primer elemento que estoy revisando en la columna
                ganador = this.tablero[i][j];
                //Solo hago la revisión si el elemento que estoy revisando no está vacío
                if(ganador != null){
                    for(int elemento = (i-1); elemento >= (i-3); elemento--){
                        //System.out.println("Estoy comparando la posición [" + i + "," + j + "], con la posición [" + elemento + "," + j + "]");
                        //El valor de comparación es uno de los 3 elementos superiores a mi valor inicial
                        String valorDeComparacion = this.tablero[elemento][j];
                        //Si es diferente, finalizo la comparación del primero intento de  en línea de la fila
                        if (valorDeComparacion != ganador){
                            ganador = null;
                            break;
                        }  
                    }
                
                    //Si encontró un ganador en la columna, devuelvo el valor, sino paso al siguiente valor de comparación de la misma columna
                    if (ganador != null){
                        return ganador;
                    }
                }
            }
        }
        return ganador;
    }
    
   
    /*
    public String GanadorDiagonales(){
        String ganador = null;
        return ganador;
    }
    */
    
   public String EsGanador(){
        String ganador = null;
        //Reviso si hay ganador en las filas
        ganador = GanadorFila();
        if (ganador != null){
           return ganador;
        }
        
        else{
            //Reviso si hay ganador en las columnas
            ganador = GanadorColumna();
            if (ganador != null){
               return ganador;
            }
            /*
            else{
                //Reviso si hay ganador en las diagonales
                ganador = GanadorDiagonales();
                if(ganador != null){
                    return ganador;
                }
            }
            */
        }
        

       //En el caso de que no haya ganador en filas/columnas/diagonales, retorna el valor de ganador = null
       return ganador;
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
