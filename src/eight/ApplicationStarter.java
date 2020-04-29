/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight;


import eight.sport.connection.DerbyConnectionPool;
import eight.sport.dao.PlayerInfoDAO;
import eight.sport.gui.PlayerInfoFrame;
import eight.sport.gui.PlayerInfoPanel;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

public class ApplicationStarter {

    public static void main(String[] args) throws SQLException {
        DerbyConnectionPool connectionPool = new DerbyConnectionPool();
        PlayerInfoDAO playerInfoDAO = new PlayerInfoDAO(connectionPool);
        PlayerInfoPanel panel = new PlayerInfoPanel(playerInfoDAO);
        PlayerInfoFrame frame = new PlayerInfoFrame(panel);
        SwingUtilities.invokeLater(frame::showFrame);
    }
}
