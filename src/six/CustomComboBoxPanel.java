package six;

import four.AnimalType;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import two.ImageIconLoader;

public class CustomComboBoxPanel extends JPanel {

    private final ImageIcon[] imageIcons;
    private final String[] petNames;
    private final Integer[] comboBoxPositions;
    private final JComboBox<Integer> petComboBox;

    public CustomComboBoxPanel() {
        super(new BorderLayout());
        petNames = AnimalType.findPetNames();
        imageIcons = AnimalType.findPetImageIcons();//5 polja u koja ja treba ImageIcon
        comboBoxPositions = new Integer[petNames.length];
        ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalType.class);
        for (int i = 0; i < petNames.length; i++) {
            comboBoxPositions[i] = i;
        }
        petComboBox = new JComboBox<>(comboBoxPositions);
        CustomComboRendered customComboRendered = new CustomComboRendered();
        petComboBox.setRenderer(customComboRendered);
        add(petComboBox, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private class CustomComboRendered extends JLabel implements ListCellRenderer<Integer> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Integer> list, Integer value, int index, boolean isSelected, boolean cellHasFocus) {
            ImageIcon imageIcon = imageIcons[value];
            String petName = petNames[value];
            //JLabel labela = new JLabel();
            setIcon(imageIcon);
            setText(petName);
            return this;
        }
    }
}
