package six;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PatternComboBoxListener implements ActionListener {
    
    private final JLabel resultLabel;
    
    public PatternComboBoxListener(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<String> patternComboBox = (JComboBox<String>) event.getSource();
        String pattern = (String) patternComboBox.getSelectedItem();
        String formatiraniDatum = DateUtil.formatCurrentDate(pattern);
        resultLabel.setText(formatiraniDatum);
    }
}
