package eight.sport.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DerbyConnectionPool {

    private static final String URL = "jdbc:derby://localhost:1527/sport";
    private static final String USERNAME = "sport";
    private static final String PASSWORD = "sport";
    private static final int NUMBER_OF_CONNECTIONS = 10;

    private final List<Connection> availableConnections;
    private final List<Connection> usedConnections;

    public DerbyConnectionPool() throws SQLException{
        this.availableConnections = new ArrayList<>();
        this.usedConnections = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CONNECTIONS; i++) {
            Connection connection = createConnection();
            availableConnections.add(connection);
        }
    }

    //URL, USERNAME, PASSWORD
    private Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public Connection getConnection(){
        if(availableConnections.isEmpty()){
            throw new RuntimeException("Nema dostupnih konekcija");
        }else{
            int indeksZadnjegConnectionObjekta = availableConnections.size()-1;
            Connection connection = availableConnections.get(indeksZadnjegConnectionObjekta);
            availableConnections.remove(connection);
            usedConnections.add(connection);
            return connection;
        }
    }
    
    public void releaseConnection(Connection connection){
        if(null!=connection){
            usedConnections.remove(connection);
            availableConnections.add(connection);
        }
    }
}
