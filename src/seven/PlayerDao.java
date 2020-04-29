package seven;

import java.util.Vector;

/**
 * JTable -> ne cuva podatke niti kešira . table-> prikazuje podatke
 * <p>
 *
 * getAll() -> SELECT *FROM PlayerInfo; -> Vector
 *
 * @author grupa 1
 */
public class PlayerDao {

    //Vector -> kolekcija kao i ArrayList
    public Vector getColumnNames() {
        Vector columnNames = new Vector();
        columnNames.add("Name");
        columnNames.add("Surname");
        columnNames.add("Sport");
        columnNames.add("ofYears");
        columnNames.add("Vegetarian");
        return columnNames;
    }

    public Vector<Vector> getRowData() {

        Vector<Vector> rows = new Vector<>();
        //1. red
        Vector row = new Vector();
        row.add("Elmedin");
        row.add("Bešlagić");
        row.add("Balet");
        row.add(10);
        row.add(true);
        rows.add(row);
        //2. red
        Vector row1 = new Vector();
        row1.add("Almir");
        row1.add("Bešlagić");
        row1.add("Balet");
        row1.add(10);
        row1.add(true);
        rows.add(row1);
        Vector row2 = new Vector();
        row2.add("Zana");
        row2.add("Šuligoj");
        row2.add("Balet");
        row2.add(10);
        row2.add(true);
        rows.add(row2);
        return rows;
    }
}
