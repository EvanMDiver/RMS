package rms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AddItemDialog extends JDialog{
    private JList itemList;
    private JPanel panel1;
    private JButton selectButton;
    private JButton cancelButton;
    private JSpinner quantitySpinner;
    private int quantity = 1;
    private ArrayList<Integer> idList = new ArrayList<>();

    public AddItemDialog(Controller controller) {
        this.setContentPane(panel1);
        this.pack();
        this.setModal(true);
        DefaultListModel listModel = new DefaultListModel();
        controller.menu.getItems().forEach((key, value) -> {
            listModel.addElement(value.toString() + " (" + NumberFormat.getCurrencyInstance().format(value.price) + ")");
            idList.add(key);
        });
        itemList.setModel(listModel);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // return the selected item
                if(!itemList.isSelectionEmpty()){
                    quantity = (int) quantitySpinner.getValue();
                    Integer selection = idList.get(itemList.getSelectedIndex());
                    controller.selectItem(selection, quantity);
                    dispose();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // return without selecting an item
                dispose();
            }
        });

        this.setVisible(true);
    }

    private void createUIComponents() {
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1,1,null,1));
    }
}
