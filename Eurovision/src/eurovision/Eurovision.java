package eurovision;

import java.util.Scanner;
import eurovision.rellenar_paises;

class Pais {

    String nom;
    int punts;
}

public class Eurovision {

    public static void main(String[] args) {
        //CREEM LIMIT PER ALS PAISOS CONCURSANTS
        final int LIMIT_PAISOS = 26;
        final int NUMERO_VOTS = 10;
        Pais[] pais = new Pais[LIMIT_PAISOS];
        int paisos_votats_X_pais[][] = new int[LIMIT_PAISOS][NUMERO_VOTS];
        int[] notes_the_best = new int[LIMIT_PAISOS];
        paisos_votats_X_pais = canviar_primera_array(paisos_votats_X_pais);
        int notes_posades_X_pais[][] = new int[LIMIT_PAISOS][NUMERO_VOTS];
        //FEM UN BUCLE PER INTRODUIR ELS NOMS DELS PAISOS
        for (int i = 0; i < pais.length; i++) {
            pais[i] = new Pais();
            pais[i].nom = rellenar_paises.omplir(); //FEM SERVIR DE MOMENT UNA FUNCIO PER OMPLIR ELS PAISOS AUTOMATICAMENT

            pais[i].punts = 0;
        }

        //FEM UN BUCLE PER A QUE CADA PAIS INTRODUEIXI NOTES
        for (int concursant = 0; concursant < pais.length; concursant++) {

            for (int i = 0; i < NUMERO_VOTS; i++) {
                int pais_seleccionat = pais_random(concursant, i, paisos_votats_X_pais); //FEM UNA FUNCIÓ PER A QUE EL PAIS QUE TOCA SELECCIONI UN PAIS DE FORMA ALEATORIA
                int nota_posada = nota_random(concursant, i, notes_posades_X_pais); //FEM UNA FUNCIÓ PER A QUE EL PAIS QUE TOCA SELECCIONI UNA NOTA DE FORMA ALEATORIA
                pais[pais_seleccionat].punts = pais[pais_seleccionat].punts + nota_posada; //FEM QUE EL PAIS QUE RETORNA LA PRIMERA FUNCIÓ SE LI SUMIN ELS PUNTS QUE RETORNA LA SEGONA FUNCIÓ
                if (nota_posada == 12) { //SI LA NOTA ÉS 12 FEM CRIDEM LA FUNCIÓ THE BEST
                    the_best(notes_the_best, pais_seleccionat);
                }
            }

        }

        ordenar_y_pintar(pais, notes_the_best); //FEM UNA FUNCIÓ PER A QUE ORDENI SEGONS ELS PUNTS I HO PINTI

    }

    //FUNCIÓ PER DEFINIR EL PAIS ALEATORI I QUE RETORNA EL PAIS DE FORMA NUMÈRICA
    static int pais_random(int pais, int posicio, int[][] paisos_votats) {
        final int NUMERO_VOTS = 10;
        boolean numero_correcte = false; //CREEM UN BOOLEÀ PER TRENCAR BUCLE
        int pais_random = 0; //INICIALITZEM EL PAIS RANDOM QUE ÉS EL QUE ES RETORNARÀ
        do {
            pais_random = num_random(0, 25); //ASIGNEM EL VALOR ALEATORI
            if (pais_random != pais) { //COMPROVEM QUE EL PAIS ALEATORI NO SIGUI EL MATEIX QUE EL CONCURSANT QUE ESTÀ VOTANT
                for (int i = 0; i < NUMERO_VOTS; i++) { //FEM UN BUCLE DE 0 A 10 PER COMPROVAR QUE NO HA VOTAT AL PAIS RANDOM SELECCIONAT
                    if (pais_random != paisos_votats[pais][i]) { //SI ES DIFERENT FUNCIONARÀ
                        numero_correcte = true;
                        paisos_votats[pais][i] = pais_random;
                    }
                }
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
            nota_random = num_random(0, 9); //ASSIGNEM EL VALOR ALEATORI
            for (int i = 0; i < NUMERO_VOTS; i++) { //FEM UN BUCLE PER COMPROVAR QUE AQUESTA NOTA NO HA ESTAT POSADA ABANS
                if (nota_random != notes_posades[pais][posicio]) { //SI LA POSICIÓ DE NOTA ÉS DIFERENT FUNCIONARÀ
                    numero_correcte = true;
                    notes_posades[pais][posicio] = nota_random;
                }
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

    //FUNCIO PER ORDENAR CADASCUNA DE LES LLISTES I PINTAR-LES DESPRÉS
    static void ordenar_y_pintar(Pais[] pais, int[] notes_the_best) {
        ordenar_pais(pais);
        ordenar_the_best(notes_the_best);
        pintar(pais, notes_the_best); //PINTEM FORMATEJAT CRIDANT UNA ALTRA FUNCIÓ
    }
    //FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
    static void ordenar_pais(Pais[] pais) {
        int i, j, aux;
        String aux_n;
        for (i = 0; i < pais.length - 1; i++) {
            for (j = 0; j < pais.length - i - 1; j++) {
                if (pais[j + 1].punts > pais[j].punts) {
                    aux = pais[j + 1].punts;
                    pais[j + 1].punts = pais[j].punts;
                    pais[j].punts = aux;

                    aux_n = pais[j + 1].nom;
                    pais[j + 1].nom = pais[j].nom;
                    pais[j].nom = aux_n;
                }
            }
        }
    }
    //FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
    static void ordenar_the_best(int[] the_best) {
        int i, j, aux;
        String aux_n;
        for (i = 0; i < the_best.length - 1; i++) {
            for (j = 0; j < the_best.length - i - 1; j++) {
                if (the_best[j + 1] > the_best[j]) {
                    aux = the_best[j + 1];
                    the_best[j + 1] = the_best[j];
                    the_best[j] = aux;
                }
            }
        }
    }

    static void pintar(Pais[] pais, int[] the_best) {
        for (int concursant = 0; concursant < (pais.length / 2); concursant++) { //FEM UN BUCLE DE 13 PER PINTAR EN DUES COLUMNES
            //UTILITZEM EL PRINTF PER FORMATAR LA SORTIDA
            System.out.printf("\n %3s %-20s %3s %10s %-20s %3s \n", (concursant + 1), pais[concursant].nom, pais[concursant].punts, (concursant + 14), pais[concursant + 13].nom, pais[concursant + 13].punts);

        }
        System.out.println("");
        boolean guanyador = true;
        boolean escrit = false;
        for (int i = 1; i < the_best.length; i++) {
            if (the_best[0] == the_best[i]) {
                if (escrit == false) {
                    System.out.print(pais[0].nom);
                    escrit = true;
                } else {
                    System.out.print( ", " + pais[i].nom);
                }

                guanyador = false;
            }

        }
        if (guanyador == true) {
            System.out.println("\nEl guanyador del premi TheBest és " + pais[0].nom + " amb " + the_best[0] + " vegades puntant 12.");
        } else if (guanyador == false) {
            System.out.println(" han guanyat el premi TheBest amb " + the_best[0] + " vegades puntant 12 cadascú.");
        }

    }
}