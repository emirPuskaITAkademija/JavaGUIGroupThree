package seven;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class SimpleTablePanel extends JPanel {

    private final JTable table;

    public SimpleTablePanel() {
        super(new GridLayout(1, 0));
        String[] columNames = {"Name", "Surname", "Sport", "of Years", "Vegetarian"};
        Object[][] rowData = {
            {"Elmedin", "Bešlagić", "Balet", 10, true},
            {"Ivana", "Šuligoj", "Kikbox", 3, false},
            {"Adnan", "Husika", "Balet", 20, true},
            {"Osman", "Bučan", "Balet", 15, true},
            {"Zana", "Anić", "Odbojka", 5, false},
            {"Almir", "Ćenanović", "Balet", 2, false},
            {"Neven", "Kosorić", "Walking", 12, false}};
        table = new JTable(rowData, columNames);
        Dimension dimension = new Dimension(500, 80);
        table.setPreferredScrollableViewportSize(dimension);
        table.setFillsViewportHeight(true);
        TableColumn tableColumn = null;
        TableColumnModel tableColumnModel = table.getColumnModel();
        for(int i = 0; i<columNames.length; i++){
            tableColumn = tableColumnModel.getColumn(i);//0 nameColumn, surnameCOlumn
            if(i == 1){
                tableColumn.setPreferredWidth(90);
            }else{
                tableColumn.setPreferredWidth(60);
            }
        }
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
