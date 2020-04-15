package five.gui;

import four.AnimalType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import two.ImageIconLoader;
//BorderLayout
//ComboBoxPanel -> kontejner
public class ComboBoxPanel extends JPanel {

    //UI controls
    private final JComboBox<String> petComboBox;
    private final JLabel pictureLabel;

    public ComboBoxPanel() {
        super(new BorderLayout());
        String[] petNames = AnimalType.findPetNames();
        this.petComboBox = new JComboBox<>(petNames);
        this.petComboBox.setSelectedIndex(petNames.length - 1);
        this.pictureLabel = new JLabel();
        ComboBoxListener comboBoxListener = new ComboBoxListener(pictureLabel);
        this.petComboBox.addActionListener(comboBoxListener);
        Dimension dimension = new Dimension(200, 140);
        this.pictureLabel.setPreferredSize(dimension);
        this.pictureLabel.setBackground(Color.YELLOW);
        updatePictureLabel(petNames[petNames.length - 1]);

        add(petComboBox, BorderLayout.PAGE_START);
        add(pictureLabel, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void updatePictureLabel(String name) {
        String fileName = name + ".gif";
        ImageIconLoader iconLoader = new ImageIconLoader(AnimalType.class);
        ImageIcon icon = iconLoader.loadImageIcon(fileName);
        pictureLabel.setIcon(icon);
    }
}
