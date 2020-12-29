/*
CLASE Palabra
ENTORNO DE TRABAJO:
La secuencia de caracteres introducida por teclado puede contener como 
caracteres os siguientes: espacios en blanco, saltos de línea, caracteres
del alfabeto (minúsculas sin acentos ni diéresis), el espacio en blanco y los siguientes 
signos de puntuación: . , : @ ? ! " ( ) < >.
El final de secuencia vendrá dado por el caracter de control salto de línea '\n'
 */
package práctica;


public class Palabra {
    //ATRIBUTOS (describen el estado de los objetos Palabra)
    //declaración atributo de clase constante caracter que representa el final de
    //la secuencia de caracteres
    private static final char FINAL_SECUENCIA='\n';
    //declaración atributo de clase constante caracter que representa el espacio
    //en blanco
    private static final char ESPACIO=' ';
    //declaración atributo de clase constante entero que representa el máximo número
    //de caracteres que puede aglutinar un objetp Palabra
    private static final int MAXIMO_NUMERO_CARACTERES=20;
    //declaración atributo de clase variable caracter que representa el caracter leido
    //de la secuencia de caracteres introducida por teclado
    private static char caracter=ESPACIO; //es inicializada con el caracter espacio
                                          //para llevar a cabo la lectura
                                          //del primer caracter de la secuencia
                                          //a través del método buscarPalabra() la
                                          //primera vez que es llamado.
    //declaración atributo de objeto variable array de componentes caracter que representa
    //los caracteres de un objeto Palabra
    private char [] caracteres=new char[MAXIMO_NUMERO_CARACTERES];
    //declaración atributo de objeto variable entero que representa el número de caracteres
    //de un objeto Palabra
    private int numeroCaracteres;
    //declaración atributo de clase que posibilita representar el número
    //de linea de la secuencia de entrada (es 1 siempre)
    private static int lineaSecuencia=1;
    //declaración atributo de clase que posibilita representar el
    //número de la columna actual de lectura de la secuencia de entrada
    private static int columnaSecuencia=0;
    //declaración atributo de objeto que posibilita representar el número
    //de linea donde se encuentra el objeto Palabra 
    //Si el atributo linea de un objeto Palabra es 0 significará que
    //dicha palabra no se deriva de una secuencia o fichero
    private int linea=0;
    //declaración atributo de objeto que posibilita representar el
    //número de la columna donde comienza el objeto Palabra
    //Si el atributo columna de un objeto Palabra es 0 significará que
    //dicha palabra no se deriva de una secuencia o fichero
    private int columna=0;    
    
    //MÉTODOS
    
    //CONSTRUCTORES
    public Palabra() {
        numeroCaracteres=0;
    }
    
    //delaración constructor que posibilite la creación de un objeto Palabra
    //pasándole, a través de un parámetro String, los caracteres que
    //va a contener
    public Palabra(String dato) {
        //asignación de los caracteres del parámetro String dato al atributo
        //array caracteres con el método toCharArray
        caracteres=dato.toCharArray();
        //asignación del número de caracteres del parámetro String dato
        //a altributo numeroCaracteres
        numeroCaracteres=dato.length();
    }
    
    //MÉTODOS FUNCIONALES (describen el comportamiento de los objetos Palabra)
    
    //MÉTODO buscarPalabra QUE TIENE COMO OBJETIVO LA BÚSQUEDA DE UNA PALABRA
    //EN LA SECUENCIA DE CARACTERES DE ENTRADA. DICHA BÚSQUEDA SE BASA EN LA
    //LECTURA E IDENTIFICACIÓN DEL PRIMER CARACTER DE LA PALABRA
    private static void buscarPalabra() throws Exception {
        //leer siguiente caracter mientras el caracter leido no sea ni alfabético
        //ni final de secuencia ('.'), es decir, como el conjunto de caracteres
        //que entran en juego en el entorno de tratamiento secuencia son: los
        //caracteres alfabéticos minúsculas, es espacio en blanco y el '.', la
        //condición compuesta anterior es análoga a decir que hay que seguir leyendo
        //desde la secuencia mientras que el caracter leido sea espacio en blanco
        while (esSeparador(caracter)) {
            //lectura siguiente caracter de la secuencia
            caracter=LT.readCharacterLine();
            //actualización columna actual de lectura de la secuencia
            columnaSecuencia++;
        }
    }
    
    //MÉTODO hayPalabras QUE TIENE COMO OBJETIVO EL RESPONDER A LA PREGUNTA DE SI
    //HAY ALGUNA PALABRA EN LA SECUENCIA DE CARACTERES PARA LEER
    public static boolean hayPalabras() throws Exception {
        buscarPalabra();
        return (caracter!=FINAL_SECUENCIA);
    }
    
