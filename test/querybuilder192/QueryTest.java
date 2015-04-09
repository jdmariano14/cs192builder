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
public class QueryTest {
    
    public QueryTest() {
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
     * Test of getSQL method, of class Query.
     */
    @Test
    public void testGetSQL() {
        System.out.println("getSQL");
        Query instance = new Query("SELECT", 
                "attr1, COUNT(attr2)", 
                "table1", 
                "attr1 > 2", 
                "attr1", 
                "attr2 > 5");
        String expResult = "SELECT attr1, COUNT(attr2) "
                + "FROM table1 "
                + "WHERE attr1 > 2 "
                + "GROUP BY attr1 "
                + "HAVING attr2 > 5";
        String result = instance.getSQL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
