package itmo.rs.standalone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final String JDBC_URL =
            "jdbc:mysql://flyes.sytes.net:3306/FlyTour?autoReconnect=true&useSSL=false";
    private static final String JDBC_USER = "remoteUser1";
    private static final String JDBC_PASSWORD = "qwe123!@#";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER,
                    JDBC_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return connection;
    }
}
