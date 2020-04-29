package seven;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
//klasu kreiram da bi kreirao objekat
//OurTableModel mojTableModeObject = new OurTableModel()
//JTable table = new Jtable();

public class OurTableModel extends AbstractTableModel {

    private final Vector columnNames;
    private final Vector<Vector> rowData;

    public OurTableModel(Vector columnNames, Vector<Vector> rowData) {
        this.columnNames = columnNames;
        this.rowData = rowData;
    }

    @Override
    public String getColumnName(int column) {
        return (String) columnNames.get(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex<2){
            return false;
        }else{
            return true;
        }
    }
    
    

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vector row = rowData.get(rowIndex);
        Object data = row.get(columnIndex);
        return data;
    }

}