    //MÉTODO lectura QUE TIENE COMO OBJETIVO LA LECTURA DE UN OBJETO Palabra 
    //DESDE LA SECUENCIA DE CARACTERES DE ENTRADA.
    //NOTA: EL MÉTODO lectura SÓLO PODRÁ LLAMARSE DESPUÉS DE HABER LLAMADO AL
    //MÉTODO hayPalabras Y QUE SE HAYA VERIFICADO QUE HAY ALGUNA PALABRA PARA LEER
    //
    // VERSIÓN MÉTODO DE OBJETO
    //
    public void lectura() throws Exception {
        //inicializar a 0 el atributo numeroCaracteres del objeto Palabra que ha
        //llamado a este método y que será el obvjeto en el que vamos a almacenar
        //la palabra leida desde la secuencia
        numeroCaracteres=0;
        //declaración variable booleana para identificar si se ya se le ha
        //asignado al objeto Palabra la linea y columna
        boolean asignacionPosicion=false;
        
        //lectura y almacenamiento de los caracteres de la palabra leida desde
        //la secuencia de caracteres
        while ((caracter!=FINAL_SECUENCIA)&&(!esSeparador(caracter))) {
            if (!asignacionPosicion) {
                //Asignación al objeto Palabra linea y columna
                linea=lineaSecuencia;
                columna=columnaSecuencia;
                //actualizar variable control asignación
                asignacionPosicion=true;
            }
            //almacenar el caracter de la palabra leido en la componente
            //correspondiente del atributo array caracteres del objeto Palabra
            caracteres[numeroCaracteres]=caracter;
            //inrementar el atributo numeroCaracteres del objeto Palabra en una
            //unidad porque acabamos de almacenar el array caracteres un caracter
            //de la palabra
            numeroCaracteres++;
            //lectura siguiente caracter de la secuencia
            caracter=LT.readCharacterLine();
            //actualización columna actual de lectura de la secuencia
            columnaSecuencia++;
        } 
    }
    
