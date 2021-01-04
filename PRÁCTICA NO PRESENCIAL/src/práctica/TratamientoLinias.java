
package práctica;

public class TratamientoLinias {
    
    public int numeroLinias(char[] letras) {
        int linias = 0;
        char intro = '\n';

        for (int i = 0; i < letras.length; i++) {

            if (letras[i] == intro) {
                linias++;
            }

        }
        return linias;

    }
}

