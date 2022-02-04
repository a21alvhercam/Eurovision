
package eurovision;


public class the_looser {
    
    static int the_looser(int[] notes_the_looser, int pais) {
        return notes_the_looser[pais]++;
    }

    static void trobar_the_looser(int[] the_looser, Pais[] pais) {
        System.out.println("");
        int puntuacio_minim = 10000;
        int posicio_minim = 0;
        for (int i = 0; i < the_looser.length; i++) {
            if (the_looser[i] < puntuacio_minim) {
                puntuacio_minim = the_looser[i];
                posicio_minim = i;
            }
        }
        boolean pintat = false;
        for (int i = 0; i < the_looser.length; i++) {
            if (the_looser[i] == puntuacio_minim) {
                if (pintat == false){
                    System.out.print(pais[i].nom);
                    pintat = true;
                }else{
                    System.out.print(", " + pais[i].nom);
                }
            }

        }

         System.out.print(" són els guanyadors del The Loser. \n");
    }
}
