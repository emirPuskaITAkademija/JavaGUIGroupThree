
package two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Prozor {
    
    private JPanel panel;

    public Prozor(JPanel panel) {
        this.panel = panel;
    }
    
    public void show(){
        JFrame frame = new JFrame("Button demonstration");
        frame.add(panel);
        frame.setSize(700, 200);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        JPanel panel = new ButtonPanel();
        panel = new GeekPanel();
        Prozor prozor = new Prozor(panel);
        Runnable runProzor = prozor::show;
        SwingUtilities.invokeLater(runProzor);
    }

}
