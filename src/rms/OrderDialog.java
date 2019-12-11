package rms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderDialog extends JDialog {
    private JList orderList;
    public JPanel orderPanel;
    private JButton addNewItemButton;
    private JButton deleteSelectedItemButton;
    private JButton completeOrderButton;
    private JButton cancelButton;

    public OrderDialog(Controller controller, Integer tableID) {
        this.setContentPane(orderPanel);
        this.pack();
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order for Table " + tableID.toString()));
        this.setModal(true);
        DefaultListModel listModel = new DefaultListModel();
        orderList.setModel(listModel);
        orderList.updateUI();

        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddItemDialog dlg = new AddItemDialog(controller);
                dlg.setLocationByPlatform(true);
                //update order list
                listModel.removeAllElements();
                controller.currTable.currOrder.itemList.forEach((key, value) -> listModel.addElement(key.toString() + " x" + value.toString()));

            }
        });
        completeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.submitOrder();
                dispose();
            }
        });


        this.setVisible(true);
    }
}
