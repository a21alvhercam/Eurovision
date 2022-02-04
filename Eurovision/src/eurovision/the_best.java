package eurovision;

public class the_best {

    //FUNCIÓ PER FER EL PREMI THEBEST
    static int the_best(int[] notes_the_best, int pais) {
        return notes_the_best[pais]++;
    }

    //FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
    static void trobar_the_best(int[] the_best, Pais[] pais) {
        int puntuacio_maxim = -1;
        int posicio_maxim = 0;
        for (int i = 0; i < the_best.length; i++) {
            if (the_best[i] > puntuacio_maxim) {
                puntuacio_maxim = the_best[i];
                posicio_maxim = i;

            }
        }
        
        boolean pintat = false;
        for (int i = 0; i < the_best.length; i++) {
            if (the_best[i] == puntuacio_maxim) {
                if (pintat == false){
                    System.out.print(pais[i].nom);
                    pintat = true;
                }else{
                    System.out.print(", " + pais[i].nom);
                }
            }

        }

         System.out.print(" són els guanyadors del The Best.\n");

    }

}
