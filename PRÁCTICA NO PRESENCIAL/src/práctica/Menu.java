/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

import java.util.ArrayList;

public class Menu {
    
    public static void main(String args[]) throws Exception {
        new Menu().programaPrincipal();
        
    }
    
    public void programaPrincipal() throws Exception {
        
        Datos datos = new Datos();
        Palabra palabras = new Palabra();
        Letra letra =new Letra();
        Linia lin=new Linia();
        Codificacion cod=new Codificacion();


        String fichero = datos.nombreFichero();
        char[] letras = datos.recogidaDatos(fichero);
        ArrayList arrayObjetos=palabras.crearPalabra(letras);
        Letra[] Objetoletras =letra.crearObjetosletra(letras);
        ArrayList arrayLinia = lin.crearObjetoLinia(letras);
        ArrayList<Palabra> arrayPalabras = palabras.crearPalabra(letras);


        System.out.println("Numero caracteres " + datos.contadorCaracteres(letras));
        System.out.println("Numero palabras " + arrayObjetos.size());
        System.out.println("Numero linias " + arrayLinia.size());
        
        boolean menu = false;
        
        while (!menu) {
            System.out.println("\n                     MENU ");
            System.out.println("OPCIÓN 1. Muestra la letra más repetida y su número de apariciones");
            System.out.println("OPCIÓN 2. Muestra el número de apariciones de cada carácter.");
            System.out.println("OPCIÓN 3. Muestra la palabra más repetida y su número de apariciones.");
            System.out.println("OPCIÓN 4. Busca una palabra.");
            System.out.println("OPCIÓN 5. Busca un texto.");
            System.out.println("OPCIÓN 6. Busca las palabras repetidas.");
            System.out.println("OPCIÓN 7. Codifica el fichero.");
            System.out.println("OPCIÓN 8. Establece la semilla de descodificaciónpara descodificar el fichero.");
            System.out.println("OPCIÓN 9. Salir.");
            
            char option = LT.readChar();
            
            switch (option) {
                case '1':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 1. Muestra la letra más repetida y su número de apariciones");
                    datos.recogidaDatos(fichero);
                    letra.letraMasRepetida(Objetoletras);
                    break;
                case '2':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 2. Muestra el número de apariciones de cada carácter.");
                    datos.recogidaDatos(fichero);
                    letra.repeticionesLetras(Objetoletras);
                    
                    break;
                case '3':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 3. Muestra la palabra más repetida y su número de apariciones.");
                    palabras.crearPalabra(letras);
                    palabras.palabraMasRepetida(arrayObjetos);
                    
                    break;
                case '4':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 4. Busca una palabra.");
                    palabras.crearPalabra(letras);
                    palabras.buscarPalabra(arrayPalabras);
                    break;
                case '5':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 5. Busca un texto.");
                    lin.crearObjetoLinia(letras);
                    lin.buscarLinia(arrayLinia);
                    break;
                case '6':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 6. Busca las palabras repetidas.");
                    palabras.palabrasRepetidas(arrayObjetos);
                    break;
                case '7':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 7. Codifica el fichero.");
                    cod.codificarfitchero(letras);
                    break;
                case '8':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 8. Establece la semilla de descodificaciónpara descodificar el fichero.");
                    break;
                case '9':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 9. Salir.");
                    menu = true;
                    break;
                default:
                    menu = true;
            }
            
        }
    }
    
    public void limpiar() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
}
