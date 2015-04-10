package querybuilder192;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        example1();
        example2();
        // item1();
        // item2();
        // item3();
        // item4();
        // item5();
    }
    
    // ****************************************
    // Items
    // ****************************************
    
    /** 
    * [ITEM 1] No. of Shipment per Country
    * * Output: Country, No. of Shipment (delivered orders)
    * * Sort alphabetically by Country
    * 
    * * Expected query:
    * * SELECT "ShipCountry" AS "Country",
                COUNT("ShippedDate") AS "No. of Shipment"
            FROM orders
            GROUP BY "ShipCountry"
            ORDER BY "ShipCountry" ASC
    */
    public static void item1() {
    }
            
    /**
    * [ITEM 2] Ranking of Employees by sales for a given year
    * * Given: year (e.g., 1995)
    * * Output: Employee, Sales
    * * Employee ranking must be from highest to lowest sales
    * * Clue: You have to use SUM and ORDER BY
    * 
    * * Expected query:
    * * SELECT "LastName" || $$, $$ || "FirstName" AS "Name", 
                SUM(OD."Quantity" * (OD."UnitPrice" - OD."UnitPrice" * OD."Discount")) AS "Sales"
            FROM employees 
            NATURAL JOIN (SELECT "OrderID", "EmployeeID"
                FROM orders
                WHERE EXTRACT(YEAR FROM "ShippedDate") = ?) AS O
            NATURAL JOIN order_details OD
            GROUP BY "FirstName", "LastName"
            ORDER BY "Sales"
    */
    public static void item2() {
    }
    
    /** 
    * [ITEM 3] Summary of Product Sales given a date range.
    * * Given: start date, end date
    * * Output: Category, Product, Sales
    * * Sort by Category; for each Category sort product sales from highest to
    *   lowest sales
    */
    public static void item3() {
    }
    
    /** 
    * [ITEM 4] 
    * No. of Products Per Category and most expensive product Per Category
    * * Output: Category ID, Category Name, No. of Products, Product, Unit Price
    * * Sort by Unit Price (from highest to lowest) 
    */
    public static void item4() {
    }
    
    /**
    * [ITEM 5] Biggest Sale per Employee
    * * Output: Employee, Order ID, Customer, Order Amount, Order Date, Ship Date
    * * Clue: An order is already shipped if ShippedDate is not null.
    * * Sales = sum of unitprice * (1 - discount) * quantity per product ordered
    */
    public static void item5() {
    }
    
    // ****************************************
    // Examples
    // ****************************************
    
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
        
        QueryBuilder builder = (new QueryBuilder())
                .select("\"OrderID\"")
                .select("\"CompanyName\" AS \"Customer\"")
                .select("\"RequiredDate\" AS \"Required Date\"")
                .select("\"ShippedDate\" AS \"Shipped Date\"")
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
        
        QueryBuilder builder = (new QueryBuilder())
                .select("\"CustomerID\" AS \"Customer ID\"")
                .select("\"CompanyName\" AS \"Company Name\"")
                .select("SUM(OD.\"Quantity\" * (OD.\"UnitPrice\" - OD.\"UnitPrice\" * OD.\"Discount\")) AS \"TotalOrderAmount\"")
                .from(subquery)
                .naturalJoin("order_details OD")
                .naturalJoin("customers C")
                .group("\"CustomerID\", \"Company Name\"")
                .order("TotalOrderAmount DESC");
        
        System.out.println(builder.build().getSQL());
    }
    
}
