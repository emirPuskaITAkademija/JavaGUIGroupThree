package seven;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomTablePanel extends JPanel{

    private final JTable table;
    
    public CustomTablePanel(PlayerDao playerDao) {
        Vector columnNames = playerDao.getColumnNames();
        Vector rowData = playerDao.getRowData();
        OurTableModel tableModel = new OurTableModel(columnNames, rowData);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
    }
    
    
    
}
