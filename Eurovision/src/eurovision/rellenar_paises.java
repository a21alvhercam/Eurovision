/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eurovision;

public class rellenar_paises {
    /**
     * 
     * @param numero
     * @return 
     */
    static String omplir(int numero) {

        String[] pais = {"The Netherlands", "Italy", "Russia",
            "Switzerland", "Norway", "Sweden", "Azerbaijan",
            "North Macedonia", "Australia", "Iceland", "Czech Republic",
            "Denmark", "Slovenia", "France", "Cyprus", "Malta", "Serbia",
            "Albania", "Estonia", "San Marino", "Greece", "Spain", "Israel",
            "Germany", "Belarus", "United Kingdom"};

        return pais[numero];

    }

}
