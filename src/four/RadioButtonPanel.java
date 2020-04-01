/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends JPanel {

    private final ButtonGroup buttonGroup;

    public RadioButtonPanel() {
        super(new GridLayout(0, 1));
        buttonGroup = new ButtonGroup();
        AnimalType[] animalTypes = AnimalType.values();
    }

    private JRadioButton addRadioButton(AnimalType animalType, boolean checked, int keyEvent) {
        JRadioButton radioButton = new JRadioButton(animalType.getName());
        radioButton.setMnemonic(keyEvent);
        radioButton.setActionCommand(animalType.getFileName());
        radioButton.setSelected(checked);
        //radioButton.addActionListener(actionListener);
        buttonGroup.add(radioButton);
        add(radioButton);
        return radioButton;
    }

}
