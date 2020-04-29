/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight.sport.connection;

import dao.PlayerInfo;
import eight.sport.dao.PlayerInfoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author grupa 1
 */
public class ConnectionTest {

    public static void main(String[] args) throws SQLException {
        //10 konekcija Connection
        DerbyConnectionPool connectionPool = new DerbyConnectionPool();
        PlayerInfoDAO playerInfoDAO = new PlayerInfoDAO(connectionPool);
        List<PlayerInfo> players = playerInfoDAO.loadAll();
        for (PlayerInfo playerInfo : players) {
            System.out.println(playerInfo);
        }
        
        PlayerInfo playerInfo = playerInfoDAO.get(3);
        System.out.println("Da li je ELMEDIN pod id = 3 ---> " + playerInfo);
        if (playerInfo != null) {
            playerInfo.setSport("Ples");
            playerInfoDAO.update(playerInfo);
        }
        
        playerInfoDAO.delete(playerInfo);
    }
}
