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

    public char[] recogidaDatos(String nombre) throws Exception {
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
        return letras;
    }
    
}
