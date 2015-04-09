/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querybuilder192;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JaymNico
 */
public class HelperTest {
    
    public HelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enclose method, of class Helper.
     */
    @Test
    public void testEnclose() {
        System.out.println("enclose");
        String in = "foobar";
        String enc1 = "(";
        String enc2 = ")";
        String expResult = "(foobar)";
        String result = Helper.enclose(in, enc1, enc2);
        assertEquals(expResult, result);
    }
    
}
