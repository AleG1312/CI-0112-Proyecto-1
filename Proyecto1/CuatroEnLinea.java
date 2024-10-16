/**
 * CuatroEnLinea
 * 
 * @author Luis Guido, Alejandro Guerra
 * @version 17-10-2024
 */
public class CuatroEnLinea
{
    //Matriz que representa el tablero
    private String[][] tablero;
    //String que representa el jugador
    private String jugadorActual;
    /*
     * Método Constructor:
     *      Crea mi objeto CuatroEnLinea.
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      Ninguno.
     * Respuesta Esperada:
     *      Inicializa el tablero y el símbolo del jugador actual.
     */
    public CuatroEnLinea(){
        this.tablero = new String[6][7];
        this.jugadorActual = "1"; 
    }
    public String[][] getTablero(){
        return this.tablero;
    }
    public void setTablero(String[][] tablero){
        this.tablero = tablero;
    }
    public String getJugadorActual(){
        return this.jugadorActual;
    }
    public void setJugadorActual(String jugadorActual){
        this.jugadorActual = jugadorActual;
    }
    /*
     * Método columnaLlena:
     *      Revisa si para una columna dada todavía hay campo o no.
     * Parámetros de entrada:
     *      Entero representando una columna.
     * Parámetros de salida:
     *      Booleano indicando true si está llena y false si no lo está.
     * Respuesta Esperada:
     *      Comprueba si hay espacio revisando la primera fila en la columna indicada. De estar vacía, es que queda campo. 
     *      De lo contrario, no.
     */
    public boolean columnaLlena(int columna){
        boolean columnaLlena = (this.tablero[0][columna] == null)? false:true;
        return columnaLlena;
    }
    /*
     * Método hacerMovimiento:
     *      Llena una casilla del tablero con el símbolo del jugador actual.
     * Parámetros de entrada:
     *      Entero representando una columna.
     * Parámetros de salida:
     *      Ninguno.
     * Respuesta Esperada:
     *      En la columna indicada, revisa la última casilla no nula y la rellena con el símbolo del jugador actual.
     */
    public void hacerMovimiento(int columna){
        for (int fila = this.tablero.length-1; fila >= 0; fila --){
            if (this.tablero[fila][columna] == null){
                this.tablero[fila][columna] = this.jugadorActual;
                break;
            }            
        }
    }
    /*
     * Método mostrarTablero:
     *      Imprime el estado actual del tablero en pantalla.
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      Ninguno.
     * Respuesta Esperada:
     *      Recorre el array en filas y luego columnas. Concatena en un String la información de cada columna junto con otros elementos (para ayudar con el formato)
     *      y posteriormente imprime la fila en pantala.
     */
    public void mostrarTablero(){
        String primeraFila;
        for (String[] fila : tablero){
            primeraFila = "|";
            for(String elemento : fila){
                primeraFila += (elemento == null)? " " : elemento;
                primeraFila += "|";
            }
            System.out.println(primeraFila); 
        }
    }
    /*
     * Método ganadorFila:
     *      Identifica si hay ganador en alguna fila.
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      String representando el ganador de fila. Puede regresar "null" si no hay ganador, o el símbolo del ganador en caso de que haya uno.
     * Respuesta Esperada:
     *      Empezando en la fila inferior, revisa si cualesquiera 4 espacios consecutivos (tomando como primer elemento, el elemento situado más a la izquierda)
     *      tienen un mismo símbolo, indicando así si hay ganador en esos espacios. El programa continúa hasta que identifique un ganador o haya revisado todo 
     *      el tablero sin encontrar nada.
     */
    public String ganadorFila(){
        String ganador = null;
        //columnaMaximaDeRevision corresponde a la última columna de cualquier fila en la que debe revisar si en los 3 espacios siguientes a la derecha
        //puede haber un ganador o no. Si hay 7 columnas, hay un posible ganador de fila hasta la columna 4.
        int columnaMaximaDeRevision = this.tablero[0].length-4;
        //Revisión de filas:
        for (int i = this.tablero.length-1; i >= 0; i--){
            //Voy a revisar desde el elemento inicial de la fila, hasta el elemento máximo de revisión de la misma fila
            for(int j = 0; j <= columnaMaximaDeRevision; j++){
                //Defino el posible ganador como el primer elemento que estoy revisando en la fila
                ganador = this.tablero[i][j];
                //Solo hago la revisión si el elemento que estoy revisando no está vacío
                if(ganador != null){
                    //Reviso si los tres elementos siguientes son iguales a mi posible ganador
                    for(int elemento = j+1; elemento <= (j+3); elemento++){
                        //El valor de comparación es uno de los 3 elementos posteriores a mi valor inicial
                        String valorDeComparacion = this.tablero[i][elemento];
                        //Si el valor de comparación es diferente a mi posible ganador, finalizo la búsqueda de ganador para esos 4 elementos y reestablezco el valor de ganador en null
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
    /*
     * Método ganadorColumna:
     *      Identifica si hay ganador en alguna columna.
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      String representando el ganador de la columna. Puede regresar "null" si no hay ganador, o el símbolo del ganador en caso de que haya uno.
     * Respuesta Esperada:
     *      Empezando en la fila inferior, revisa si cualesquiera 4 espacios consecutivos (tomando como primer elemento, el elemento más abajo)
     *      tienen un mismo símbolo, indicando así si hay ganador en esos espacios. El programa continúa hasta que identifique un ganador o haya revisado todo 
     *      el tablero sin encontrar nada.
     */
    public String ganadorColumna(){
        String ganador = null;
        //filaMaximaDeRevision corresponde a la última fila de cualquier columna en la que debe revisar si en los 3 espacios siguientes hacia arriba
        //puede haber un ganador o no. Si hay 6 filas, hay un posible ganador de columna hasta la columna 3.
        int filaMaximaDeRevision = 3;
        //Revisión de columnas:
        for (int j = 0; j <= (this.tablero[0].length-1); j++){
            //Voy a revisar desde el último elemento de la columna, hasta el elemento máximo de revisión de la misma columna
            for(int i = (this.tablero.length-1); i >= filaMaximaDeRevision; i--){
                //Defino el posible ganador como el primer elemento que estoy revisando en la fila
                ganador = this.tablero[i][j];
                //Solo hago la revisión si el elemento que estoy revisando no está vacío
                if(ganador != null){
                    //Reviso si los tres elementos de arriba son iguales a mi posible ganador
                    for(int elemento = (i-1); elemento >= (i-3); elemento--){
                        //El valor de comparación es uno de los 3 elementos superiores a mi valor inicial
                        String valorDeComparacion = this.tablero[elemento][j];
                        //Si el valor de comparación es diferente a mi posible ganador, finalizo la búsqueda de ganador para esos 4 elementos y reestablezco el valor de ganador en null
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
     * Método esGanador:
     *      Revisa si hay un ganador en la partida.
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      String representando el ganador de la partida. Puede regresar "null" si no hay ganador, o el símbolo del ganador en caso de que haya uno.
     * Respuesta Esperada:
     *      Llamará a las funciones de comprobación de ganador en las filas, columnas y diagonales respectivamente. El programa se detiene cuando 
     *      encuentre un ganador o cuando haya ejecutado las funciones mencionadas sin encontrar nada.
     */
    public String esGanador(){
        String ganador = null;
        //Reviso si hay ganador en las filas
        ganador = ganadorFila();
        if (ganador != null){
           return ganador;
        }
        
        //Reviso si hay ganador en las columnas
        ganador = ganadorColumna();
        if (ganador != null){
           return ganador;
        }
        //Reviso si hay ganador en la diagonal
        ganador = ganadorDiagonal();
        if(ganador!=null){
        return ganador;
        }
        //En el caso de que no haya ganador en filas/columnas/diagonales, retorna el valor de ganador = null
        return ganador;
    }
    
    /*
     * Método esTableroLleno:
     *      Revisa si el tablero se encuentra lleno.
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      Booleano que representa si el tablero está lleno.
     * Respuesta Esperada:
     *      Revisa únicamente los espacios de la primera fila. Si hay alguno libre, el tablero no está lleno.
     */
    public boolean esTableroLleno(){
        //Asumo que el tablero está lleno
        boolean tableroLleno = true;
        //Reviso la primera fila
        for(int j = 0; j <= (this.tablero[0].length-1);j++){
            //Si el elemento está vacío, el tablero no está lleno
            if(this.tablero[0][j] == null){
                tableroLleno = false;
                return tableroLleno;
            }
        }
        return tableroLleno;
    }
    /*
     * Método esEmpate:
     *      Me indica si hay un empate.
     * Parámetros de entrada:
     *      String representando el ganador (null/algún jugador).
     * Parámetros de salida:
     *      Booleano representando si hay empate o no.
     * Respuesta Esperada:
     *      Si hay un ganador, entonces no hay un empate. 
     *      Si no hay un ganador y el tablero está lleno, entonces hay empate.
     */
    public boolean esEmpate(String ganador){
        boolean empate = false;
        if(ganador == null && esTableroLleno() == true){
            empate = true;
        }
        return empate;
    }

    /*
     * Método esJuegoTerminado:
     *      Revisa si el juego terminó.
     * Parámetros de entrada:
     *      String representando el ganador del juego.
     *      Booleano representando el empate.
     * Parámetros de salida:
     *      Booleano representando si el juego terminó.
     * Respuesta Esperada:
     *      Si hay ganador, el juego terminó.
     *      Si hay empate, el juego terminó.
     *      Si no se cumplen, el juego no ha terminado.
     */
    public boolean esJuegoTerminado(String ganador, boolean esEmpate){
        boolean juegoTerminado = false;
        if(ganador != null){
                juegoTerminado = true;
        }
        else{
            if(esEmpate == true){
                juegoTerminado = true;
            }
        }
        return juegoTerminado;
    }
    /*
     * Método resultadosFinales:
     *      Imprime los resultados del fin de la partida.
     * Parámetros de entrada:
     *      String representando el ganador del juego.
     *      Booleano representando el empate.
     * Parámetros de salida:
     *      Ninguno.
     * Respuesta Esperada:
     *      Imprime en pantalla ya sea el ganador, o el mensaje de que el juego concluyó en empate.
     */
    public void resultadosFinales(String ganador, boolean esEmpate){
        if(ganador != null){
            System.out.println("El ganador es: " + ganador);
        }
        else{
            System.out.println("El juego ha terminado en empate");
        }
    }
    /*
     * Método cambiarJugador:
     *      Cambia el símbolo del jugador actual
     * Parámetros de entrada:
     *      Ninguno.
     * Parámetros de salida:
     *      Ninguno.
     * Respuesta Esperada:
     *      Revisa el símbolo del jugador actual y lo cambia entre las dos posibles opciones.
     */
    public void cambiarJugador(){
        if(this.jugadorActual == "1"){
            this.jugadorActual = "2";
        }
        else{
            this.jugadorActual = "1";
        }
    }
    /*
     * Metodo ganadorDiagonal:
     *      este metodo revisa las diagonales posibles 
     * Parametros de entrada
     *      ninguno
     * Parametros salida
     *      retorna un String que representa si hay ganador
     * Respuesta esperada
     *      Se espera que pueda indentificar cada una de las diagonales presentes en el tablero y retorne correctamente
     *      si hay un ganador
     *      
       */
    public String ganadorDiagonal() {
        int filas = tablero.length;
        int columnas = tablero[0].length;
        
        //recorremos cada casilla para verificar si hay una diagonal ascendente llamando al metodo diagonalAscendente
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Verificar diagonal ascendente
                String ganadorAscendente = diagonalAscendente(i, j);
                if (ganadorAscendente != null) {
                    return ganadorAscendente;
                }
    
                // Verificar diagonal descendente
                String ganadorDescendente = diagonalDescendente(i, j);
                if (ganadorDescendente != null) {
                    return ganadorDescendente;
                }
            }
        }
        return null; // No hay ganador en ninguna diagonal
    }
    /*
     * Metodo diagonalDescendente:
     *      este método nos asegura que haya espacio para la diagonal y ademas compara los elementos
     * Parametros de entrada:
     *      toma como parametros las filas y columnas
     * Parametros de salida:
     *      devuelve un String que representa el ganador
     * Respuesta esperada
     *      Se espera que identifique correctamente cuando hay una diagonal descendente existente
       */
    private String diagonalDescendente(int fila, int columna) {
        //verifica el espacio
        if (fila - 3 >= 0 && columna + 3 < tablero[0].length) {
            String jugador = tablero[fila][columna];
            //compara los elementos de la diagonal 
            if (jugador != null && tablero[fila - 1][columna + 1] == jugador &&
                tablero[fila - 2][columna + 2] == jugador &&
                tablero[fila - 3][columna + 3] == jugador) {
                return String.valueOf(jugador);
            }
        }
        return null;
    }
    /*
     * Metodo diagonalAscendente:
     *      este método nos asegura que haya espacio para la diagonal y ademas compara los elementos
     * Parametros de entrada:
     *      toma como parametros las filas y columnas
     * Parametros de salida:
     *      devuelve un String que representa el ganador
     * Respuesta esperada
     *      Se espera que identifique correctamente cuando hay una diagonal ascendente existente
       */
    private String diagonalAscendente(int fila, int columna) {
        // verifica el espacio
        if (fila + 3 < tablero.length && columna + 3 < tablero[0].length) {
            String jugador = tablero[fila][columna];
            //compara los elementos de la diagonal 
            if (jugador != null && tablero[fila + 1][columna + 1] == jugador &&
                tablero[fila + 2][columna + 2] == jugador &&
                tablero[fila + 3][columna + 3] == jugador) {
                return String.valueOf(jugador);
            }
        }
        return null;
    }
    
}