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
    
    @Test
    public void testFrom() {
        System.out.println("from");
        String columns = "column1";
        String table = "table1";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1";
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWhere() {
        System.out.println("where");
        String columns = "column1";
        String table = "table1";
        String where = "column2 < 69";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).where(where);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1"
                + Query.DELIMITER + "WHERE column2 < 69";
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGroupHaving() {
        System.out.println("group+having");
        String columns = "column1";
        String table = "table1";
        String group = "column1";
        String having = "column2 < 69";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).group(group).having(having);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1"
                + Query.DELIMITER + "GROUP BY column1"
                + Query.DELIMITER + "HAVING column2 < 69";
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrder() {
        System.out.println("order");
        String columns = "column1";
        String table = "table1";
        String order = "column1 ASC";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).order(order);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1"
                + Query.DELIMITER + "ORDER BY column1 ASC";
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAs() {
        System.out.println("as");
        String columns = "column1";
        String table = "table1";
        String as = "subquery";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).as(as);
        String expResult = "(SELECT column1"
                + Query.DELIMITER + "FROM table1) AS subquery";
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNaturalJoin() {
        System.out.println("natural_join");
        String columns = "column1";
        String table = "table1";
        String table2 = "table2";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).naturalJoin(table2);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1"
                + Query.DELIMITER + "NATURAL JOIN table2";
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testJoinOn() {
        System.out.println("natural_join");
        String columns = "column1";
        String table = "table1 T1";
        String table2 = "table2 T2";
        String on = "t1.col1 = t2.col1";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).joinOn(table2, on);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1 T1"
                + Query.DELIMITER + "JOIN table2 T2"
                + " ON " + on;
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testJoinUsing() {
        System.out.println("natural_join");
        String columns = "column1";
        String table = "table1 T1";
        String table2 = "table2 T2";
        String using = "col1";
        QueryBuilder instance = (new QueryBuilder()).select(columns).from(table).joinUsing(table2, using);
        String expResult = "SELECT column1"
                + Query.DELIMITER + "FROM table1 T1"
                + Query.DELIMITER + "JOIN table2 T2"
                + " USING " + using;
        String result = instance.build().getSQL();
        assertEquals(expResult, result);
    }
    
}
