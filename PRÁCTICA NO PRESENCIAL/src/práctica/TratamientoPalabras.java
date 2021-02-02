/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

public class TratamientoPalabras {

 //   String[] palabras = new String[50];
    final char espacio = ' ';
    final char punto = '.';
    final char intro = '\n';
 //   int[] col = new int[200];
 //   int[] lin = new int[200];

    public void contadorPalabras(char[] letras) throws Exception {
        int i = 0, n = 0, contadorPalabras = 0, iterador = 0, iterador2 = 1, linia = 1;
        String palabra = "";
        
        Palabra palabra1 = new Palabra();
        

        while (letras[i] != punto) {

            //Contador linias fichero
            //lin[n] = linia;
            //palabra1.lin=linia;
            iterador++;

            if (letras[i] == intro) {
                linia++;
            }

            if (letras[i] != espacio && letras[i] != intro) {

                palabra = palabra + letras[i];

            } else if (letras[i] == intro || letras[i] == espacio) {

                //palabras[n] = palabra;
                //palabra1.caracteres=palabra.charAt(0);

                palabra = "";
                n++;
            }
            i++;

        }
        //palabras[n] = palabra;

        //System.out.println("Palabra1 "+ palabra1.caracteres);
/*
        //Tratamiento linia
        for (int x = 0; x < palabras.length; x++) {
            if (palabras[x] != null) {
                contadorPalabras++;
            }
        }

        return contadorPalabras;
        
        */
    }
//Metodo que muestra las palabras mas repetidas del fichero.
/*
    public void palabraMasRepetida() {

        String[] palabras2 = new String[50];
        int[] numeros = new int[50];
        boolean estaRepetida = true;
        int n = 0, z = 0, contador = 0, maxApariciones = 0, posicion = 0;

        //Bucle para crear array sin palabras repetidas
        for (int i = 0; i < palabras.length; i++) {

            while (n != palabras.length || estaRepetida == false) {

                 if (palabras[i] != null && palabras2[n]!=null ) {

                    System.out.print(palabras[i]);
                    System.out.print(palabras2[n]);
                    System.out.println();
                }
                /*
                if (palabras[i] == palabras2[n] && palabras[i] != null) {

                    System.out.println(palabras[i] + "==" + palabras2[n]);
                    //estaRepetida = false;
                    //break;

                }
                n++;
            }
            //Resetear variable
            n = 0;

            if (estaRepetida) {

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

    public void pintarPalabras() {
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i] != null) {
                System.out.println(palabras[i] + " " + lin[i]);
            }
        }
    }

    public void buscarPalabra() {
        System.out.println("Que palabra quieres buscar??");
        String n = LT.readLine();

        for (int i = 0; i < palabras.length; i++) {

            if (palabras[i] != null) {

                if (n == palabras[i]) {
                    System.out.println(" Ln " + lin[i] + " " + palabras[i]);

                }
            }
        }
    }*/

}
