
package eurovision;


public class ordenar_pintar {

    /**
     * 
     * @param pais 
     * FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
     */
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
    
    
    /**
     * 
     * @param pais 
     * FUNCIO PER ORDENAR LA PUNTUACIO UTILITZANT EL METODE BOMBOLLA
     */
    static void puntuacio_general(Pais[] pais) {
        for (int concursant = 0; concursant < (pais.length / 2); concursant++) {
            //FEM UN BUCLE DE 13 PER PINTAR EN DUES COLUMNES
            //UTILITZEM EL PRINTF PER FORMATAR LA SORTID
            System.out.printf("\n %3s %-20s %3s %10s %-20s %3s \n", concursant + 1, pais[concursant].nom, pais[concursant].punts, concursant + 14, pais[concursant + 13].nom, pais[concursant + 13].punts);
        }
        System.out.println("");
    }
    /**
     * 
     * @param pais
     * @param paisos_votats
     * @param notes_posades
     * @param votant 
     * ORDENEM TOTS EL VOTS DEL PAIS QUE ESTÀ VOTANT
     */
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
