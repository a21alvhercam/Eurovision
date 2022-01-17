/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eurovision;

import eurovision.Eurovision;

public class rellenar_paises {

    static String omplir() {
        String cadena = "";
        for (int t = 0; t < 4; t++) {
            char result = (char) Eurovision.num_random(65, 90);

            cadena = cadena + Character.toString(result);

        }

        return cadena;

    }
}