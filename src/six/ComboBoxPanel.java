package six;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ComboBoxPanel extends JPanel {

    static final String[] patterns = {
        "dd MMMMMM yyyy",
        "dd.MM.yy",
        "MM/dd/yy",
        "yyyy.MM.dd G 'at' hh:mm:ss z",
        "EEE, MMM d, yy",
        "h:mm a",
        "H:mm:ss:SSS"
    };

    private JLabel patternLabel1;
    private JLabel patternLabel2;
    private JComboBox<String> patternComboBox;
    private JLabel descriptionResultLabel;
    private JLabel resultLabel;

    public ComboBoxPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        patternLabel1 = new JLabel("Unesite šablon za formatiranje datuma ili");
        patternLabel2 = new JLabel("birajte već postojeće šablone iz selekta");
        //Observable  objekat -> promatrani objekat
        patternComboBox = new JComboBox<>(patterns);
        patternComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        patternComboBox.setEditable(true);
        resultLabel = new JLabel();
        String formatiraniDatum = DateUtil.formatCurrentDate((String)patternComboBox.getSelectedItem());
        resultLabel.setText(formatiraniDatum);
        //Observer -> listener objekat
        PatternComboBoxListener listener = new PatternComboBoxListener(resultLabel);
        patternComboBox.addActionListener(listener);
        descriptionResultLabel = new JLabel("Trenutni datum/vrijeme");

        Border outsideBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border insideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border resultBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        resultLabel.setBorder(resultBorder);

        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);
        patternPanel.add(patternComboBox);
        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel resultPanel = new JPanel(new GridLayout(0, 1));
        resultPanel.add(descriptionResultLabel);
        resultPanel.add(resultLabel);
        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(resultPanel);
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(border);
    }

}
