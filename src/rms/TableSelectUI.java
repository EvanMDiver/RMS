package rms;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class TableSelectUI {
    private JList tableList;
    private JPanel ChooseTable;
    private JButton selectTableButton;
    private Controller controller = new Controller();
    private static JFrame frame;
    private ArrayList<Integer> tablenos = new ArrayList<>();

    public TableSelectUI() {

        DefaultListModel listModel = new DefaultListModel();

        controller.currWaiter.tables.keySet().forEach((Integer x) -> { listModel.addElement("Table " + x.toString()); tablenos.add(x); });
        tableList.setModel(listModel);



        selectTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tableList.isSelectionEmpty()){

                    controller.selectTable(tablenos.get(tableList.getSelectedIndex()));
                    new OrderDialog(controller, tablenos.get(tableList.getSelectedIndex()));

                }
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("RMS");
        frame.setContentPane(new TableSelectUI().ChooseTable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}