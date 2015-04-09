package querybuilder192;

public class Query {
    public static String DELIMITER = System.lineSeparator();
    
    String action;
    String columns;
    String from;
    String where;
    String group;
    String having;
    String as;
    
    public Query (String action,
            String columns,
            String from,
            String where,
            String group,
            String having,
            String as) {
        this.action = action;
        this.columns = columns;
        this.from = from;
        this.where = where;
        this.group = group;
        this.having = having;
        this.as = as;
    }
    
    public String getSQL() {
        String sql = action + " " + columns + DELIMITER
                + "FROM " + from;
        sql += where.isEmpty() ? "" : DELIMITER + "WHERE " + where;
        sql += group.isEmpty() ? "" : DELIMITER + "GROUP BY " + group ;
        sql += having.isEmpty() ? "" : DELIMITER + "HAVING " + having;
        return sql;
    }
}
