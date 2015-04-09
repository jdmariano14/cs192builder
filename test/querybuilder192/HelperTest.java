package querybuilder192;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Test
    public void testEncloseAlreadyEnclosed() {
        System.out.println("encloseAlreadyEnclosed");
        String in = "(subquery)";
        String enc1 = "(";
        String enc2 = ")";
        String expResult = "(subquery)";
        assertEquals(expResult, Helper.enclose(in, enc1, enc2));
        in = "subquery)";
        assertEquals(expResult, Helper.enclose(in, enc1, enc2));
        in = "(subquery";
        assertEquals(expResult, Helper.enclose(in, enc1, enc2));
    }
    
    @Test 
    public void testEncloseOneArgument() {
        System.out.println("encloseOneArgument");
        String in = "subquery";
        String enc = "!";
        String expResult = "!subquery!";
        String result = Helper.enclose(in, enc);
        assertEquals(expResult, result);
    }
    
}
