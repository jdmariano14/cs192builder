package querybuilder192;

public class Query {
    public static String DELIMITER = System.lineSeparator();
    
    String action;
    String columns;
    String from;
    String where;
    String group;
    String having;
    String order;
    String as;
    
    public Query (String action,
            String columns,
            String from,
            String where,
            String group,
            String having,
            String order,
            String as) {
        this.action = action;
        this.columns = columns;
        this.from = from;
        this.where = where;
        this.group = group;
        this.having = having;
        this.order = order;
        this.as = as;
    }
    
    public String getSQL() {
        String sql = action + " " + columns + DELIMITER
                + "FROM " + from;
        sql += where.isEmpty() ? "" : DELIMITER + "WHERE " + where;
        if (!group.isEmpty()) {
            sql += DELIMITER + "GROUP BY " + group;
            sql += having.isEmpty() ? "" : DELIMITER + "HAVING " + having;
        }
        sql += order.isEmpty() ? "" : DELIMITER + "ORDER BY " + order;

        if (as.isEmpty()) {
            return sql;   
        }
        else {
            return Helper.enclose(sql, "(", ")") + " AS " + as;
        }
    }
}