    //MÉTODO lectura QUE TIENE COMO OBJETIVO LA LECTURA DE UN OBJETO Palabra 
    //DESDE LA SECUENCIA DE CARACTERES DE ENTRADA.
    //NOTA: EL MÉTODO lectura SÓLO PODRÁ LLAMARSE DESPUÉS DE HABER LLAMADO AL
    //MÉTODO hayPalabras Y QUE SE HAYA VERIFICADO QUE HAY ALGUNA PALABRA PARA LEER
    //
    // VERSIÓN MÉTODO DE CLASE
    //
    public static void lectura(Palabra pal) throws Exception {
        //inicializar a 0 el atributo numeroCaracteres del objeto Palabra que ha
        //llamado a este método y que será el obvjeto en el que vamos a almacenar
        //la palabra leida desde la secuencia
        pal.numeroCaracteres=0;
        
        //lectura y almacenamiento de los caracteres de la palabra leida desde
        //la secuencia de caracteres
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
            //almacenar el caracter de la palabra leido en la componente
            //correspondiente del atributo array caracteres del objeto Palabra
            pal.caracteres[pal.numeroCaracteres]=caracter;
            //inrementar el atributo numeroCaracteres del objeto Palabra en una
            //unidad porque acabamos de almacenar el array caracteres un caracter
            //de la palabra
            pal.numeroCaracteres++;
            //lectura siguiente caracter de la secuencia
            caracter=LT.readCharacterLine();
        }  
    }
    
    //MÉTODO toString que tiene como objetivo la conversión de un objeto Palabra en
    ///String con fines de ser utilizado con los métodos de visualización System.out.print
    //y System.out.println
    public String toString() {
        //DECLARACIÓN
        String temporal="";
        //añadir, por concxatenación, al String temporal los caracteres del objeto
        //palabra
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //concatenar al String temporal el caracter del objeto Palabra
            //que está almacenado en la componente indice-ésima del array
            //caracteres de dicho objeto
            temporal=temporal+caracteres[indice];
        }
        //devolver String resultante
        return temporal;
    }
    
    //MÉTODO toStringReverse que tiene como objetivo la conversión de un objeto Palabra en
    ///String de manera invertida con fines de ser utilizado con los métodos de visualización System.out.print
    //y System.out.println
    public String toStringReverse() {
        //DECLARACIÓN
        String temporal="";
        //añadir, por concatenación, al String temporal los caracteres del objeto
        //palabra
        for (int indice=numeroCaracteres-1;indice>=0;indice--) {
            //concatenar al String temporal el caracter del objeto Palabra
            //que está almacenado en la componente indice-ésima del array
            //caracteres de dicho objeto
            temporal=temporal+caracteres[indice];
        }
        //devolver String resultante
        return temporal;
    }
    
    //MÉTODO numeroVocales QUE TIENE COMO OBJETIVO EL OBTENER EL NÚMERO DE
    //VOCALES DE UN OVJETO PALABRA
    public int numeroVocales() {
        //DECLRACIONES
        int contador=0;
        //contabilizar el número der vocales de la palabra
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //verificar si el caracter contenido en la componente indice-ésima
            //del atriubuto array caracteres del objeto Palabra es una vocal
            if (esVocal(caracteres[indice])) {
                //incrementar contador de vocales
                contador++;
            }
        }
        //devolver contador de vocales
        return contador;
    }
    
    
    //MÉTODO numeroConsonantes QUE TIENE COMO OBJETIVO EL OBTENER EL NÚMERO DE
    //CARACTERES CONSONANTES DE UN OBJETO Palabra
    public int numeroConsonantes() {
        return (numeroCaracteres-numeroVocales());
    }
    
    //MÉTODO esVocal QUE TIENE COMO OBJETIVO VERIFICAR SI UN CARACTER, PASADO POR 
    //PARÁMETRO, ES UNA VOCAL
    private boolean esVocal(char car) {
        return ((car=='a')||(car=='e')||(car=='i')||(car=='o')||(car=='u'));
    }
    
    //MÉTODO numeroParDeCaracteres QUE TIENE COMO OBJETIVO VERIFICAR SI UN OBJETO
    //Palabra TIENE UN NÚMERO PAR DE CARACTERES
    public boolean numeroParDeCaracteres() {
        return (numeroCaracteres%2==0);
    }
    
    //MÉTODO esPalindromo QUE TIENE COMO OBJETIVO VERIFICAR SI UN OBJETO Palabra
    //ES UN PALÍNDROMO
    public boolean esPalindromo() {
        //DECLARACIONES
        //declaración indice entero para poder acceder a los caracteres de la palabra
        //desde el primero
        int ind_inicio=0;
        //declaración indice entero para poder acceder a los caracteres de la palabra
        //desde el final de la misma
        int ind_final=numeroCaracteres-1;
        
        //tratamiento para verificar las comparaciones de los caracteres que conforman
        //la palabra
        while ((caracteres[ind_inicio]==caracteres[ind_final])&&(ind_inicio<ind_final)) {
            //incrementar indice de inicio
            ind_inicio++;
            //decrementar indice de final
            ind_final--;            
        }
        //devolver resultado
        return (caracteres[ind_inicio]==caracteres[ind_final]);
    }
    
    //MÉTODO getMAXIMO_NUMERO_CARACTERES() QUE TIENE COMO OBJETIVO EL OBTENER
    //EL MÁXIMO NÚMERO DE CARACTERES QUE PUEDEN CONFORMAR UN OBJETO Palabra
    public static int getMAXIMO_NUMERO_CARACTERES() {
        return MAXIMO_NUMERO_CARACTERES;
    }
    
    //MÉTODO getNumeroCaracteres QUE TIENE COMO OBJETIBO EL OBTENER EL
    //NÚMERO DE CARACTERES DE UN OVJETO Palabra
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    //MÉTODO iguales QUE TIENE COMO OBJETIVO VERIFICAR SI UN OBJETO Palabra
    //ES IGUAL A OTRO OBJETO Palabra PASADO POR PARÁMETRO
    public boolean iguales(Palabra a) {
        //verificar si tienen el mismo número de caracteres
        if (numeroCaracteres==a.numeroCaracteres) {
            //verificar si son iguales a nivel de caracteres
            for (int indice=0;indice<numeroCaracteres;indice++) {
                //comparar los caracteres de ambas palabras que están en las
                //componentes indice-ésimas de los atributos arrays caracteres
                //de ambos objetos
                if (caracteres[indice]!=a.caracteres[indice]) {
                    //devolver el valor false porque ambas palabras son diferentes
                    //en cuanto que los dos caracteres que se acaban de comparar
                    //son diferentes
                    return false;
                }
            }
            //devolvervalor true porque ambas palabras son iguales
            return true;
        }
        else {
            //devolver el valor false porque las palabras son diferentes en cuanto
            //a que tienen un número de caracteres diferente
            return false;
        }
    }
    
    //MÉTODO copiar QUE TIENE COMO OBJETIO COPIAR UN OBJETO Palabra EN OTRO OBJETO
    //Palabra DADO PORPARÁMETRO
    public void copiar(Palabra a) {
        //copiar el atributo numeroCaracteres
        a.numeroCaracteres=numeroCaracteres;
        //copiar los caracteres del atributo array caracteres componente a componente
        for (int indice=0;indice<numeroCaracteres;indice++) {
            a.caracteres[indice]=caracteres[indice];
        }
    }
    
    //MÉTODO tieneLasCincoVocales QUE TIENE COMO OBJETIVO VERIFICAR SI UN OBJETO
    //Palabra TIENE 5 VOCALES Y ÉSTAS SON LAS CINCO VOCALES
    public boolean tieneLasCincoVocales() {
        //DECLARACIONES 
        //declaración array de componentes char para almacenar las 5 vocales
        final char [] VOCALES={'a','e','i','o','u'};
        //declraciín array de omponente enteras para almacenar las apariciones
        //de las vocales
        int [] apariciones={0,0,0,0,0};
        
        //TRATAMIENTO
        //verificación caracter a caracter del objeto Palabra si es vocal, y si
        //lo es incrementar su contador correspondiente
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //verificación si es una vocal el indice-ésimo caracter del objeto Palabra
            int i;
            for (i=0;((i<VOCALES.length)&&(caracteres[indice]!=VOCALES[i]));i++) {}
            if (i<VOCALES.length) {
                //incrementar contador de la vocal identificada
                apariciones[i]++;   
            }
        }
        //analizar resultado de las apariciones
        //Si todas las componentes del array apariciones tiene valor 1 significará
        //que en la palabra hay 5 vocales y éstas son las 5 vocales
        for (int indice=0;indice<apariciones.length;indice++) {
            if (apariciones[indice]!=1) {
                return false;
            }
        }
        return true;
    }
    
    //MÉTODO verificarTerminacion QUE TIENE COMO OBJETIVO VERIFICAR SI LA PALABRA
    //CONTENIDA EN UN OBJETO Palabra TERMINA CON LA TERMINACIÓN PASADA POR 
    //PARÁMETRO
    public boolean verificarTerminacion(String terminacion) {
        //DECLARACIONES
        
        //ACCIONES
        //verificar si la terminación tiene más caracteres que la palabra con
        //la que tenemos que contrastarla. Si fuese así estaría claro que
        //la palabra no termina con dicha terminación
        if (terminacion.length()<=numeroCaracteres) {
            //verificación caracter a caracter la terminación con los últimos
            //caracteres correspondientes de la palabra
            int indice1=numeroCaracteres-1; //indice para acceder a la componente del array caracteres
                                            //del objeto Palabra donde está el último caracter del
                                            //mismo
            int indice2=terminacion.length()-1;//Indice para acceder al último caracter del
                                            //String terminación.
            for (;(indice2>=0);indice2--) {
                //comparación del caracter indece2-ésimo del String terminación
                //con el caracter de la palabra que está en la componente indice1-ésima
                if (terminacion.charAt(indice2)!=caracteres[indice1]) {
                    //al no ser iguales conlleva que la palabra no termina con
                    //la terminación 
                    return false;
                }
                //decrementar indice1
                indice1--;
            }
            //al salir del for podemos dictaminar que la palabra termina con
            //la terminación pasada por parámetro
            return true;        
        }
        else {
            //la terminació al tener más caracteres que la palabra hace que 
            //se devuelva el valor false
            return false;
        }
    }
    
    //MÉTODO primerCaracterIgualUltimoCaracter LLEVA A CABO LA VERIFICACIÓN
    //DE SI EL PRIMER CARACTER DE UN OBJETO Palabra ES IGUAL AL ÚLTIMO
    //CARACTER DE OTRO OBJETO Palabra DADO POR PARÁMETRO
    public boolean primerCaracterIgualUltimoCaracter(Palabra a) {
        return (caracteres[0]==a.caracteres[a.numeroCaracteres-1]);
    }
    
    //MÉTODO contienePalabra LLEVA A CABO LA VERIFICACIÓN DE SI UN OBJETO Palabra
    //CONTIENE LA PALABRA PASADA POR PARÁMETRO
    public boolean contienePalabra(Palabra a) {
        //verificación que el objeto Palabra tiene un número de caracteres
        //igual o mayor a la palabra pasada por parámetro
        if (numeroCaracteres>=a.numeroCaracteres) {
            //verificación de si la palabra pasada por parámetro está contenida
            //en el objeto Palabra correspondiente
            for (int indice=0;indice<numeroCaracteres;indice++) {
                //verificar que el número de caracteres que restan por verificar del objeto
                //Palabra es mayor o igual que el número de caracteres de
                //la palabra a verificar que está contenida
                if ((numeroCaracteres-indice)>=a.numeroCaracteres) {
                    //declaración variable booleana para verificar si la palabra
                    //buscada está contenida en el objeto Palabra a partir del
                    //su caracter almacenado en la componente indice-ésima
                    boolean contenida=true;
                    for (int indice2=0;indice2<a.numeroCaracteres;indice2++) {
                        if (caracteres[indice+indice2]!=a.caracteres[indice2]) {
                            contenida=false;
                        }
                    }
                    //si la variable contenida sigue siendo true significará
                    //que el objeto Palabra contiene a la palabra dada por parámetro
                    if (contenida) {
                        return true;
                    }
                }
            }
            //una vez terminado el bucle de verificación podemos concluir que
            //el objeto Palabra NO contiene a la palabra dada por parámetro
            return false;
        }
        else {
            //el objeto Palabra no contiene a la palabra dada por parámetro porque
            //su número de caracteres es menor a la palabra dada
            return false;
        }
    }
    
    //MÉTODO esHeterograma LLEVA A CABO LA VERIFICACIÓN DE SI UN OBJETO Palabra
    //ES UNA PALABRA HETEROGRAMA, ES DECIR, QUE NO TIENE NINGÚN CARACTER REPETIDO
    public boolean esHeterograma() {
        //DECLARACIONES
        //declaración constante array de caracteres para almacenar todos los
        //caracteres alfabéticos minúsuculas que puede contener un objeto Palabra
        final char [] minusculas="abcdefghijklmnñopqrstuvwxyz".toCharArray();
        //declaración array de enteros para representar los contadores de aparición
        //en la palabra de los caracteres minúsculas. Este array estará en correspondencia
        //posicional con el array minusculas.
        int [] contadores=new int[minusculas.length];
        
        //ACCIONES
        //inicialización a 0 de todas las componentes del array contadores
        for (int indice=0;indice<contadores.length;indice++) {
            contadores[indice]=0;
        }
        
        //contabilizar la aparición de los caracteres del objeto Palabra en el
        //array contadores previa localización en el arra minusculas
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //buscar el caracter de la palabra de la componente indice-ésima
            //en el array minusculas
            int i; //declaración de la variable entera i para utilizarla como
                   //indice en el for de búsqueda y poderla utilizar fuera de éste
            for (i=0;caracteres[indice]!=minusculas[i];i++) {}
            //el valor de la variable i es la componente del array minusculas
            //donde hemos localizado al caracter de la palabtra buscado y por lo tanto
            //podemos incremetar la componente i-ésima del array contadores
            contadores[i]++;       
        }
        
        //una vez acabado el bucle de contabilización de las apariciones de los
        //cacacteres del objeto Palabra pòdemos ahora verificar que ninguno de ellos
        //ha aparecido más de una vez mirando que todas las componentes
        //del array contadores son 0 si el caracter alfabético correspondiente
        //no estaba en el objeto Palabra o es 1 si dicho caracter si estaba en el
        //objeto Palabra
        for (int indice=0;indice<contadores.length;indice++) {
            if (contadores[indice]>1) {
                //devolvemos false porque en la palabra hay, al menos,un caracter
                //que aparece más de una vez
                return false;
            }
        }
        //al finalizare el bucle podemos constatar que todos los caracteres de 
        //la palabra solo aparecen una vez, por lo tanto la palabra es un heterograma
        return true;
    }
    
  
    //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres]=caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }
    
    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    }

    //MÉTODO esSeparador VERIFICA SI EL CÓDIGO DE CARACTER DADO SE CORRESPONDE
    //CON UN CARACTER SEPARADOR
    private static boolean esSeparador(char car) {
        return ((car==ESPACIO));
    }    
    
    //MÉTODO putColumna LLEVA A CABO LA ESPECIFICACIÓN DE LA columna DONDE
    //COMIENZA UN OBJETO Palabra
    public void putColumna(int col) {
        columna=col;
    }

    //MÉTODO getColumna LLEVA A CABO LA OBTENCIÓN DE LA columna DONDE
    //COMIENZA UN OBJETO Palabra
    public int getColumna() {
        return columna;
    }  
    
    //MÉTODO putLinea LLEVA A CABO LA ESPECIFICACIÓN DE LA linea DONDE
    //SE ENCUENTRA UN OBJETO Palabra
    public void putLinea(int lin) {
        linea=lin;
    }   
    
    //MÉTODO getLinea LLEVA A CABO LA OBTENCIÓN DE LA linea DONDE
    //SE ENCUENTRA UN OBJETO Palabra
    public int getLinea() {
        return linea;
    }  
    
}
