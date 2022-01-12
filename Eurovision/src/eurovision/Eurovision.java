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
            System.out.println(pais[concursant].nom + " ha obtingut " + pais[concursant].punts + " punts.");
        }

    }

    //FUNCIÓ PER DEFINIR EL PAIS ALEATORI I QUE RETORNA EL PAIS DE FORMA NUMÈRICA
    static int pais_random(int pais, int posicio, int[][] paisos_votats) {

        boolean numero_correcte = false;

        int pais_random = 0;
        do {
            pais_random = (int) Math.floor(Math.random() * 25 + 1);
            if (pais_random != pais) {

                if (pais_random != paisos_votats[pais][posicio]) {

                    numero_correcte = true;
                    paisos_votats[pais][posicio] = pais_random;
                }
            }
        } while (numero_correcte == false);

        return pais_random;

    }

    static int nota_random(int pais, int posicio, int[][] notes_posades) {

        int result = 0;
        int notes[] = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12};
        boolean numero_correcte = false;
        int nota_random;

        do {
            nota_random = (int) Math.floor(Math.random() * 9 + 1);
            if (nota_random != notes_posades[pais][posicio]) {
                numero_correcte = true;
                notes_posades[pais][posicio] = nota_random;
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

    static int[][] ordenar(int[] array, String[]nom) {
        int i, j, aux;
        String aux_n;

        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;

                    aux_n = nom[j + 1];
                    nom[j + 1] = nom[j];
                    nom[j] = aux_n;
                }
            }
        }
    }
}

