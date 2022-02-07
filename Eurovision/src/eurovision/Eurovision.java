package eurovision;

import Utils.ConsoleColors;
import java.util.logging.Level;
import java.util.logging.Logger;

class Pais {

    String nom;
    int punts;
}
/**
 * 
 * @author ausias
 */
public class Eurovision {

    public static final int NUMERO_VOTS = 10;
    public static final int LIMIT_PAISOS = 26;
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        boolean salir = false;
        Pais[] pais = new Pais[LIMIT_PAISOS];//Puntuacion general y nombre del pais
        int paisos_votats_X_pais[][] = new int[LIMIT_PAISOS][NUMERO_VOTS];//A quien ha votado cada pais
        int[] notes_the_best = new int[LIMIT_PAISOS];
        int[] notes_the_looser = new int[LIMIT_PAISOS];

        int notes_posades_X_pais[][] = new int[LIMIT_PAISOS][NUMERO_VOTS];//Puntuacion a quien ha votado cada pais

        //FEM UN BUCLE PER INTRODUIR ELS NOMS DELS PAISOS
        for (int i = 0; i < pais.length; i++) {
            pais[i] = new Pais();
            //pais[i].nom = Utils.utils.LlegirString("Digues el nom del pais: ");
            pais[i].nom = rellenar_paises.omplir(i);
        }

        do {
            for (int i = 0; i < pais.length; i++) {
                pais[i].punts = 0;
            }
            paisos_votats_X_pais = reset_matrius(paisos_votats_X_pais);
            notes_posades_X_pais = reset_matrius(notes_posades_X_pais);
            notes_the_best = reset_array(notes_the_best);
            notes_the_looser = reset_array(notes_the_looser);
           
            for (int concursant = 0; concursant < pais.length; concursant++) {//Bucle cada pais
                for (int i = 0; i < NUMERO_VOTS; i++) {//Por cada pais 10 veces
                    int pais_seleccionat = notes.pais_random(concursant, i, paisos_votats_X_pais);
                    int nota_posada = notes.nota_random(concursant, i, notes_posades_X_pais);
                    notes.afegir_nota(pais_seleccionat, nota_posada, pais);

                    the_looser.the_looser(notes_the_looser, pais_seleccionat);
                    if (nota_posada == 12) { //SI LA NOTA ÉS 12 FEM CRIDEM LA FUNCIÓ THE BEST
                        the_best.the_best(notes_the_best, pais_seleccionat);
                    }
                }
                ordenar_pintar.puntuacio_pais(pais, paisos_votats_X_pais, notes_posades_X_pais, concursant);

                ordenar_pintar.puntuacio_general(pais);
            }
            
            System.out.println("\n\n" + ConsoleColors.GREEN_BACKGROUND + "LES VOTACIONS HAN ACABAT... \n \n" + ConsoleColors.RESET);

            pausa(3000);
            the_best.trobar_the_best(notes_the_best, pais);
            pausa(3000);
            the_looser.trobar_the_looser(notes_the_looser, pais);
            pausa(3000);
            ordenar_pintar.ordenar_pais(pais);
            ordenar_pintar.puntuacio_general(pais);
            System.out.println(ConsoleColors.PURPLE_BOLD + "EL GUANYADOR D'EUROVISIÓ ÉS " + pais[0].nom.toUpperCase() + ConsoleColors.RESET);

        } while (!salir());

    }
    /**
     * 
     * @param temps 
     */
    static void pausa(int temps) {
        try {
            Thread.sleep(temps);
        } catch (InterruptedException ex) {
            Logger.getLogger(Eurovision.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @return 
     */
    static boolean salir() {
        boolean sortida;

        System.out.println("El programa finalitza aquí. "
                + "\nSi vols repetir el joc amb els mateixos noms escriu Si"
                + ",\nsi vols acabar el programa escriu No ");
        String str = Utils.utils.LlegirString("[S/n] ").toUpperCase();
        if (str.equals("S")) {
            sortida = false;
        } else {
            sortida = true;
        }

        return sortida;
    }
    /**
     * 
     * @param paisos_votats_X_pais
     * FUNCIÓ PER A QUE LA PRIMERA ARRAY DE LA MATRIU DELS PAISOS VOTATS TINGUI VALOR -1
     * FET PER A QUE QUAN EL RANDOM SELECCIONI EL PAIS 0 NO EL DETECTI COM A PAIS VOTAT PREVIAMENT JA QUE S'INICIALITZEN ELS VECTORS A 0
     * @return 
     */
    //
    static int[][] reset_matrius(int[][] paisos_votats_X_pais) {
        for (int[] paisos_votats_X_pai : paisos_votats_X_pais) {
            for (int j = 0; j < paisos_votats_X_pai.length; j++) {
                paisos_votats_X_pai[j] = -1;
            }
        }
        return paisos_votats_X_pais;
    }
    
    static int[] reset_array(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = 0;
        }
        return array;
    }
}
