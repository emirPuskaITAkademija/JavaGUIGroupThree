package dao;

import java.sql.SQLException;

/**
 *
 * @author emir
 */
public class PlayerInfoTest {

    public static void main(String[] args) throws SQLException {
        //connection pool -> 10 connection objekata
        DerbyConnectionPool connectionPool = new DerbyConnectionPool();
        //CRUD-statements na SQL bazu
        PlayerInfoDao playerInfoDao = new PlayerInfoDao(connectionPool);
        playerInfoDao.getAll().forEach(System.out::println);
    }
}
