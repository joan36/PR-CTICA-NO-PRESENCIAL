package práctica;


import java.io.FileReader;

public class Datos {

    //Variables globales
    char[] letras = new char[200];
    final int Final_Fitchero = -1;
    int CaracterASCII;


    public String nombreFichero() {
        System.out.println("Nombre del fitchero");
        return LT.readLine();
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

    public int contadorCaracteres(char[] letras) {
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
