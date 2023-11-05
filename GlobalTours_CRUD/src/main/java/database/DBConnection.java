package database;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/globaltoursdb";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = java.sql.DriverManager.getConnection(URL, user, password);
            System.out.println("Conexão estabelecida");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
