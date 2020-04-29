package eight.sport.gui;

import dao.PlayerInfo;
import eight.sport.dao.PlayerInfoDAO;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class PlayerInfoPanel extends JPanel {

    private PlayerInfoDAO playerInfoDAO;
    //UI controls
    private JTable table;
    private OurTableModel tableModel;
    private TableRowSorter<OurTableModel> tableRowSorter;
    private JTextField nameTextField;

    public PlayerInfoPanel(PlayerInfoDAO playerInfoDAO) throws SQLException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.playerInfoDAO = playerInfoDAO;
        this.tableModel = new OurTableModel(playerInfoDAO.getColumnNames(), getAll());
        this.tableRowSorter = new TableRowSorter<>(tableModel);
        this.table = new JTable(tableModel);
        this.table.setRowSorter(tableRowSorter);
        this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        SelectSportColumnHandler sportColumnHandler = new SelectSportColumnHandler(3);
        add(new JScrollPane(table));
    }

    private Vector<Vector<Object>> getAll() throws SQLException {
        Vector<Vector<Object>> dataRows = new Vector<>();
        for (PlayerInfo playerInfo : playerInfoDAO.loadAll()) {
            Vector<Object> row = new Vector<>();
            row.addElement(playerInfo.getId());
            row.addElement(playerInfo.getFirstName());
            row.addElement(playerInfo.getLastName());
            row.addElement(playerInfo.getSport());
            row.addElement(playerInfo.getOfYears());
            row.addElement(playerInfo.getVegetarian());
            dataRows.add(row);
        }
        return dataRows;
    }

    private class OurTableModel extends AbstractTableModel {

        private final Vector<String> columnNames;
        private final Vector<Vector<Object>> data;

        public OurTableModel(Vector<String> columnNames, Vector<Vector<Object>> data) {
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            Object object = rowVector.get(columnIndex);
            return object;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            rowVector.remove(columnIndex);
            rowVector.add(columnIndex, aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
            int id = (int) rowVector.get(0);
            String firstName = (String) rowVector.get(1);
            String lastName = (String) rowVector.get(2);
            String sport = (String) rowVector.get(3);
            int ofYears = (int) rowVector.get(4);
            boolean vegetarian = (boolean) rowVector.get(5);
            PlayerInfo playerInfo = new PlayerInfo(id, firstName, lastName, sport, ofYears, vegetarian);
            try {
                playerInfoDAO.update(playerInfo);
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            //Vector<Object> Integer String Boolean
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            return clazz;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

    }

    class SelectSportColumnHandler extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

        String[] sports = {"Kosarka", "Odbojka", "Balet"};
        private JComboBox<String> sportEditableComboBox;
        private JComboBox<String> sportRenderCOmboBox;

        public SelectSportColumnHandler(int columnIndex) {
            sportEditableComboBox = new JComboBox<>(sports);
            sportRenderCOmboBox = new JComboBox<>(sports);

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(columnIndex).setCellEditor(this);
            columnModel.getColumn(columnIndex).setCellRenderer(this);
        }

        @Override
        public Object getCellEditorValue() {
            return sportEditableComboBox.getSelectedItem();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return sportEditableComboBox;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return sportRenderCOmboBox;
        }

    }
}
