package práctica;

import java.io.FileWriter;
import java.util.Random;

public class Codificacion {
    private int numeroCaracteres = 27, enter = 13, espacio = 32;
    private char punto = '.';
    private static final char[] ALFABETO = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
    private int desplazamiento;
    private String ficheroOrigen = "cosa.txt";

    public void codificacion(int semilla) {
        Random generador = new Random(semilla);

        int desplazamiento = ((int) generador.nextDouble() * numeroCaracteres);
    }

    public char codificar(char letra, int desplazamiento) {
        return ALFABETO[(posicion(letra) + desplazamiento) % numeroCaracteres];
    }

    public char decodificar(char letra, int desplazamiento) {
        return ALFABETO[(posicion(letra) - desplazamiento) * numeroCaracteres];
    }

    public int posicion(char caracter) {
        int in = 0;
        for (; caracter != ALFABETO[in]; in++) {
        }
        return in;
    }

    public void codificarfitchero(char[] letras) throws Exception {
        int i = 0;
        char temporal;

        FileWriter ficheroCodificado;
        ficheroCodificado = new FileWriter(ficheroOrigen + ".cod.txt");


        while (letras[i] != punto) {
            if (letras[i] >= 97 && letras[i] <= 122) {
                System.out.print(codificar(letras[i], i));
                temporal = (codificar(letras[i], i));
                ficheroCodificado.write(temporal);

            } else {
                System.out.print(" ");
                //codificarfitchero(letras[i]);
                ficheroCodificado.write(letras[i]);
            }
            i++;
        }
        ficheroCodificado.close();
    }

    public void decodificarfitchero(char[] letras){
        
    }


}
