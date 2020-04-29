package seven;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TablePanel extends JPanel{
    private JTable table;

    public TablePanel(PlayerDao playerDao) {
        Vector columnNames = playerDao.getColumnNames();
        Vector<Vector> rowData = playerDao.getRowData();
        table = new JTable(rowData, columnNames);
        Dimension tableDimension = new Dimension(500, 80);
        table.setPreferredScrollableViewportSize(tableDimension);
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
    }
}
