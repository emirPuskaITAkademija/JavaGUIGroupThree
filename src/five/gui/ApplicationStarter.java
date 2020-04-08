/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package five.gui;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *1. JFrame, JPanel
 *2. UI controls (JComboBox<String>), JLabel
 *3. LayoutManager(BorderLayout)
 * @author grupa 1
 */
public class ApplicationStarter {
    
    public static void main(String[] args) {
        JPanel comboBoxPanel = new ComboBoxPanel();
        ComboBoxWindow window = new ComboBoxWindow(comboBoxPanel);
        Runnable runnable = window::showWindow;
        SwingUtilities.invokeLater(runnable);
    }
}
