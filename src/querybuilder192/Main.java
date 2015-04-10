package querybuilder192;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        example1();
        example2();
    }
    
    /**
    * [EXAMPLE] Orders not yet shipped by given cut-off date
    * * Given: Cut-off Date (e.g., 1995-06-09)
    * * Output: Order ID, Customer, Required Date, Shipped Date
    * * Note: Include all orders that are not yet shipped, order must be created
    * *       before the cutoff date
    * *
    * * Expected query:
    * * 'SELECT "OrderID",
            "CompanyName" AS "Customer", 
            "RequiredDate" AS "Required Date",
            "ShippedDate" AS "Shipped Date"
        FROM orders
                NATURAL JOIN customers
        WHERE ("RequiredDate" < "1995-06-09"
                AND "ShippedDate" IS NULL)';
    */
    public static void example1() {
        System.out.println("Example 1:");
        System.out.println("");
        
        String select = "\"OrderID\",\n" +
            "\"CompanyName\" AS \"Customer\", \n" +
            "\"RequiredDate\" AS \"Required Date\",\n" +
            "\"ShippedDate\" AS \"Shipped Date\"";
        
        QueryBuilder builder = (new QueryBuilder())
                .select(select)
                .from("orders")
                .naturalJoin("customers")
                .where("\"RequiredDate\" < \"1995-06-09\" AND \"ShippedDate\" IS NULL");
        
        System.out.println(builder.build().getSQL());
        
    }
    
    /**
    * [EXAMPLE] Ranking of Customers by orders for a given year
    * * Given: year (e.g., 1995)
    * * Output: Customer ID, Company Name, Total Order Amount
    * * Customer ranking must be from highest to lowest order amount
    * 
    * * Expected query:
    * * SELECT "CustomerID" AS "Customer ID",
                   "CompanyName" AS "Company Name",			
                   SUM(OD."Quantity" * (OD."UnitPrice" - OD."UnitPrice" * OD."Discount")) AS "TotalOrderAmount"
           FROM (SELECT "OrderID", "CustomerID" 
                           FROM orders O 
                           WHERE EXTRACT(YEAR FROM "OrderDate") = 1995) AS subquery
                   NATURAL JOIN order_details OD
                   NATURAL JOIN customers C
           GROUP BY "CustomerID", "Company Name"
           ORDER BY "TotalOrderAmount" DESC
    */
    public static void example2() { 
        System.out.println("");
        System.out.println("Example 2:");
        System.out.println("");
        
        QueryBuilder subqueryBuilder = (new QueryBuilder())
                .select("OrderID\", \"CustomerID\"")
                .from("orders O")
                .where("EXTRACT(YEAR FROM \"OrderDate\") = 1995)")
                .as("subquery");
        String subquery = subqueryBuilder.build().getSQL();
        
        String sum = "SUM(OD.\"Quantity\" * (OD.\"UnitPrice\" - OD.\"UnitPrice\" * OD.\"Discount\")) AS \"TotalOrderAmount\"";
        
        String select = "\"CustomerID\" AS \"Customer ID\",\n" +
                        "\"CompanyName\" AS \"Company Name\",\n" +
                        sum;
        
        QueryBuilder builder = (new QueryBuilder())
                .select(select)
                .from(subquery)
                .naturalJoin("order_details OD")
                .naturalJoin("customers C")
                .group("\"CustomerID\", \"Company Name\"")
                .order("TotalOrderAmount DESC");
        
        System.out.println(builder.build().getSQL());
    }
    
}
