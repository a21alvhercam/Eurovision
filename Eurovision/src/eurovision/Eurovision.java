package eurovision;

import java.util.Scanner;

class Pais {

    String nom;
    int punts;
}

public class Eurovision {

    public static void main(String[] args) {
        //CREEM SCANNER 5
        Scanner s = new Scanner(System.in);
        //CREEM LIMIT PER ALS PAISOS CONCURSANTS
        final int LIMIT_PAISOS = 26;
        Pais[] pais = new Pais[LIMIT_PAISOS];
        int paisos_votats_X_pais[][] = new int[26][10];
        paisos_votats_X_pais = canviar_primera_array(paisos_votats_X_pais);
        int notes_posades_X_pais[][] = new int[26][10];
        //FEM UN BUCLE PER INTRODUIR ELS NOMS DELS PAISOS
        for (int i = 0; i < pais.length; i++) {
            pais[i] = new Pais();
            System.out.print("Digues el nom del pais: ");
            pais[i].nom = s.nextLine();
            pais[i].punts = 0;
        }

        //FEM UN BUCLE PER A QUE CADA PAIS INTRODUEIXI NOTES
        for (int concursant = 0; concursant < pais.length; concursant++) {
            for (int i = 0; i < 10; i++) {
                int pais_seleccionat = pais_random(concursant, i, paisos_votats_X_pais); //FEM UNA FUNCIÓ PER A QUE EL PAIS QUE TOCA SELECCIONI UN PAIS DE FORMA ALEATORIA
                int nota_posada = nota_random(concursant, i, notes_posades_X_pais); //FEM UNA FUNCIÓ PER A QUE EL PAIS QUE TOCA SELECCIONI UNA NOTA DE FORMA ALEATORIA
                pais[pais_seleccionat].punts = pais[pais_seleccionat].punts + nota_posada; //FEM QUE EL PAIS QUE RETORNA LA PRIMERA FUNCIÓ SE LI SUMIN ELS PUNTS QUE RETORNA LA SEGONA FUNCIÓ
            }

        }

        ordenar_y_pintar(pais); //FEM UNA FUNCIÓ PER A QUE ORDENI SEGONS ELS PUNTS I HO PINTI

    }

    //FUNCIÓ PER DEFINIR EL PAIS ALEATORI I QUE RETORNA EL PAIS DE FORMA NUMÈRICA
    static int pais_random(int pais, int posicio, int[][] paisos_votats) {
        boolean numero_correcte = false; //CREEM UN BOOLEÀ PER TRENCAR BUCLE
        int pais_random = 0; //INICIALITZEM EL PAIS RANDOM QUE ÉS EL QUE ES RETORNARÀ
        do {
            pais_random = num_random(0, 25); //ASIGNEM EL VALOR ALEATORI
            if (pais_random != pais) { //COMPROVEM QUE EL PAIS ALEATORI NO SIGUI EL MATEIX QUE EL CONCURSANT QUE ESTÀ VOTANT
                for (int i = 0; i < 10; i++) { //FEM UN BUCLE DE 0 A 10 PER COMPROVAR QUE NO HA VOTAT AL PAIS RANDOM SELECCIONAT
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
        int result = 0; //INICIALITZEM EL VALOR QUE RETORNAREM
        int notes[] = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12}; //EMMAGATZAMEM LES NOTES POSIBLES A TREURE
        //EL VALOR RANDOM ESTÀ ENTRE 0 I 9 PER DETERMINAR LA NOTA DINS DE LES POSICIONS DE L'ARRAY DE LA LINIA SUPERIOR
        boolean numero_correcte = false; //INICIALITZEM UN BOOLEÀ PER TRENCAR EL DO-WHILE
        int nota_random; //INICIALITZEM EL NUMERO RANDOM QUE ENS GENERARÀ
        do {
            nota_random = num_random(0, 9); //ASSIGNEM EL VALOR ALEATORI
            for (int i = 0; i < 10; i++) { //FEM UN BUCLE PER COMPROVAR QUE AQUESTA NOTA NO HA ESTAT POSADA ABANS
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

    static void ordenar_y_pintar(Pais[] pais) {
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
        pintar(pais);

    }

    static void pintar(Pais[] pais) {
        for (int concursant = 0; concursant < (pais.length / 2); concursant++) {
            if (concursant < 9) {
                System.out.println((concursant + 1) + ".  " + pais[concursant].nom + "  " + pais[concursant].punts + "          " + (concursant + 14) + ".  " + pais[concursant + 13].nom + "  " + pais[concursant + 13].punts);
            } else {
                System.out.println((concursant + 1) + ". " + pais[concursant].nom + "  " + pais[concursant].punts + "          " + (concursant + 14) + ".  " + pais[concursant + 13].nom + "  " + pais[concursant + 13].punts);

            }
        }
    }
}
