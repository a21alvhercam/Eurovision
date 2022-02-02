
package eurovision;

public class the_best {

    //FUNCIÓ PER FER EL PREMI THEBEST
    static int the_best(int[] notes_the_best, int pais) {
        return notes_the_best[pais]++;
    }

    //FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
    static int trobar_the_best(int[] the_best) {
        int puntuacio_maxim = 0;
        int posicio_maxim = 0;
        for (int i = 0; i < the_best.length; i++) {
            if (the_best[i] > puntuacio_maxim) {
                puntuacio_maxim = the_best[i];
                posicio_maxim = i;
            }
        }
        return posicio_maxim;
    }
    
}
