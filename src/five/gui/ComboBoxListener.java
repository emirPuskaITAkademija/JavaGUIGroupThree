package five.gui;

import four.AnimalType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import two.ImageIconLoader;

class ComboBoxListener implements ActionListener {

    private final JLabel pictureLabel;

    public ComboBoxListener(JLabel pictureLabel) {
        this.pictureLabel = pictureLabel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
        String petName = (String) comboBox.getSelectedItem();
        String fileName = petName + ".gif";
        ImageIconLoader iconLoader = new ImageIconLoader(AnimalType.class);
        ImageIcon icon = iconLoader.loadImageIcon(fileName);
        pictureLabel.setIcon(icon);
    }
}
