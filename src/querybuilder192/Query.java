package querybuilder192;

public class Query {
    public static String DELIMITER = System.lineSeparator();
    
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
        String sql = action + " " + columns + Query.DELIMITER
                + "FROM " + from + Query.DELIMITER
                + "WHERE " + where + Query.DELIMITER
                + "GROUP BY " + group + Query.DELIMITER
                + "HAVING " + having;
        return sql;
    }
}
