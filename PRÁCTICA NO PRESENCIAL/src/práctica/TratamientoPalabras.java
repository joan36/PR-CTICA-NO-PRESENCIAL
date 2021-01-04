/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

public class TratamientoPalabras {

    String[] palabras = new String[50];
    final char espacio = ' ';
    final char punto = '.';

    public int contadorPalabras(char[] letras) throws Exception {
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
//Metodo que muestra las palabras mas repetidas del fichero.
    public void palabraMasRepetida() {

        String[] palabras2 = new String[50];
        int[] numeros = new int[50];
        boolean estaRepetida = true;
        int n = 0, z = 0, contador = 0, maxApariciones = 0, posicion = 0;

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
                if (numeros[i] > maxApariciones) {
                    maxApariciones = numeros[i];
                    posicion = i;
                }
            }

        }
        System.out.println(palabras2[posicion] + " " + numeros[posicion]);
    }
}
