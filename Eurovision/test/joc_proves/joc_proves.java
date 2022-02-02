/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc_proves;
//
import eurovision.Eurovision;
import eurovision.rellenar_paises;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class joc_proves {
    public joc_proves(){
    }
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Inici de les proves");
    }
    
    @AfterClass
    public static void tearDownClass(){
        System.out.println("Final del joc de proves");
    }
    
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test

    public void afegir_nota() {
        System.out.println("Comprovant que s'afegeix les notes...");
    }
    public void test_ordenacio() {
        System.out.println("Comprovant que s'ordena correctament les notes...");
        eurovision.ordenar_pintar instance = new eurovision.ordenar_pintar();
        int [] array = {2,1,4,3,6,5,8,7,9,10,12,11,14,13,16,15,18,17,19,20,22,21,26,25,24,23};
        int[] expResult = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int[] result = instance.ordenar_pais(array);
        assertEquals("Array ordenada", expResult, result);
    }
    public void pais_random() {
        System.out.println("Comprovant que tots els paisos tenen nom...");
    }

}
