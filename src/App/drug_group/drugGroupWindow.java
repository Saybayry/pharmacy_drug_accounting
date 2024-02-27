package App.drug_group;

import DAO.GroupDrugDAO;
import TableModels.group_drugTableModel;
import medicines.group_drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class drugGroupWindow extends JFrame {
    private addDrugGroupWindow addWindow;
    private List<group_drug> groupDrugsList;
    private GroupDrugDAO gdDAO;

    private group_drugTableModel gdTableModel;
    private JButton add_goup_btn;
    private JPanel drugGroupPlane;

    private JTable table1;
    private JButton update_btn;
    private JButton delite_select_btn;
    private JButton udate_date_in_bd_btn;

    public drugGroupWindow() {
        gdDAO = new GroupDrugDAO();
        updateData();

        this.setContentPane(drugGroupPlane);

        addWindow = new addDrugGroupWindow(this);
        add_goup_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWindow.setVisible(true);
                addWindow.setSize(400, 500);
            }
        });
        update_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });
        delite_select_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table1.getSelectedRows();
                for (int row : selectedRows) {
                    // Получить данные из модели таблицы для выделенной строки
                    int delit_id = (int) table1.getValueAt(row, 0);
                    // Делайте что-то с полученными данными
                    gdDAO.deleteById(delit_id);
                    System.out.println("Значение выделенной строки: " + delit_id);
                }
                updateData();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Проверяем, является ли щелчок двойным
                    // Получаем индекс строки и столбца, по которым был сделан щелчок
                    int row = table1.rowAtPoint(e.getPoint());
                    int column = table1.columnAtPoint(e.getPoint());
                    // Делайте что-то с этой строкой, например, получайте данные из этой строки и т.д.
                    System.out.println("Двойной щелчок по строке " + row + ", столбец " + column);
                }
            }
        });
    }

    public void updateData() {
        groupDrugsList = gdDAO.getAll();
        gdTableModel = new group_drugTableModel(groupDrugsList);
        table1.setModel(gdTableModel);

    }



}
