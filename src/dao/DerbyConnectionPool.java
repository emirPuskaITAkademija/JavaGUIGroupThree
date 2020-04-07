package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emir
 */
public class DerbyConnectionPool {
     private final int maxConnection = 10;

    private final String url;
    private final String username;
    private final String password;
    private final List<Connection> usedConnection;
    private final List<Connection> availableConnection;
    
    public DerbyConnectionPool() throws SQLException{
        this(ConnectionProperties.URL.getValue(), ConnectionProperties.USERNAME.getValue(), ConnectionProperties.PASSWORD.getValue());
    }

    public DerbyConnectionPool(String url, String username, String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.usedConnection = new ArrayList<>();
        this.availableConnection = new ArrayList<>();
        for (int i = 0; i < maxConnection; i++) {
            availableConnection.add(createConnection());
        }
    }

    private Connection createConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
        System.out.println("KREIRAO OBJEKAT");
        return conn;

    }

    public Connection getConnection() {
        if (availableConnection.isEmpty()) {
            throw new RuntimeException("Nema dostupnih konekcija");
        } else {
            Connection conn = availableConnection.get(availableConnection.size() - 1);
            availableConnection.remove(conn);
            usedConnection.add(conn);
            return conn;
        }
    }

    public boolean releaseConnection(Connection conn) {
        if (null != conn) {
            usedConnection.remove(conn);
            availableConnection.add(conn);
            return true;
        } else {
            return false;
        }
    }

    public int getFreeConnectionCount() {
        return availableConnection.size();
    }
}
