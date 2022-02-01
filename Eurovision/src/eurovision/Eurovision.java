package eurovision;

import java.util.Scanner;
import eurovision.rellenar_paises;

class Pais {

    String nom;
    int punts;
}

public class Eurovision {

    public static void main(String[] args) {
        boolean expResult = false;
        //CREEM LIMIT PER ALS PAISOS CONCURSANTS
        final int LIMIT_PAISOS = 26;
        final int NUMERO_VOTS = 10;
        Pais[] pais = new Pais[LIMIT_PAISOS];
        int paisos_votats_X_pais[][] = new int[LIMIT_PAISOS][NUMERO_VOTS];
        int[] notes_the_best = new int[LIMIT_PAISOS];
        int[] notes_the_looser = new int[LIMIT_PAISOS];
        paisos_votats_X_pais = canviar_primera_array(paisos_votats_X_pais);
        int notes_posades_X_pais[][] = new int[LIMIT_PAISOS][NUMERO_VOTS];
        //FEM UN BUCLE PER INTRODUIR ELS NOMS DELS PAISOS
        for (int i = 0; i < pais.length; i++) {
            pais[i] = new Pais();
            pais[i].nom = rellenar_paises.omplir(i); //FEM SERVIR DE MOMENT UNA FUNCIO PER OMPLIR ELS PAISOS AUTOMATICAMENT

            pais[i].punts = 0;
        }

        //FEM UN BUCLE PER A QUE CADA PAIS INTRODUEIXI NOTES
        for (int concursant = 0; concursant < pais.length; concursant++) {

            for (int i = 0; i < NUMERO_VOTS; i++) {
                int pais_seleccionat = pais_random(concursant, i, paisos_votats_X_pais); //FEM UNA FUNCIÓ PER A QUE EL PAIS QUE TOCA SELECCIONI UN PAIS DE FORMA ALEATORIA
                int nota_posada = nota_random(concursant, i, notes_posades_X_pais); //FEM UNA FUNCIÓ PER A QUE EL PAIS QUE TOCA SELECCIONI UNA NOTA DE FORMA ALEATORIA
                afegir_nota(pais_seleccionat, nota_posada, pais);

                the_looser(notes_the_looser, pais_seleccionat);
                if (nota_posada == 12) { //SI LA NOTA ÉS 12 FEM CRIDEM LA FUNCIÓ THE BEST
                    the_best(notes_the_best, pais_seleccionat);
                }
            }
            ordenar_pintar.puntuacio_pais(pais, paisos_votats_X_pais, notes_posades_X_pais, concursant);
            ordenar_pintar.ordenar_pais(pais);
            ordenar_pintar.puntuacio_general(pais); //PINTEM FORMATEJAT CRIDANT UNA ALTRA FUNCIÓ
        }

        int guanyador = trobar_the_best(notes_the_best);
        int perdedor = trobar_the_looser(notes_the_looser);
        ordenar_pintar.puntuacio_general(pais); //PINTEM FORMATEJAT CRIDANT UNA ALTRA FUNCIÓ
        ordenar_pintar.pintar_guanyador_the_best(notes_the_best, pais, guanyador);
        ordenar_pintar.pintar_guanyador_the_looser(notes_the_looser, pais, perdedor);

    }

    static int afegir_nota(int pais_seleccionat, int nota_posada, Pais[] pais) {
        return pais[pais_seleccionat].punts = pais[pais_seleccionat].punts + nota_posada; //FEM QUE EL PAIS QUE RETORNA LA PRIMERA FUNCIÓ SE LI SUMIN ELS PUNTS QUE RETORNA LA SEGONA FUNCIÓ
    }

    //FUNCIÓ PER DEFINIR EL PAIS ALEATORI I QUE RETORNA EL PAIS DE FORMA NUMÈRICA
    static int pais_random(int pais, int posicio, int[][] paisos_votats) {
        final int NUMERO_VOTS = 10;
        boolean numero_correcte = false; //CREEM UN BOOLEÀ PER TRENCAR BUCLE
        int pais_random = 0; //INICIALITZEM EL PAIS RANDOM QUE ÉS EL QUE ES RETORNARÀ
        do {
            numero_correcte = true;
            pais_random = num_random(0, 25); //ASIGNEM EL VALOR ALEATORI
            if (pais_random != pais) { //COMPROVEM QUE EL PAIS ALEATORI NO SIGUI EL MATEIX QUE EL CONCURSANT QUE ESTÀ VOTANT
                for (int i = 0; i < NUMERO_VOTS; i++) { //FEM UN BUCLE DE 0 A 10 PER COMPROVAR QUE NO HA VOTAT AL PAIS RANDOM SELECCIONAT
                    if (pais_random == paisos_votats[pais][i]) { //SI ES DIFERENT FUNCIONARÀ
                        numero_correcte = false;
                        
                    }
                }
            }
            if (numero_correcte == true){
                paisos_votats[pais][posicio] = pais_random;
            }
        } while (numero_correcte == false); //SI NO ES COMPLEIX L'IF NO ES TRENCARÀ EL BUCLE
        return pais_random;
    }

