package four;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.stream.Stream;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 1. Kontejner (JPanel, neki drugi panel...)-> glavni JFrame 2. UI
 * kontrole(JButton, JCheckBox, JRadioButton, ..) -> kontrole ubacujem u neki
 * kontejner(JPanel) 3. LayoutManager(BorderLAyout)
 *
 * DRY-Don't repeat yourself
 *
 * @author grupa 1
 */
public class AnimalPanel extends JPanel {

    private final JLabel pictureLabel;
    private final ButtonGroup buttonGroup;
    private final JPanel radioButtonPanel;
    private final AnimalActionListener actionListener;

    public AnimalPanel() {
        super(new BorderLayout());
        pictureLabel = new JLabel(ImageIconUtil.loadImageIcon(AnimalPanel.class, AnimalType.BIRD.getFileName()));
        pictureLabel.setSize(new Dimension(200, 150));
        actionListener = new AnimalActionListener(pictureLabel);
        buttonGroup = new ButtonGroup();
        radioButtonPanel = new JPanel(new GridLayout(0, 1));
        Stream.of(AnimalType.values()).forEach(this::createRadioButton);
        add(radioButtonPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private JRadioButton createRadioButton(AnimalType animalType) {
        JRadioButton radioButton = new JRadioButton(animalType.getName());
        radioButton.setMnemonic(animalType.getKeyEvent());
        radioButton.setActionCommand(animalType.getFileName());
        radioButton.setSelected(animalType.equals(AnimalType.BIRD));
        radioButton.addActionListener(actionListener);
        buttonGroup.add(radioButton);
        radioButtonPanel.add(radioButton);
        return radioButton;
    }

    /*    public void onRadioButtonEventAction(ActionEvent e) {
        System.out.println("Iz privatne metode se okida ovaj blok koda nakon slanja komande : " +e.getActionCommand());
        String fileName = e.getActionCommand();
        System.out.println(fileName);
        ImageIconLoader imageIconLoader = new ImageIconLoader(AnimalPanel.class);
        ImageIcon imageIcon = imageIconLoader.loadImageIcon(fileName);
        pictureLabel.setIcon(imageIcon);
    }*/
}
