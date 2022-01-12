/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eurovision;

import java.util.Scanner;

/**
 *
 * @author ausias
 */
class Pais {

    String nom;
    int punts;
}

public class Eurovision {

    public static void main(String[] args) {
        //CREEM SCANNER 09909
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
                int pais_seleccionat = pais_random(concursant, i, paisos_votats_X_pais);
                int nota_posada = nota_random(concursant, i, notes_posades_X_pais);
                pais[pais_seleccionat].punts = pais[pais_seleccionat].punts + nota_posada;
            }

            //ordenar(pais);
            System.out.println(pais[concursant].nom + " ha obtingut " + pais[concursant].punts + " punts.");
        }
        System.out.println("\n****** \nSense ordenar \n****** \n");

        ordenar_y_pintar(pais);

    }

    //FUNCIÓ PER DEFINIR EL PAIS ALEATORI I QUE RETORNA EL PAIS DE FORMA NUMÈRICA
    static int pais_random(int pais, int posicio, int[][] paisos_votats) {
        final int LIMITRANNUMMAX = 25;
        final int LIMITRANNUMMIN = 0;
        final int RANG = LIMITRANNUMMAX - LIMITRANNUMMIN + 1;
        
        boolean numero_correcte = false;

        int pais_random = 0;
        do {
            pais_random = (int)(Math.random() * RANG) + LIMITRANNUMMIN;;
            if (pais_random != pais) {
                for (int i = 0; i < 10; i++) {
                    if (pais_random != paisos_votats[pais][posicio]) {

                        numero_correcte = true;
                        paisos_votats[pais][posicio] = pais_random;
                    }
                }

            }
        } while (numero_correcte == false);

        return pais_random;

    }

    static int nota_random(int pais, int posicio, int[][] notes_posades) {
        final int LIMITRANNUMMAX = 9;
        final int LIMITRANNUMMIN = 0;
        final int RANG = LIMITRANNUMMAX - LIMITRANNUMMIN + 1;
        int result = 0;
        int notes[] = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12};
        boolean numero_correcte = false;
        int nota_random;

        do {
            nota_random = (int)(Math.random() * RANG) + LIMITRANNUMMIN;
            for (int i = 0; i < 10; i++) {
                if (nota_random != notes_posades[pais][posicio]) {
                    numero_correcte = true;
                    notes_posades[pais][posicio] = nota_random;
                }
            }
        } while (numero_correcte == false);

        result = notes[nota_random];
        return result;
    }

    static int[][] canviar_primera_array(int[][] paisos_votats_X_pais) {
        for (int i = 0; i < paisos_votats_X_pais.length; i++) {
            for (int j = 0; j < paisos_votats_X_pais[i].length; j++) {
                paisos_votats_X_pais[0][j] = -1;
            }
        }
        return paisos_votats_X_pais;
    }

    static Pais[] ordenar_y_pintar(Pais[] pais) {
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
        for (int concursant = 0; concursant < pais.length; concursant++) {
            System.out.println(pais[concursant].nom + " ha obtingut " + pais[concursant].punts + " punts.");
        }
        return pais;
    }
}
