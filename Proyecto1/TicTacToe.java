/**
 * Write a description of class TicTacToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToe
{
    private String tablero[][]; 
    //Los jugadores seran representados por un X y un O
    private String jugadorActual;
    //inicializamos el tablero
    /* Metodo constructor:
     *      Crea mi objeto Tic Tac Toe.
     * Parametros de entrada:
     *       ninguno.
     * Parametros de salida:
     *       ninguno.
     * Respuesta esperada:
     *       inicializa el tablero y el jugador actual en X.
     */
    public TicTacToe(){
        this.jugadorActual = "X";
        this.tablero = new String[3][3];
    }
    //setters
    public void setJugadorActual(String jugadorActual){
        this.jugadorActual = jugadorActual;
    }
    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }
    //getters
    public String getJugadorActual() {
        return jugadorActual;
    }
    public String[][] getTablero() {
        return tablero;
    }
    
    /* Metodo hacerMovimientoAux:
     *      Revisa si el movimiento es válido y efectúa el movimiento.
     * Parametros de entrada:
     *      enteros representando fila y columna.
     * Parametros de Sálida:
     *      booleano representando si el movimiento es válido.
     * Respuesta esperada:
     *      Devuelva el booleano indicando si el movimiento fue valido o no, y además logre egectuar el movimiento
     *      tomando en cuenta si la casilla esta vacía o llena.
     */
    public boolean hacerMovimiento(int fila, int columna) {
        if (this.tablero[fila][columna] != null) {
            System.out.println("La casilla ya está ocupada, por favor elija otra.");
            return false; // Retorna false si la casilla ya está ocupada
        } else {
            this.tablero[fila][columna] = this.jugadorActual;
            return true; // Retorna true si el movimiento es válido
        }
    }
    
    /* Metodo mostarTablero:
     *      muestra el tablero despues de cada movimiento.
     * Parametros de entrada:
     *      ninguno.
     * Parametros de Sálida:
     *      devuelve "|" para separar cada columna y un espacio considerable para separar las filas.
     * Respuesta esperada:
     *      Se espera que devuelva el tablero correctamente considerando si las casillas estan vacias o llenas y
     *      mantenga las separaciones correspondientes.
     */
    public void mostrarTablero(){
        String fila = " ";
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero.length; j++){
                if(tablero[i][j]==null){
                    fila += " ";
                }
                else{
                    fila += tablero[i][j];
                }
                fila += " | ";
            }
            System.out.println(fila);
            
            System.out.println("        ");
            fila = " ";
        }
    }
    
    /* Metodo ganadorFila:
     *      Revisa si hay un ganador en las filas.
     * Parametros de entrada:
     *      ninguno.
     * Parametros de Sálida:
     *      devuelve si hay un ganador en las filas.
     * Respuesta esperada:
     *      Se espera que el metodo identifique correctamente un ganador en las columnas.
     */
        public String[] ganadorFila() {
        String[] resultados = new String[2];
        resultados[0] = "False";
        String primerElemento;
        String jugadorGanador;
        // Revisamos si hay ganador en cada fila
        /*Se ideó de la siguiente manera: se fijó un elemento en la casilla [i][0] de modo que i sea cualquier
         * numero entre 0 y 2 como primer elemento, y posteriormente se revisa si las casilla esta llena para 
         * compararla con el elemento fijo, ademas se inicializa la variable booleana que dice si la fila es igual 
         *  y así nos dice si hay un ganador y quien es.
         */
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
        resultados[0] = "False";
        resultados[1] = null;
        return resultados;
    }
    
    /*
     * Metodo ganadorColumna:
     *      identifica todas las formas posibles de ganar en columnas 
     * Parametros de entrada:
     *      ninguno
     * Parametros de Sálida:
     *      un String[] que se encarga de devolver si hay un ganador en columnas
     * Respuesta esperada:
     *      Se espera que identifique correctamente si hay un ganador en columnas
       */
    public String [] ganadorColumna(){
        String[] resultados = new String[2];
        resultados[0] = "False";
        String primerElemento;
        String jugadorGanador;
        // Revisamos si hay ganador en cada columna
        /*Del mismo modo fijamos una casilla [0][i] con 0<=i<=2 como primer elemento, asimismo primero vemos si la 
         * casilla está llena y luego procede a comparar el resto de casillas con el primer elemento, del mismo modo 
         * se incializa la variable columna llena que nos dice si la columna esta llena con elementos iguales, si
         * esta llena retorna al ganador.
         */
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
        resultados[0] = "False";
        resultados[1] = null;
        return resultados;
    }
    
    /*
     * Metodo ganadorDiagonal:
     *      identifica todas las formas posibles de ganar en las diagonales 
     * Parametros de entrada:
     *      ninguno
     * Parametros de Sálida:
     *      un String[] que se encarga de devolver si hay un ganador en diagonales
     * Respuesta esperada:
     *      Se espera que identifique correctamente si hay un ganador en diagonales
       */
    public String [] ganadorDiagonal() {
        String[] resultados = new String[2];
        resultados[0] = "False";
        String primerElemento;
        String jugadorGanador;
        //Revisamos si hay ganador en la diagonal principal
        /*Del mismo modo fijamos un primer elemento en la casilla [0][0] que es el primer elemento de la diagonal
         * principal y luego se procede a revisar el resto de casillas para verificar si son iguales al primer 
         * elemento y modifica la variable booleana diagonal igual para devolver que si hay un ganador y quien es
         * el ganador
         */
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
    /*
     * Metodo ganador:
     *      identifica todas las formas posibles de ganar 
     * Parametros de entrada:
     *      ninguno
     * Parametros de Sálida:
     *      un String[] que se encarga de devolver si hay un ganador
     * Respuesta esperada:
     *      Se espera que identifique correctamente si hay un ganador en filas, columnas y diagonales
       */
    public String[] ganador() {
        String[] ganador = ganadorFila();
        if(ganador[0] != "False") {
            return ganador;
        }
        
        ganador = ganadorColumna();
        if(ganador[0]!= "False") {
            return ganador;
        }
        
        ganador = ganadorDiagonal();
        if(ganador[0]!="False") {
            return ganador;
        }
        return ganador;
    }

    /* Metodo cambiarJugador:
     *      cambia el jugador cada ronda considerando si el movimiento es valido 
     * Parametros de entrada:
     *      ninguno
     * Parametros de Sálida:
     *      ninguno
     * Respuesta esperada:
     *      Se espera que cambie el jugador en cada ronda cosiderando si el movimiento es valido 
     */
    public void cambiarJugador(){
        if (this.jugadorActual=="X"){
            jugadorActual = "O";
        }        
        else{
            this.jugadorActual="X";
        }
    }
    
    /* Metodo empate:
     *      identifica el empate durante el juego 
     * Parametros de entrada:
     *      ninguno.
     * Parametros de Sálida:
     *      retorna un booleano que nos dice si hay o no hay empate.
     * Respuesta esperada:
     *      Se espera que devuelva correctamente si hay un empate o no considerando el unico caso posible que es que
     *      el tablero este lleno.
     */   
    public boolean empate() {
        // Recorre el tablero
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                // Si encuentra una celda vacía, aún no hay empate
                if (this.tablero[i][j] == null) {
                    return false;
                }
            }
        }
        // Si no hay celdas vacías, hay empate
        return true;
    }
    
    /* Metodo juegoTerminado:
     *      termina el juego. 
     * Parametros de entrada:
     *      ninguno
     * Parametros de Sálida:
     *      retorna un booleano diciendo si el juego ha terminado o no.
     * Respuesta esperada:
     *      Se espera que indique correctamente cuando el juego ha terminado. 
     */
    public boolean juegoTerminado() {
        String[] resultadoGanador2 = ganador();
        if (resultadoGanador2[0].equals("True")) {
            return true;
        } else if (empate()) {
            return true;
        } 
        return false;
    }
    
}



     
        