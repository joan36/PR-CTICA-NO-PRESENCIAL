/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica;

public class CodificacionYMenu {

    public static void main(String args[]) throws Exception {
        new CodificacionYMenu().programaPrincipal();
        
    }

    public void programaPrincipal() throws Exception {
        
        
        
        PracticaPresencial nombre = new PracticaPresencial();
        TratamientoCaracteres caracter = new TratamientoCaracteres();
        TratamientoPalabras palabra = new TratamientoPalabras();
        TratamientoLinias linia= new TratamientoLinias();
        
        //Lectura nombreFichero texto
        //String fichero =nombre.nombreFichero();
        String fichero="cosa.txt";
        char[] letras=nombre.recogidaDatos(fichero);
       
        //Recogida datos fichero.
        //nombre.recogidaDatos(fichero);
        
        System.out.println("Numero caracteres "+caracter.contadorCaracteres(letras));
        System.out.println("Numero palabras "+palabra.contadorPalabras(letras));
        System.out.println("Numero linias "+linia.numeroLinias(letras));
        
     
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
                    nombre.recogidaDatos(fichero);
                    caracter.tratamientoletraMasRepetida(option, nombre.recogidaDatos(fichero));
                   
                    break;
                case '2':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 2. Muestra el número de apariciones de cada carácter.");
                    nombre.recogidaDatos(fichero);
                    caracter.tratamientoletraMasRepetida(option, nombre.recogidaDatos(fichero));
                   
                    break;
                case '3':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 3. Muestra la palabra más repetida y su número de apariciones.");
                    palabra.palabraMasRepetida();
                    break;
                case '4':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 4. Busca una palabra.");
                    palabra.buscarPalabra();
                    break;
                case '5':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 5. Busca un texto.");
                    break;
                case '6':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 6. Busca las palabras repetidas.");
                    break;
                case '7':
                    limpiar();
                    System.out.println("HAS ELEGIDO LA OPCIÓN 7. Codifica el fichero.");
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
