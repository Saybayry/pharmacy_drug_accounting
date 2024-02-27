package App.drug_group;

import DAO.GroupDrugDAO;
import medicines.group_drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDrugGroupWindow extends JFrame {
    private JTextField name_groupInput;
    private JButton addInput;
    private JPanel adddrugGroupPlane;
    private JTextArea descriptionInput;
    private JButton cuncel;
    private JLabel label;
    private group_drug new_gd;
    private GroupDrugDAO gdDB;

    public addDrugGroupWindow(drugGroupWindow parentWindow) {
        this.setContentPane(adddrugGroupPlane);
        addInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name_groupInput.getText();
                String description = descriptionInput.getText();
                new_gd = new group_drug(name);
                new_gd.setDescription(description);
                gdDB = new GroupDrugDAO();
                gdDB.insert(new_gd);
                parentWindow.updateData();
                dispose();
            }
        });
        cuncel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
