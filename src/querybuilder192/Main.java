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
    * * Given: start date (e.g. 1995-01-02), end date (e.g. 1995-12-30)
    * * Output: Category, Product, Sales
    * * Sort by Category; for each Category sort product sales from highest to
    *   lowest sales
    * 
    * * Expected query:
    * * SELECT "CategoryName" AS "Category",
                "ProductName" AS "Product",
                SUM(OD."Quantity" * (OD."UnitPrice" - OD."UnitPrice" * OD."Discount")) AS "Sales"
            FROM (SELECT "OrderID"
                FROM orders
                WHERE ("ShippedDate" >= "1995-01-02" AND "ShippedDate" < "1995-12-30")) AS O
            NATURAL JOIN order_details OD
            NATURAL JOIN products 
            NATURAL JOIN categories
            GROUP BY "CategoryName", "ProductName"
            ORDER BY "CategoryName", "Sales"
    */
    public static void item3() {
    }
    
    /** 
    * [ITEM 4] 
    * No. of Products Per Category and most expensive product Per Category
    * * Output: Category ID, Category Name, No. of Products, Product, Unit Price
    * * Sort by Unit Price (from highest to lowest) 
    * 
    * * Expected query:
    * * SELECT "CategoryID" AS "Category ID",
                "CategoryName" AS "Category Name",
                "No. of Products",
                "ProductName" AS "Most Expensive Product",
                "UnitPrice" AS "Unit Price"
            FROM categories C
            NATURAL JOIN products P
            NATURAL JOIN (SELECT "CategoryID",
                            COUNT("ProductID") AS "No. of Products"
                          FROM categories C1
                          NATURAL JOIN products P1
                          GROUP BY("CategoryID")) AS subquery
            GROUP BY "CategoryID", "CategoryName", "No. of Products", "ProductName", "UnitPrice"
            HAVING "UnitPrice" =
                (SELECT MAX("unit_price")
                    FROM (SELECT "UnitPrice" AS "unit_price"
                            FROM products P2
                            WHERE P2."CategoryID" = C."CategoryID") AS innersubquery)
            ORDER BY "UnitPrice" DESC
    */
    public static void item4() {
    }
    
    /**
    * [ITEM 5] Biggest Sale per Employee
    * * Output: Employee, Order ID, Customer, Order Amount, Order Date, Ship Date
    * * Clue: An order is already shipped if ShippedDate is not null.
    * * Sales = sum of unitprice * (1 - discount) * quantity per product ordered
    * 
    * * Expected query:
    * * SELECT "LastName" || $$, $$ || "FirstName" AS "Name",
            "OrderID",
            "CompanyName" AS "Customer",
            SUM(OD."Quantity" * (OD."UnitPrice" - OD."UnitPrice" * OD."Discount")) AS "Order Amount",
            "OrderDate" AS "Order Date",
            "ShippedDate" AS "Shipped Date"
        FROM orders O
                NATURAL JOIN order_details OD
                NATURAL JOIN employees E
                JOIN customers C ON (C."CustomerID" = O."CustomerID")
        GROUP BY "LastName", "FirstName", E."EmployeeID", "OrderID", "Customer", "OrderDate", "ShippedDate"
        HAVING SUM(OD."Quantity" * (OD."UnitPrice" - OD."UnitPrice" * OD."Discount")) =
                (SELECT MAX("order_amount")
                        FROM (SELECT SUM(OD1."Quantity" * (OD1."UnitPrice" - OD1."UnitPrice" * OD1."Discount")) AS "order_amount"
                                FROM orders O1
                                        NATURAL JOIN order_details OD1
                                GROUP BY "EmployeeID", "OrderID"
                                HAVING (O1."EmployeeID"= E."EmployeeID")) AS innersubquery)
        ORDER BY "Order Amount" DESC
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
