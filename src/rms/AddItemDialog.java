package rms;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AddItemDialog extends JDialog{
    private JList itemList;
    private JPanel panel1;
    private JButton selectButton;
    private JButton cancelButton;
    private JSpinner quantitySpinner;
    private int quantity;
    private ArrayList<Integer> idList = new ArrayList<>();

    public AddItemDialog(Controller controller) {
        this.setContentPane(panel1);
        this.pack();
        this.setModal(true);
        DefaultListModel listModel = new DefaultListModel();
        controller.menu.items.forEach((key, value) -> {listModel.addElement(value.toString()); idList.add(key);});
        itemList.setModel(listModel);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // return the selected item
                if(!itemList.isSelectionEmpty()){
                    Integer selection = idList.get(itemList.getSelectedIndex());
                    controller.selectItem(selection , quantity);
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
        quantitySpinner.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                quantity = (int) quantitySpinner.getValue();
            }
        });

        this.setVisible(true);
    }

    private void createUIComponents() {
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1,1,null,1));
    }
}
