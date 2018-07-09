package EnWo.data;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tania Orellana
 */
public class Connection {

    private static Connection instance;
    private static final String password = "root";
    private static final String user = "root";
    private static final String driver = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://localhost:3306/datosjuego";

    private Connection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            synchronized (Connection.class) {
                if (instance == null) {
                    instance = new Connection();
                }
            }
        }
        return instance;
    }

    public java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
