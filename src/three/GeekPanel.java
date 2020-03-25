package three;

import two.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
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
public class GeekPanel extends JPanel implements ItemListener {

    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;
    private JLabel pictureLabel;
    private StringBuffer pictureChoice;

    public GeekPanel() {
        super(new BorderLayout());

        chinCheckBox = new JCheckBox("Chin");
        chinCheckBox.setSelected(true);
        chinCheckBox.addItemListener(this);

        glassesCheckBox = new JCheckBox("Glasses");
        glassesCheckBox.setSelected(true);
        glassesCheckBox.addItemListener(this);

        hairCheckBox = new JCheckBox("Hair");
        hairCheckBox.setSelected(true);
        hairCheckBox.addItemListener(this);

        teethCheckBox = new JCheckBox("Teeth");
        teethCheckBox.setSelected(true);
        teethCheckBox.addItemListener(this);

        pictureChoice = new StringBuffer("cght");
        pictureLabel = new JLabel("NO IMAGE");

        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
        checkBoxPanel.add(chinCheckBox);
        checkBoxPanel.add(glassesCheckBox);
        checkBoxPanel.add(hairCheckBox);
        checkBoxPanel.add(teethCheckBox);
        add(checkBoxPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        char c = '-';
        int index = 0;
        Object sourceEvent = itemEvent.getItemSelectable();
        if (sourceEvent == chinCheckBox) {
            System.out.println("ChinCheckBox je okidač ovog bloka koda");
            c = 'c';
            index = 0;
        } else if (sourceEvent == glassesCheckBox) {
            c = 'g';
            index = 1;
            System.out.println("GlassesCheckBox je okidač ovog bloka koda");
        } else if (sourceEvent == hairCheckBox) {
            c = 'h';
            index = 2;
            System.out.println("HairCheckBox je okidač ovog bloka koda");
        } else {
            c = 't';
            index = 3;
            System.out.println("TeethCheckBox je okidač ovog bloka koda");
        }
        if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
            c = '-';
            System.out.println("ODSELEKTOVAN");
        } else {
            System.out.println("SELEKTOVAN");
        }
        pictureChoice.setCharAt(index, c);//  0 - c; 1 - g 
        System.out.println("IZBOR slike : " + pictureChoice);
        ImageIconLoader imageIconLoader = new ImageIconLoader(GeekPanel.class);
        ImageIcon imageIcon = imageIconLoader.createImageIcon("geek-"+pictureChoice+".gif");
        pictureLabel.setIcon(imageIcon);
    }

}
