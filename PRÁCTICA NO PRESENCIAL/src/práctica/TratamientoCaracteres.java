/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

/**
 *
 * @author Joan
 */
public class TratamientoCaracteres {
     
    public int contadorCaracteres(char[] letras) throws Exception {
        int caracteres = 0, i = 0;

        while (letras[i] != '.') {
            if (letras[i] != ' ') {
                caracteres++;
            }
            i++;
        }
        return caracteres;
    }
    
    public void tratamientoletraMasRepetida(char option,char[] letras) {
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

        if (option == '1') {
            System.out.println("maxRepeticiones " + maxRepeticiones + " Letra " + abecedario[posicionLetra]);
        } else if (option == '2') {
            for (int iterador2 = 0; iterador2 < abecedario.length; iterador2++) {
                System.out.println(abecedario[iterador2] + " " + repeticiones[iterador2]);
            }
        }

    }
    
    
    
}
