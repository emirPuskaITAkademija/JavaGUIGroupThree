package three;


import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import two.ProzorTester;
//1. JFrame
//2. JComponent - UI kontrole
//3. LayoutManager
public class GuiStarter {

    private final JPanel panel;

    public GuiStarter(JPanel panel) {
        this.panel = panel;
    }

    public void show() {
        JFrame frame = new JFrame("Geek show");
        frame.add(panel);
        frame.setMinimumSize(new Dimension(700, 500));
        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowGUI() {
        GeekPanel geekPanel = new GeekPanel();
        GuiStarter guiStarter = new GuiStarter(geekPanel);
        guiStarter.show();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiStarter::createAndShowGUI);
    }
}
