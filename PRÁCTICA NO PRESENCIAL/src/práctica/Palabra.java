/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

import java.util.ArrayList;
import java.util.Arrays;

public class Palabra {

    private char[] caracteres;
    private int numCaracteres;
    private int lin;
    private int col;
    private int numApariciones;

    //Get & Set
    public char[] getCaracteres() {
        return caracteres;
    }

    public int getLin() {
        return lin;
    }

    public int getNumApariciones() {
        return numApariciones;
    }

    public void setNumApariciones(int numApariciones) {
        this.numApariciones = numApariciones;
    }

    //Constructor vacio
    public Palabra() {
    }

    public Palabra(char[] dato1) {
        caracteres = dato1;
    }

    //Constructor con todos los atributos.
    public Palabra(char[] dato1, int dato2, int dato3, int dato4) {
        caracteres = dato1;
        numCaracteres = dato2;
        lin = dato3;
        col = dato4;
    }

    //Metodo crear objeto Palabra.
    public ArrayList<Palabra> crearPalabra(char[] letras) {
        ArrayList<Palabra> arrayObjetos = new ArrayList<>();
        int linia = 1, contador = 0, col = 1;
        char[] arrayTemporla = new char[20];

        for (int i = 0; i < letras.length; i++) {

            if (letras[i] == '\n') {
                linia++;
            }

            if (letras[i] >= 97 && letras[i] <= 122) {

                arrayTemporla[contador] = letras[i];
                contador++;
            } else if (arrayTemporla[0] >= 97 && arrayTemporla[0] <= 122) {
                Palabra pal = new Palabra();
                pal.caracteres = arrayTemporla;
                pal.numCaracteres = contador;
                pal.col = col;
                pal.lin = linia;
                arrayObjetos.add(pal);

                arrayTemporla = new char[50];
                contador = 0;
            }
            col++;
        }

        return arrayObjetos;
    }

    public void palabraMasRepetida(ArrayList<Palabra> arrayObjetos) {
        ArrayList<Palabra> arrayPalabras = new ArrayList<>();
        int repes = 0, apariciones = 0;
        boolean match = false;
        //for para crear ArrayList arrayPalabras sin palabras repetidas.
        for (int a = 0; a < arrayObjetos.size(); a++) {
            for (int b = 0; b < arrayPalabras.size(); b++) {
                if (Arrays.equals(arrayObjetos.get(a).caracteres, arrayPalabras.get(b).caracteres)) {
                    match = true;
                }
            }
            if (!match) {
                arrayPalabras.add((Palabra) arrayObjetos.get(a));
            }
            match = false;
        }

        //For para contar las repeticiones de las palabras.
        for (int c = 0; c < arrayPalabras.size(); c++) {
            for (int d = 0; d < arrayObjetos.size(); d++) {
                if (Arrays.equals(arrayObjetos.get(d).caracteres, arrayPalabras.get(c).caracteres)) {
                    repes++;
                }
            }
            arrayPalabras.get(c).setNumApariciones(repes);
            repes = 0;
        }

        for (int x = 0; x < arrayPalabras.size(); x++) {
            if (arrayPalabras.get(x).numApariciones > apariciones) {
                apariciones = x;
            }
        }

        System.out.println(arrayPalabras.get(apariciones).caracteres);
        System.out.println("Palabra " + arrayPalabras.get(apariciones).getNumApariciones());
    }

    public void buscarPalabra(ArrayList<Palabra> arrayObjetos) {
        System.out.println("Palabra a buscar?");
        String palabraBuscar = LT.readLine();
        int match = 0;

        for (int a = 0; a < arrayObjetos.size(); a++) {

            if (Arrays.equals(arrayObjetos.get(a).caracteres, palabraBuscar.toCharArray())) {
                System.out.println("MATCH");
                match = a;
            }

        }

        System.out.println("Palabra " + String.valueOf(arrayObjetos.get(match).getCaracteres()));


    }

    public void palabrasRepetidas(ArrayList<Palabra> arrayObjetos) {
        for (int i = 1; i < arrayObjetos.size(); i++) {

            if (Arrays.equals(arrayObjetos.get(i - 1).caracteres, arrayObjetos.get(i).caracteres)) {
                System.out.print("PALABRA ");
                System.out.println(arrayObjetos.get(i).caracteres);

                System.out.println("LINIA "+arrayObjetos.get(i).numCaracteres);
                System.out.println("COLUMNA "+arrayObjetos.get(i).col);

            }
        }

    }


}
