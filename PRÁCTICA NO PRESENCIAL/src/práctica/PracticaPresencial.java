package práctica;

import java.io.FileReader;

public class PracticaPresencial {

    //Variables globales
    char[] letras = new char[200];
    String[] palabras = new String[50];
    final int DESPLAZAMIENTO = 1;
    final int Final_Fitchero = -1;
    int CaracterASCII;
    final char espacio = ' ';
    final char punto = '.';

    public String nombreFichero() {
        System.out.println("Nombre del fitchero");
        String nombre = LT.readLine();
        return nombre;
    }

    public void recogidaDatos(String nombre) throws Exception {
        int contador = 0;

        FileReader fitchero;

        fitchero = new FileReader(nombre);
        CaracterASCII = fitchero.read();

        while (CaracterASCII != Final_Fitchero) {

            letras[contador] = ((char) CaracterASCII);
            CaracterASCII = fitchero.read();
            contador++;
        }

        fitchero.close();
    }

    public int contadorCaracteres() throws Exception {
        int caracteres = 0, i = 0;

        while (letras[i] != punto) {
            if (letras[i] != espacio) {
                caracteres++;
            }
            i++;
        }
        return caracteres;
    }

    public int contadorPalabras() throws Exception {
        int i = 0, n = 0, contadorPalabras = 0;
        String palabra = "";

        while (letras[i] != punto) {
            if (letras[i] == espacio) {
                i++;
                palabras[n] = palabra;
                palabra = "";
                n++;
            } else {
                palabra = palabra + letras[i];
                i++;
            }

        }
        palabras[n] = palabra;

        for (int x = 0; x < palabras.length; x++) {
            if (palabras[x] != null) {
                contadorPalabras++;
            }
        }

        return contadorPalabras;
    }

    public void tratamientoletraMasRepetida() {
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

        for (int iterador3 = 0; iterador3 < repeticiones.length; iterador3++) {
            if (repeticiones[iterador3] > maxRepeticiones) {
                maxRepeticiones = repeticiones[iterador3];
                posicionLetra = iterador3;
            }
        }
    }

    public void letraMaxRepeticiones(int maxRepeticiones, char[] abecedario, int posicionLetra) {
        System.out.println("maxRepeticiones " + maxRepeticiones + " Letra " + abecedario[posicionLetra]);
    }

    public void listaLetraMasRepetida(char[] abecedario, int[] repeticiones) {
        for (int iterador2 = 0; iterador2 < abecedario.length; iterador2++) {
            System.out.println(abecedario[iterador2] + " " + repeticiones[iterador2]);
        }
    }

    public void palabraMasRepetida() {

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
}
