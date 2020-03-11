package two;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Imat ću 16 slika ali samo jedna slika će biti prikazana.
 * <p>
 * Od čega zavisi to koja slika će biti prikazana ??? ODGOVOR: Od checkiranih
 * check boxa
 *
 * @author grupa 1
 */
public class GeekPanel extends JPanel {

    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;
    private JLabel pictureLabel;

    public GeekPanel() {
        super(new BorderLayout());
        //
        chinCheckBox = new JCheckBox("Chin");
        glassesCheckBox = new JCheckBox("Glasses");
        hairCheckBox = new JCheckBox("Hair");
        teethCheckBox = new JCheckBox("Teeth");
        pictureLabel = new JLabel("NO IMAGE");
        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
        checkBoxPanel.add(chinCheckBox);
        checkBoxPanel.add(glassesCheckBox);
        checkBoxPanel.add(hairCheckBox);
        checkBoxPanel.add(teethCheckBox);
        add(checkBoxPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        
    }
    
    
}
