package seven;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TableWindow {
    //Depend upon abstraction not upon concrete implementation
    private final JPanel panel;

    public TableWindow(JPanel panel) {
        this.panel = panel;
    }
    
    public void showWindow(){
        JFrame frame = new JFrame("Table overview");
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