    //FUNCIÓ PER DEFINIR LA NOTA DE MANERA ALEATORIA
    static int nota_random(int pais, int posicio, int[][] notes_posades) {
        final int NUMERO_VOTS = 10;
        int result = 0; //INICIALITZEM EL VALOR QUE RETORNAREM
        int notes[] = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12}; //EMMAGATZAMEM LES NOTES POSIBLES A TREURE
        //EL VALOR RANDOM ESTÀ ENTRE 0 I 9 PER DETERMINAR LA NOTA DINS DE LES POSICIONS DE L'ARRAY DE LA LINIA SUPERIOR
        boolean numero_correcte = false; //INICIALITZEM UN BOOLEÀ PER TRENCAR EL DO-WHILE
        int nota_random; //INICIALITZEM EL NUMERO RANDOM QUE ENS GENERARÀ
        do {
            numero_correcte = true;
            nota_random = num_random(0, 9); //ASSIGNEM EL VALOR ALEATORI
            for (int i = 0; i < NUMERO_VOTS; i++) { //FEM UN BUCLE PER COMPROVAR QUE AQUESTA NOTA NO HA ESTAT POSADA ABANS
                if (notes[nota_random] == notes_posades[pais][i]) { //SI LA POSICIÓ DE NOTA ÉS DIFERENT FUNCIONARÀ
                    numero_correcte = false;
                    
                }
            }
            if (numero_correcte == true){
                notes_posades[pais][posicio] = notes[nota_random];
                
            }
        } while (numero_correcte == false); //ES REPETIRÀ EL BUCLE SI LA NOTA JA HA ESTAT POSADA ABANS
        result = notes[nota_random]; //LI DONEM EL VALOR DE LA POSICIÓ ALEATORIA AL RESULT I EL TORNEM
        return result;
    }

    static int num_random(int min, int max) {
        final int LIM_MAX = max; //IGUAL QUE A LA FUNCIÓ ANTERIOR FEM UN NUM RANDOM
        final int LIM_MIN = min; //ESTABLIM ELS LIMITS
        final int MARGEN = LIM_MAX - LIM_MIN + 1;
        int num = (int) (Math.random() * MARGEN) + LIM_MIN; //ASSIGNEM EL VALOR ALEATORI
        return num;
    }

    //FUNCIÓ PER A QUE LA PRIMERA ARRAY DE LA MATRIU DELS PAISOS VOTATS TINGUI VALOR -1
    //FET PER A QUE QUAN EL RANDOM SELECCIONI EL PAIS 0 NO EL DETECTI COM A PAIS VOTAT PREVIAMENT JA QUE S'INICIALITZEN ELS VECTORS A 0
    static int[][] canviar_primera_array(int[][] paisos_votats_X_pais) {
        for (int i = 0; i < paisos_votats_X_pais.length; i++) {
            for (int j = 0; j < paisos_votats_X_pais[i].length; j++) {
                paisos_votats_X_pais[0][j] = -1;
            }
        }
        return paisos_votats_X_pais;
    }

    //FUNCIÓ PER FER EL PREMI THEBEST
    static int the_best(int[] notes_the_best, int pais) {
        return notes_the_best[pais]++; //FEM QUE SI ARRIBA A AQUESTA FUNCIÓ LI SUMI UN AL PAIS QUE REP EL 12
    }

    static int the_looser(int[] notes_the_looser, int pais) {
        return notes_the_looser[pais]++;
    }

    //FUNCIO PER ORDENAR CADASCUNA DE LES LLISTES I PINTAR-LES DESPRÉS
    static void ordenar_y_pintar(Pais[] pais, int[] notes_the_best, int[] notes_the_looser) {

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

    static int trobar_the_looser(int[] the_looser) {
        int puntuacio_minim = 10000;
        int posicio_minim = 0;
        for (int i = 0; i < the_looser.length; i++) {
            if (the_looser[i] < puntuacio_minim) {
                puntuacio_minim = the_looser[i];
                posicio_minim = i;
            }
        }
        return posicio_minim;
    }

}
