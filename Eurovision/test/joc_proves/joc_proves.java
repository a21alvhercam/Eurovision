/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc_proves;
//
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
    public void rellenar_paises() {
        System.out.println("Comprovant que tots els paisos tenen nom...");
        
    }
    public void afegir_nota() {
        System.out.println("Comprovant que s'afegeix les notes...");
    }
    public void pais_random() {
        System.out.println("Comprovant que tots els paisos tenen nom...");
    }
    public void nota_random() {
        System.out.println("Comprovant que tots els paisos tenen nom...");
    }
}
