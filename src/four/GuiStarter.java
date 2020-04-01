package four;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 1. JFrame ili neki kontejner kao što je JPanel ali u konacnici sve ubacujemo
 * u okno sa sadrzajem od Jframe
 *
 * @author grupa 1
 */
public class GuiStarter {

    private final JPanel panel;

    public GuiStarter(JPanel panel) {
        this.panel = panel;
    }

    public void show(String title) {
        JFrame frame = new JFrame(title);
        frame.add(panel);
        frame.setMinimumSize(new Dimension(400, 250));
        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowGUI() {
        JPanel panel = new AnimalPanel();
        GuiStarter guiStarter = new GuiStarter(panel);
        guiStarter.show("Animal panel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiStarter::createAndShowGUI);
    }
}
