package práctica;

import java.io.FileReader;

public class PracticaPresencial {

    //Variables globales
    char[] letras = new char[50];
    final int DESPLAZAMIENTO = 1;
    final int Final_Fitchero = -1;
    int CaracterASCII;
    final char espacio = ' ';
    final char punto = '.';

    public static void main(String[] args) throws Exception {
        new PracticaPresencial().programaPrincipal();
    }

    public void programaPrincipal() throws Exception {

        System.out.println("Nombre del fitchero");
        String nombre = LT.readLine();

        recogidaDatos(nombre);

        System.out.println("Caracteres");
        System.out.println("Total caracteres fitchero   =   " + contadorCaracteres());

    }

    public void nombreFitchero() {
        System.out.println("Nombre del fitchero");
        String nombre = LT.readLine();

    }

    public void recogidaDatos(String nombre) throws Exception {
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
    }

    public int contadorCaracteres() throws Exception {
        int caracteres = 0;
        int i = 0;
        while (letras[i] != punto) {
            if (letras[i] != espacio) {
                caracteres++;
            }
            i++;
        }
        return caracteres;
    }
}
