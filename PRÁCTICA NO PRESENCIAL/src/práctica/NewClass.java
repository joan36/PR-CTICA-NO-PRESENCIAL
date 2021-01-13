package práctica;

public class NewClass {
     
    
    public static void main(String[] args) throws Exception {
        final char espacio = ' ';
        final char punto = '.';
        final char intro = '\n';
        int[] col = new int[200];
        int[] lin = new int[200];        
        String[] palabras=new String[200];
        char[] letras={'h','o','l','a',' '};
        

        int i = 0, n = 0, contadorPalabras = 0, iterador = 1, iterador2 = 1;
        String palabra = "";

       /* while (letras[i] != punto) {

            if (letras[i] != espacio) {

                palabra = palabra + letras[i];
                i++;

            } else {

                i++;
                palabras[n] = palabra;

                palabra = "";
                n++;
            }

        }
        palabras[n] = palabra;*/

        
        for (int x = 0; x < palabras.length; x++) {
            System.out.print(letras[x]);
        }

    }

    public void palabra3() {

        String[] palabras = {"Volvo", "BMW", "Ford", "Mazda", "Ford", "BMW", "Ford",};

        System.out.println("Introducir palabra");
        String palabra = LT.readLine();

        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabra + " = " + palabras[i]);
            if (palabra == palabras[i]) {
                System.out.println(palabra + " = " + palabras[i]);
            }
        }

    }

    public void palabra2() {

        String[] palabras = {"Volvo", "BMW", "Ford", "Mazda", "Ford", "BMW", "Ford",};

        System.out.println("Introducir palabra");
        String palabra = LT.readLine();

        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabra + " = " + palabras[i]);
            if (palabra == palabras[i]) {
                System.out.println(palabra + " = " + palabras[i]);
            }
        }

    }

    public void palabra() {

        String[] palabras = {"Volvo", "BMW", "Ford", "Mazda", "Ford", "BMW", "Ford",};
        String[] palabras2 = new String[50];
        int[] numeros = new int[50];
        boolean estaRepetida = true;
        int n = 0, z = 0, contador = 0;

        //Bucle para crear array sin palabras repetidas
        for (int i = 0; i < palabras.length; i++) {

            while (n != palabras.length || estaRepetida == false) {

                if (palabras[i] == palabras2[n]) {

                    estaRepetida = false;
                    break;
                }
                n++;
            }
            //Resetear variable
            n = 0;

            if (estaRepetida != false) {

                palabras2[z] = palabras[i];
                z++;
            }

        }
        //Bucle para contar el número de repeticiones por palabra
        for (int i = 0; i < palabras.length; i++) {

            while (n != palabras.length) {
                //System.out.println(palabras[i] + " " + palabras[n]);
                if (i != n && palabras2[i] == palabras[n]) {

                    contador++;
                }
                n++;
            }
            n = i;
            numeros[i] = contador;
            //Resetear variable
            contador = 0;
        }
        //Bucle para pintar las palabras y sus repeticiones
        for (int i = 0; i < palabras.length; i++) {

            if (palabras2[i] != null) {
                System.out.println(palabras2[i] + " " + numeros[i]);
            }

        }

    }

    public void letraMasRepetida() {
        char[] letras = {'a', 'a', 'e', ' ', 'u', 'v', 'a', 'e', ' ', 'e', 'e', ' ', 'u', ' ', 'v', 'a', 'e', 'u', 'v', 'a', 'a', 'e', 'u', 'v', 'a', 'e', 'e', 'e', 'u', 'v', 'a', 'e', 'u', 'v', 'a', 'a', 'e', 'u', 'v', 'a', 'e', 'e', 'e', 'u', 'v', 'a', 'e', 'u', 'v', 'a', 'a', 'e', 'u', 'v', 'a', 'e', 'e', 'e', 'u', 'v', 'a', 'e', 'u', 'v', 'a', 'a', 'e', 'u', 'v', 'a', 'e', 'e', 'e', 'u', 'v', 'a', 'e', 'u', 'v', '.'};
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] repeticiones = new int[27];
        int letraMasRepetida = 0, contador = 0, maxRepeticiones = 0, posicionLetra = 0;

        //Bucle que cuenta los caracteres más repetidos y los almacena en array
        for (int iterador = 0; iterador < repeticiones.length; iterador++) {

            while (letras[contador] != '.') {

                if (abecedario[iterador] == letras[contador]) {
                    letraMasRepetida++;
                }
                contador++;
            }
            repeticiones[iterador] = letraMasRepetida;
            contador = 0;
            letraMasRepetida = 0;
        }

        for (int iterador2 = 0; iterador2 < abecedario.length; iterador2++) {
            System.out.println(abecedario[iterador2] + " " + repeticiones[iterador2]);
        }

        for (int iterador3 = 0; iterador3 < repeticiones.length; iterador3++) {
            if (repeticiones[iterador3] > maxRepeticiones) {
                maxRepeticiones = repeticiones[iterador3];
                posicionLetra = iterador3;
            }
        }
        System.out.println("maxRepeticiones " + maxRepeticiones + " Letra " + abecedario[posicionLetra]);

    }
}
