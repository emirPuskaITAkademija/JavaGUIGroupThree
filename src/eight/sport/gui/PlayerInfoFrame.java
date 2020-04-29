/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight.sport.gui;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author grupa 1
 */
public class PlayerInfoFrame extends JFrame {

    private JPanel panel;

    public PlayerInfoFrame(JPanel panel) throws HeadlessException {
        this.panel = panel;
    }

    public void showFrame() {
        setTitle("Playe infos");
        add(panel);
        pack();
        setVisible(true);
    }
}
