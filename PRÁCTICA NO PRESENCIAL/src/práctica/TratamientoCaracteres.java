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
}
