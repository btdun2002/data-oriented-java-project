package view.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckComboPanel extends JPanel implements ActionListener {
    private String[] ids;
    private Boolean[] values;
    private CustomedBox[] stores;

    public ArrayList<String> ARR;

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

    public void updateSelected() {
        ARR = new ArrayList<String>();
        for (int j = 0; j < ids.length; j++)
            if (stores[j].state)
                ARR.add(stores[j].id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<?> combo = (JComboBox<?>) e.getSource();
        CustomedBox store = (CustomedBox) combo.getSelectedItem();
        CheckComboRenderer ccr = (CheckComboRenderer) combo.getRenderer();
        ccr.checkBox.setSelected((store.state = !store.state));
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateSelected();
            System.out.println(ARR);
        }
    }
}

class CheckComboRenderer implements ListCellRenderer<Object> {
    public JCheckBox checkBox;

    public CheckComboRenderer() {
        checkBox = new JCheckBox();
    }

    @Override
    public JCheckBox getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isPointed, boolean cellHasFocus) {
        CustomedBox tempBox = (CustomedBox) value;
        checkBox.setText(tempBox.id);
        checkBox.setSelected(((Boolean) tempBox.state).booleanValue());
        checkBox.setBackground(isPointed ? Color.red : Color.white);
        checkBox.setForeground(isPointed ? Color.white : Color.black);
        return checkBox;
    }
}

class CustomedBox {
    public String id;
    public Boolean state;

    public CustomedBox(String id, Boolean state) {
        this.id = id;
        this.state = state;
    }
}
