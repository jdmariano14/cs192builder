package querybuilder192;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueryBuilderTest {
    
    public QueryBuilderTest() {
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
     * Test of select method, of class QueryBuilder.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        String columns = "column1";
        QueryBuilder instance = (new QueryBuilder()).select(columns);
        String expResult = "SELECT";
        String result = instance.action;
        assertEquals(expResult, result);
        expResult = "column1";
        result = instance.columns;
        assertEquals(expResult, result);
    }
    
}
