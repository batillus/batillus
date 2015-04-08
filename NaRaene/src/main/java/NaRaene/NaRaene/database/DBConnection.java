package NaRaene.NaRaene.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static final String DB_CONFIG_FILE = "database.properties";

    private String dbUrl = "jdbc:mysql://localhost:3306/na_raene";
    private String userName = "root";
    private String password = "java";

    public DBConnection(){
        registerJDBCDriver();
        
    }

    protected void registerJDBCDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
        }
    }

   
    protected Connection getConnection() throws DBException {
        try{
            return DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    protected void closeConnection(Connection connection) throws DBException {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }
}
