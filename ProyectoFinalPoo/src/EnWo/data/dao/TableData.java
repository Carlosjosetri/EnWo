package EnWo.data.dao;

/**
 *
 * @author Tania Orellana
 */
public class TableData {

    final String TABLE_NAME;
    final String PRIMARY_KEY;
    final String[] fields;

    public TableData(String table_name, String primary_key, String[] fields) {
        TABLE_NAME = table_name;
        PRIMARY_KEY = primary_key;
        this.fields = fields;
    }
}
