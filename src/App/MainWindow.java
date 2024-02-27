package App;

import App.drug_group.drugGroupWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel MainPlane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private drugGroupWindow groupWindow;

    public MainWindow() {
        groupWindow = new drugGroupWindow();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupWindow.setVisible(true);
                groupWindow.setSize(500, 500);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new MainWindow().MainPlane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        frame.setVisible(true);

    }

}
