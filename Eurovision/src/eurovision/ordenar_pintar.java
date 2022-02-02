
package eurovision;


public class ordenar_pintar {

    //FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
    static void ordenar_pais(Pais[] pais) {
        int i;
        int j;
        int aux;
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

    static void pintar_guanyador_the_best(int[] the_best, Pais[] pais, int guanyador) {
        System.out.println("\nEl guanyador del premi TheBest \u00e9s " + pais[guanyador].nom + " amb " + the_best[guanyador] + " vegades puntant 12.");
    }

    static void pintar_guanyador_the_looser(int[] the_looser, Pais[] pais, int perdedor) {
        System.out.println("\nEl guanyador del premi TheLooser \u00e9s " + pais[perdedor].nom + " amb " + the_looser[perdedor] + " vegades puntant 0.");
    }

    static void puntuacio_general(Pais[] pais) {
        for (int concursant = 0; concursant < (pais.length / 2); concursant++) {
            //FEM UN BUCLE DE 13 PER PINTAR EN DUES COLUMNES
            //UTILITZEM EL PRINTF PER FORMATAR LA SORTID
            System.out.printf("\n %3s %-20s %3s %10s %-20s %3s \n", concursant + 1, pais[concursant].nom, pais[concursant].punts, concursant + 14, pais[concursant + 13].nom, pais[concursant + 13].punts);
        }
        System.out.println("");
    }

    static void puntuacio_pais(Pais[] pais, int[][] paisos_votats, int[][] notes_posades, int votant) {
        int i, j, aux, aux_n;
        for (i = 0; i < notes_posades.length - 1; i++) {
            for (j = 0; j < notes_posades[votant].length - i - 1; j++) {
                if (notes_posades[votant][j + 1] > notes_posades[votant][j]) {
                    aux = notes_posades[votant][j + 1];
                    notes_posades[votant][j + 1] = notes_posades[votant][j];
                    notes_posades[votant][j] = aux;
                    
                    aux_n = paisos_votats[votant][j + 1];
                    paisos_votats[votant][j + 1] = paisos_votats[votant][j];
                    paisos_votats[votant][j] = aux_n;
                }
            }
        }
        for (int d = 0; d < 10; d++) {
            System.out.printf("\n %-20s ha votat a %-20s amb una nota de %3s \n", pais[votant].nom, pais[paisos_votats[votant][d]].nom, notes_posades[votant][d]);
        }
        System.out.println("");
    }
}
