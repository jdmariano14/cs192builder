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
    
}
