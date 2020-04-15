package six.continue1;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JPanel {

    String[] columnNames = {"Name", "Surname", "Sport", "Of years", "Vegetarian"};
    Object[][] data = {
        {"Zana", "Sujoldzic", "Skijanje", new Integer(5), new Boolean(false)},
        {"Ivana", "Šuligoj", "Odbojka", new Integer(5), new Boolean(false)},
        {"Almir", "Sujoldzic", "Baletom", new Integer(2), new Boolean(true)},
        {"Neven", "Kosoric", "Belaet", new Integer(3), new Boolean(false)}
    };
    private final JTable table;

    public TablePanel() {
        this.table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 60));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

}
