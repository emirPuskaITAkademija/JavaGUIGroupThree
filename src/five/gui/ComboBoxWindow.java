package five.gui;
//1. JFrame
//2. 

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxWindow {

    //konkretne klase-depend upon apstraction
    private final JPanel panel;

    public ComboBoxWindow(JPanel panel) {
        this.panel = panel;
    }

    public void showWindow() {
        JFrame frame = new JFrame("Combo box");
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
