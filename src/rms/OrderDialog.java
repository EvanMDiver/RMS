package rms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class OrderDialog extends JDialog {
    private JList orderList;
    public JPanel orderPanel;
    private JButton addNewItemButton;
    private JButton deleteSelectedItemButton;
    private JButton completeOrderButton;
    private JButton cancelButton;
    private JLabel priceLabel;

    public OrderDialog(Controller controller, Integer tableID) {
        this.setContentPane(orderPanel);
        this.pack();
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order for Table " + tableID.toString()));
        this.setModal(true);
        DefaultListModel listModel = new DefaultListModel();
        orderList.setModel(listModel);

        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddItemDialog dlg = new AddItemDialog(controller);
                dlg.setLocationByPlatform(true);
                //update order list
                listModel.removeAllElements();
                controller.currTable.currOrder.itemList.forEach((key, value) -> listModel.addElement(value.toString() +
                        "x " + key.toString() + " (" + NumberFormat.getCurrencyInstance().format(key.price) + ")"));
                priceLabel.setText("Price: " + NumberFormat.getCurrencyInstance().format(controller.currTable.currOrder.getPrice()));
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
