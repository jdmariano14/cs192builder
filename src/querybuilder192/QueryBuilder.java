package querybuilder192;

/**
 *
 * @author MARIANO, J Stephen DV
 * @studentno 2012-78002
 */
public class QueryBuilder {
    String action;
    String columns;
    String from;
    String where;
    String group;
    String having;
    String as;
    
    public QueryBuilder() {
        where = group = having = as = "";
    }
    
    public Query build() {
        return new Query(action, columns, from, where, group, having, as);
    }
    
    public QueryBuilder select(String columns) {
        action = "SELECT";
        this.columns = columns;
        return this;
    }
    
    public QueryBuilder from(String table) {
        this.from = table;
        return this;
    }
    
    public QueryBuilder where(String where) {
        this.where = where;
        return this;
    }
    
    public QueryBuilder group(String group) {
        this.group = group;
        return this;
    }
    
    public QueryBuilder having(String having) {
        this.having = having;
        return this;
    }
    
    public QueryBuilder as(String as) {
        this.as = as;
        return this;
    }
    
    public QueryBuilder naturalJoin(String table) {
        if (!from.isEmpty()) {
            from += Query.DELIMITER
                    + "NATURAL JOIN "
                    + table;
        }
        else {
            from = table;
        }
        return this;
    }
    
    public QueryBuilder joinUsing(String table, String using) {
        if (!from.isEmpty()) {
            from += Query.DELIMITER
                    + "JOIN "
                    + table
                    + " USING "
                    + using;
        }
        else {
            from = table;
        }
        return this;
    }
    
    public QueryBuilder joinOn(String table, String on) {
        if (!from.isEmpty()) {
            from += Query.DELIMITER
                    + "JOIN "
                    + table
                    + " ON "
                    + on;
        }
        else {
            from = table;
        }
        return this;
    }
    
}
