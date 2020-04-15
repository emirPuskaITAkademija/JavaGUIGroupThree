package six;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxWindow {
    private final JPanel panel;

    public ComboBoxWindow(JPanel panel) {
        this.panel = panel;
    }
    
    public void showWindow(){
        JFrame frame = new JFrame("Combo box");
        frame.add(panel);
        frame.setSize(400, 500);
        frame.pack();
        frame.setVisible(true);
    }
}
