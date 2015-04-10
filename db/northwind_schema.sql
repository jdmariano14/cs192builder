--
-- PostgreSQL Northwind Database v1.0 from Ramiro Estigarribia Canese  
-- you may contact him at email   ramiro.estigarribia@rieder.com.py 
--


SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categories (
    "CategoryID" smallint NOT NULL,
    "CategoryName" character varying(15) NOT NULL,
    "Description" text,
    "Picture" bytea
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: customercustomerdemo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customercustomerdemo (
    "CustomerID" bpchar NOT NULL,
    "CustomerTypeID" bpchar NOT NULL
);


ALTER TABLE public.customercustomerdemo OWNER TO postgres;

--
-- Name: customerdemographics; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customerdemographics (
    "CustomerTypeID" bpchar NOT NULL,
    "CustomerDesc" text
);


ALTER TABLE public.customerdemographics OWNER TO postgres;

--
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customers (
    "CustomerID" bpchar NOT NULL,
    "CompanyName" character varying(40) NOT NULL,
    "ContactName" character varying(30),
    "ContactTitle" character varying(30),
    "Address" character varying(60),
    "City" character varying(15),
    "Region" character varying(15),
    "PostalCode" character varying(10),
    "Country" character varying(15),
    "Phone" character varying(24),
    "Fax" character varying(24)
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employees (
    "EmployeeID" smallint NOT NULL,
    "LastName" character varying(20) NOT NULL,
    "FirstName" character varying(10) NOT NULL,
    "Title" character varying(30),
    "TitleOfCourtesy" character varying(25),
    "BirthDate" date,
    "HireDate" date,
    "Address" character varying(60),
    "City" character varying(15),
    "Region" character varying(15),
    "PostalCode" character varying(10),
    "Country" character varying(15),
    "HomePhone" character varying(24),
    "Extension" character varying(4),
    "Photo" bytea,
    "Notes" text,
    "ReportsTo" smallint,
    "PhotoPath" character varying(255)
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- Name: employeeterritories; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employeeterritories (
    "EmployeeID" smallint NOT NULL,
    "TerritoryID" character varying(20) NOT NULL
);


ALTER TABLE public.employeeterritories OWNER TO postgres;

--
-- Name: order_details; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE order_details (
    "OrderID" smallint NOT NULL,
    "ProductID" smallint NOT NULL,
    "UnitPrice" real NOT NULL,
    "Quantity" smallint NOT NULL,
    "Discount" real NOT NULL
);


ALTER TABLE public.order_details OWNER TO postgres;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orders (
    "OrderID" smallint NOT NULL,
    "CustomerID" bpchar,
    "EmployeeID" smallint,
    "OrderDate" date,
    "RequiredDate" date,
    "ShippedDate" date,
    "ShipVia" smallint,
    "Freight" real,
    "ShipName" character varying(40),
    "ShipAddress" character varying(60),
    "ShipCity" character varying(15),
    "ShipRegion" character varying(15),
    "ShipPostalCode" character varying(10),
    "ShipCountry" character varying(15)
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE products (
    "ProductID" smallint NOT NULL,
    "ProductName" character varying(40) NOT NULL,
    "SupplierID" smallint,
    "CategoryID" smallint,
    "QuantityPerUnit" character varying(20),
    "UnitPrice" real,
    "UnitsInStock" smallint,
    "UnitsOnOrder" smallint,
    "ReorderLevel" smallint,
    "Discontinued" integer NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: region; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE region (
    "RegionID" smallint NOT NULL,
    "RegionDescription" bpchar NOT NULL
);


ALTER TABLE public.region OWNER TO postgres;

--
-- Name: shippers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shippers (
    "ShipperID" smallint NOT NULL,
    "CompanyName" character varying(40) NOT NULL,
    "Phone" character varying(24)
);


ALTER TABLE public.shippers OWNER TO postgres;

--
-- Name: shippers_tmp; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shippers_tmp (
    "ShipperID" smallint NOT NULL,
    "CompanyName" character varying(40) NOT NULL,
    "Phone" character varying(24)
);


ALTER TABLE public.shippers_tmp OWNER TO postgres;

--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE suppliers (
    "SupplierID" smallint NOT NULL,
    "CompanyName" character varying(40) NOT NULL,
    "ContactName" character varying(30),
    "ContactTitle" character varying(30),
    "Address" character varying(60),
    "City" character varying(15),
    "Region" character varying(15),
    "PostalCode" character varying(10),
    "Country" character varying(15),
    "Phone" character varying(24),
    "Fax" character varying(24),
    "HomePage" text
);


ALTER TABLE public.suppliers OWNER TO postgres;

--
-- Name: territories; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE territories (
    "TerritoryID" character varying(20) NOT NULL,
    "TerritoryDescription" bpchar NOT NULL,
    "RegionID" smallint NOT NULL
);


ALTER TABLE public.territories OWNER TO postgres;

--
-- Name: usstates; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usstates (
    "StateID" smallint NOT NULL,
    "StateName" character varying(100),
    "StateAbbr" character varying(2),
    "StateRegion" character varying(50)
);


ALTER TABLE public.usstates OWNER TO postgres;

--
-- Name: pk_categories; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT pk_categories PRIMARY KEY ("CategoryID");


--
-- Name: pk_customercustomerdemo; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customercustomerdemo
    ADD CONSTRAINT pk_customercustomerdemo PRIMARY KEY ("CustomerID", "CustomerTypeID");


--
-- Name: pk_customerdemographics; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customerdemographics
    ADD CONSTRAINT pk_customerdemographics PRIMARY KEY ("CustomerTypeID");


--
-- Name: pk_customers; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT pk_customers PRIMARY KEY ("CustomerID");


--
-- Name: pk_employees; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT pk_employees PRIMARY KEY ("EmployeeID");


--
-- Name: pk_employeeterritories; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employeeterritories
    ADD CONSTRAINT pk_employeeterritories PRIMARY KEY ("EmployeeID", "TerritoryID");


--
-- Name: pk_order_details; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY order_details
    ADD CONSTRAINT pk_order_details PRIMARY KEY ("OrderID", "ProductID");

ALTER TABLE ONLY order_details
    ADD CONSTRAINT fk_od_ord FOREIGN KEY ("OrderID") REFERENCES orders;

ALTER TABLE ONLY order_details    
    ADD CONSTRAINT fk_od_prod FOREIGN KEY ("ProductID") REFERENCES products;


--
-- Name: pk_orders; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT pk_orders PRIMARY KEY ("OrderID");
    
ALTER TABLE ONLY orders
    ADD CONSTRAINT fk_ord_cust FOREIGN KEY ("CustomerID") REFERENCES customers;
    
ALTER TABLE ONLY orders
    ADD CONSTRAINT fk_ord_emp FOREIGN KEY ("EmployeeID") REFERENCES employees;
    
ALTER TABLE ONLY orders
    ADD CONSTRAINT fk_ord_ship FOREIGN KEY ("ShipVia") REFERENCES shippers.ShipperID;


--
-- Name: pk_products; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY products
    ADD CONSTRAINT pk_products PRIMARY KEY ("ProductID");

ALTER TABLE ONLY products    
    ADD CONSTRAINT fk_prod_supp FOREIGN KEY ("SupplierID") REFERENCES suppliers;

ALTER TABLE ONLY products    
    ADD CONSTRAINT fk_prod_cat FOREIGN KEY ("CategoryID") REFERENCES categories;


--
-- Name: pk_region; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY region
    ADD CONSTRAINT pk_region PRIMARY KEY ("RegionID");


--
-- Name: pk_shippers; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shippers
    ADD CONSTRAINT pk_shippers PRIMARY KEY ("ShipperID");


--
-- Name: pk_shippers_tmp; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shippers_tmp
    ADD CONSTRAINT pk_shippers_tmp PRIMARY KEY ("ShipperID");


--
-- Name: pk_suppliers; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY suppliers
    ADD CONSTRAINT pk_suppliers PRIMARY KEY ("SupplierID");


--
-- Name: pk_territories; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY territories
    ADD CONSTRAINT pk_territories PRIMARY KEY ("TerritoryID");


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

