package six;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import six.continue1.TablePanel;

/**
 * GUI -> swing J....
 * <ol>
 * <li> 1. JFrame-> glavni kontejner, JPanel
 * <li> 2. UI controls -> JTextField, JButton, JRadioButton, JCheckBox,
 * JComboBox
 * <li> 3. LayoutManager -> BorderLayout, GridLayout, BoxLayout, SpringLayout,
 * GridBagLayout...
 *
 * @author grupa 1
 */
public class ApplicationStarter {

    public static void main(String[] args) {
        JPanel panel = new TablePanel();
        ComboBoxWindow window = new ComboBoxWindow(panel);
        Runnable runnable = window::showWindow;
        SwingUtilities.invokeLater(runnable);
    }

    static void formatDate() {
        //patterni pomocu kojih mozemo prikazati
        String pattern = "dd MMMMMM yyyy";
        Date currentDate = new Date();//Wed Apr 15 17:28:15 CEST 2020
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        String formatiraniDatum = dateFormatter.format(currentDate);
        System.out.println(formatiraniDatum);
    }
}
