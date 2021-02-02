/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Joan
 */
public class Linia {

    private char[] caracteres = new char[50];
    private int numeroCaracteres;
    private int linia;

    public ArrayList<Linia> crearObjetoLinia(char[] letras) {
        ArrayList<Linia> arrayLinia = new ArrayList<>();
        char[] liniaTemporal = new char[50];
        int linia = 1, contador = 0, contador2 = 0, numCaracteres = 0;

        for (int i = 0; i < letras.length; i++) {

            if (letras[i] == '\n' || letras[i] == '.') {

                //System.out.println();
                Linia lin = new Linia();
                lin.caracteres = liniaTemporal;
                lin.linia = linia;
                lin.numeroCaracteres = numCaracteres;
                arrayLinia.add(lin);
                contador2++;
                liniaTemporal = new char[50];
                contador = 0;
                linia++;
                numCaracteres = 0;

            } else if ((letras[i] >= 23 && letras[i] <= 122)) {
                liniaTemporal[contador] = letras[i];
                contador++;
                numCaracteres++;
            }

        }
        return arrayLinia;
    }

    public void buscarLinia(ArrayList<Palabra> arrayLinia) {
        System.out.println("Texto a buscar?");
        String texto = LT.readLine();
        int linia = 0;

        for (int a = 0; a < arrayLinia.size(); a++) {
            if (Arrays.equals(arrayLinia.get(a).getCaracteres(), texto.toCharArray())) ;
        }

        System.out.println(arrayLinia.get(linia).getCaracteres());
        System.out.println(arrayLinia.get(linia).getLin());
        System.out.println(arrayLinia.get(linia).getNumApariciones());

    }

}
