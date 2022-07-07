package view.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

class CheckComboPanel extends JPanel implements ActionListener {
    String[] ids;
    Boolean[] values;
    CustomedBox[] stores;

    public CheckComboPanel(String[] ids) {
        this.ids = ids;
        values = new Boolean[ids.length];
        Arrays.fill(values, Boolean.FALSE);
        stores = new CustomedBox[ids.length];
        for (int j = 0; j < ids.length; j++)
            stores[j] = new CustomedBox(ids[j], values[j]);

        JComboBox<CustomedBox> combo = new JComboBox<CustomedBox>(stores);
        combo.setRenderer(new CheckComboRenderer());
        combo.addActionListener(this);

        JButton button = new JButton("Click");
        button.addActionListener(new ButtonListener());

        this.setLayout(new GridLayout(2, 1));
        this.add(combo);
        this.add(button);
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox<?> combo = (JComboBox<?>) e.getSource();
        CustomedBox store = (CustomedBox) combo.getSelectedItem();
        CheckComboRenderer ccr = (CheckComboRenderer) combo.getRenderer();
        ccr.checkBox.setSelected((store.state = !store.state));
    }

    public ArrayList<String> getSelected() {
        ArrayList<String> arr = new ArrayList<String>();
        for (int j = 0; j < ids.length; j++)
            if (stores[j].state)
                arr.add(stores[j].id);
        return arr;
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(getSelected());
        }
    }
}

class CheckComboRenderer implements ListCellRenderer<Object> {
    JCheckBox checkBox;

    public CheckComboRenderer() {
        checkBox = new JCheckBox();
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        CustomedBox tempBox = (CustomedBox) value;
        checkBox.setText(tempBox.id);
        checkBox.setSelected(((Boolean) tempBox.state).booleanValue());
        checkBox.setBackground(isSelected ? Color.red : Color.white);
        checkBox.setForeground(isSelected ? Color.white : Color.black);
        return checkBox;
    }
}

class CustomedBox {
    String id;
    Boolean state;

    public CustomedBox(String id, Boolean state) {
        this.id = id;
        this.state = state;
    }
}
