package seven;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ApplicationStarter {
    public static void main(String[] args) {
        PlayerDao playerDao = new PlayerDao();
        JPanel tablePanel = new CustomTablePanel(playerDao);
//new TablePanel(playerDao);//new SimpleTablePanel();
        TableWindow window = new TableWindow(tablePanel);
        Runnable worker = window::showWindow;
        SwingUtilities.invokeLater(worker);
    }
}
