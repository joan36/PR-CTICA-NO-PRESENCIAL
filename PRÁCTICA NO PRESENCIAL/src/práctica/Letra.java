/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

/**
 * @author Joan
 */
public class Letra {

    private char letra;
    private int repeticiones;

    public Letra[] crearObjetosletra(char[] letras) {

        Letra[] Objetoletras = new Letra[50];
        char[] caracteres = new char[50];
        int cont = 0, i = 0, cont2 = 0;
        boolean match = false;

        //While filtrado de caracteres del array letras.
        while (letras[i] != '.') {

            //Filtro ASCII
            if (letras[i] >= 97 && letras[i] <= 122) {
                //System.out.print(letras[i]);

                for (int z = 0; z < caracteres.length; z++) {

                    if (letras[i] == caracteres[z] && letras[i] != ' ') {
                        match = true;
                    }
                }
                //System.out.println(match);
                if (!match) {

                    caracteres[cont] = letras[i];
                    cont++;
                }
                match = false;
            }

            i++;
        }
        //For que crea el objeto letra y cuenta numero de apariciones.
        for (int z = 0; z < caracteres.length; z++) {

            if (caracteres[z] >= 97 && caracteres[z] <= 122) {
                Letra let = new Letra();

                //System.out.println(caracteres[z]);
                let.letra = caracteres[z];

                for (int w = 0; w < letras.length; w++) {
                    if (let.letra == letras[w]) {
                        cont2++;
                    }
                }
                let.repeticiones = cont2;
                Objetoletras[z] = let;
                cont2 = 0;

            }
        }

        return Objetoletras;
    }

    //Metodo pintar letra mas repetida.
    public void letraMasRepetida(Letra[] Objetoletras) {
        int cont3 = 0, posicion = 0, y = 0;

        while (Objetoletras[y] != null) {
            if (Objetoletras[y].repeticiones > cont3) {
                cont3 = Objetoletras[y].repeticiones;
                posicion = y;
            }
            y++;
        }

        System.out.println("Letra mas repetida " + Objetoletras[posicion].letra + " Numero repeticiones " + Objetoletras[posicion].repeticiones);
        System.out.println();
    }

    //Metodo pintar letras y su numero de apariciones.
    public void repeticionesLetras(Letra[] Objetoletras) {
        int y = 0;

        while (Objetoletras[y] != null) {
            System.out.println("Letra " + Objetoletras[y].letra + " Numero repeticiones " + Objetoletras[y].repeticiones);
            y++;
        }

    }

}
