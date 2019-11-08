package pl.makuta.day_04.jdbc;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final Logger logger = Logger.getLogger(DbUtil.class);

    public static Connection getConnection() throws SQLException {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletjee?useSSL=false&characterEncoding" +
                    "=utf8&serverTimezone=UTC", "root", "coderslab");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Błąd połączenia z bazą danych", e);
            System.out.println("Błąd połączenia z bazą.");
            throw new RuntimeException("Błąd połączenia z bazą danych", e);
        }
    }
}
