package querybuilder192;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
                "attr2 > 5",
                "",
                "");
        String expResult = "SELECT attr1, COUNT(attr2)" + Query.DELIMITER
                + "FROM table1" + Query.DELIMITER
                + "WHERE attr1 > 2" + Query.DELIMITER
                + "GROUP BY attr1" + Query.DELIMITER
                + "HAVING attr2 > 5";
        String result = instance.getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetSQLWhereOnly() {
        System.out.println("getSQLWhereOnly");
        Query instance = new Query("SELECT", 
                "attr1, COUNT(attr2)", 
                "table1", 
                "attr1 > 2", 
                "", 
                "",
                "",
                "");
        String expResult = "SELECT attr1, COUNT(attr2)" + Query.DELIMITER
                + "FROM table1" + Query.DELIMITER
                + "WHERE attr1 > 2";
        String result = instance.getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetSQLAs() {
        System.out.println("getSQLAs");
        Query instance = new Query("SELECT", 
                "attr1, COUNT(attr2)", 
                "table1", 
                "attr1 > 2", 
                "", 
                "",
                "",
                "subquery");
        String expResult = "(SELECT attr1, COUNT(attr2)" + Query.DELIMITER
                + "FROM table1" + Query.DELIMITER
                + "WHERE attr1 > 2) AS subquery";
        String result = instance.getSQL();
        assertEquals(expResult, result);
    }
    
}
