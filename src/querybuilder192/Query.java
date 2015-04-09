package querybuilder192;

/**
 *
 * @author MARIANO, J Stephen DV
 * @studentno 2012-78002
 */
public class Query {
    String action;
    String columns;
    String from;
    String where;
    String group;
    String having;
    
    public Query (String action,
            String columns,
            String from,
            String where,
            String group,
            String having) {
        this.action = action;
        this.columns = columns;
        this.from = from;
        this.where = where;
        this.group = group;
        this.having = having;
    }
    
    public String getSQL() {
        return "";
    }
}
