package TableModels;

import medicines.group_drug;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class group_drugTableModel extends AbstractTableModel {
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int DESCRIPTION_COL = 2;

    private String[] columnNames = new String[]{"id","name","description"};
    private List<group_drug> groups_drugs;
    public group_drugTableModel(List<group_drug> theGrop_drug) {this.groups_drugs=theGrop_drug;}

    @Override
    public int getColumnCount() {return this.columnNames.length;}
    @Override
    public int getRowCount() {return this.groups_drugs.size();}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        group_drug tempGroup_drug =(group_drug)this.groups_drugs.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tempGroup_drug.getId();
            case 1:
                return tempGroup_drug.getName();
            case 2:
                return tempGroup_drug.getDescription();
            default:
                return "-";
        }
    }
}
