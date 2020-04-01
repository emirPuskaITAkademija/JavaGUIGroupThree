package four;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import two.ImageIconLoader;

public class AnimalActionListener implements ActionListener{
    
    private final JLabel pictureLabel;

    public AnimalActionListener(JLabel pictureLabel) {
        this.pictureLabel = pictureLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("EKSTERNI listener se okida pri komandi: " + e.getActionCommand());
        String fileName = e.getActionCommand();
        pictureLabel.setIcon(new ImageIconLoader(AnimalPanel.class).loadImageIcon(fileName));
    } 
}
