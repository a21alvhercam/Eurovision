package eurovision;

import Utils.utils;

public class notes {
    /**
     * 
     * @param pais_seleccionat
     * @param nota_posada
     * @param pais
     * @return 
     */
    static int afegir_nota(int pais_seleccionat, int nota_posada, Pais[] pais) {
        return pais[pais_seleccionat].punts = pais[pais_seleccionat].punts + nota_posada; //FEM QUE EL PAIS QUE RETORNA LA PRIMERA FUNCIÓ SE LI SUMIN ELS PUNTS QUE RETORNA LA SEGONA FUNCIÓ
    }

    /**
     * 
     * @param pais
     * @param posicio
     * @param paisos_votats
     * FUNCIÓ PER DEFINIR EL PAIS ALEATORI I QUE RETORNA EL PAIS DE FORMA NUMÈRICA
     * @return 
     */
    static int pais_random(int pais, int posicio, int[][] paisos_votats) {
        boolean numero_correcte = false; //CREEM UN BOOLEÀ PER TRENCAR BUCLE
        int pais_random = 0; //INICIALITZEM EL PAIS RANDOM QUE ÉS EL QUE ES RETORNARÀ
        do {
            numero_correcte = true;
            pais_random = utils.num_random(0, 25);
            if (pais_random != pais) {
                //COMPROVEM QUE EL PAIS ALEATORI NO SIGUI EL MATEIX QUE EL CONCURSANT QUE ESTÀ VOTANT
                for (int i = 0; i < Eurovision.NUMERO_VOTS; i++) {
                    //FEM UN BUCLE DE 0 A 10 PER COMPROVAR QUE NO HA VOTAT AL PAIS RANDOM SELECCIONAT
                    if (pais_random == paisos_votats[pais][i]) {
                        //SI ES DIFERENT FUNCIONARÀ
                        numero_correcte = false;
                    }
                }
                if (numero_correcte == true) {
                    paisos_votats[pais][posicio] = pais_random;
                }

            } else {
                numero_correcte = false;
            }
        } while (numero_correcte == false); //SI NO ES COMPLEIX L'IF NO ES TRENCARÀ EL BUCLE
        return pais_random;
    }

    /**
     * 
     * @param pais
     * @param posicio
     * @param notes_posades
     * FUNCIÓ PER DEFINIR LA NOTA DE MANERA ALEATORIA
     * @return 
     */
    static int nota_random(int pais, int posicio, int[][] notes_posades) {
        int result = 0; //INICIALITZEM EL VALOR QUE RETORNAREM
        int[] notes = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12}; //EMMAGATZAMEM LES NOTES POSIBLES A TREURE
        //EL VALOR RANDOM ESTÀ ENTRE 0 I 9 PER DETERMINAR LA NOTA DINS DE LES POSICIONS DE L'ARRAY DE LA LINIA SUPERIOR
        boolean numero_correcte = true; //INICIALITZEM UN BOOLEÀ PER TRENCAR EL DO-WHILE
        int nota_random; //INICIALITZEM EL NUMERO RANDOM QUE ENS GENERARÀ
        do {
            numero_correcte = true;
            nota_random = utils.num_random(0, 9); //ASSIGNEM EL VALOR ALEATORI
            for (int i = 0; i < Eurovision.NUMERO_VOTS; i++) {
                //FEM UN BUCLE PER COMPROVAR QUE AQUESTA NOTA NO HA ESTAT POSADA ABANS
                if (notes[nota_random] == notes_posades[pais][i]) {
                    //SI LA POSICIÓ DE NOTA ÉS DIFERENT FUNCIONARÀ
                    numero_correcte = false;
                }
            }
            if (numero_correcte == true) {
                notes_posades[pais][posicio] = notes[nota_random];
            }
        } while (numero_correcte == false); //ES REPETIRÀ EL BUCLE SI LA NOTA JA HA ESTAT POSADA ABANS
        result = notes[nota_random]; //LI DONEM EL VALOR DE LA POSICIÓ ALEATORIA AL RESULT I EL TORNEM
        return result;
    }

}
