package view.components.buttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckComboPanel extends JPanel implements ActionListener {
    private GridBagConstraints gbc = new GridBagConstraints();
    private String[] ids;
    private Boolean[] values;
    private CustomedBox[] stores;

    public ArrayList<String> selectedItems;

    public CheckComboPanel(String[] ids) {
        this.ids = ids;
        this.setLayout(new GridBagLayout());
        values = new Boolean[ids.length];
        Arrays.fill(values, Boolean.FALSE);
        stores = new CustomedBox[ids.length];
        for (int j = 0; j < ids.length; j++)
            stores[j] = new CustomedBox(ids[j], values[j]);

        JComboBox<CustomedBox> combo = new JComboBox<CustomedBox>(stores);
        combo.setRenderer(new CheckComboRenderer());
        combo.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(combo, gbc);
    }

    public void updateSelected() {
        selectedItems = new ArrayList<String>();
        for (int j = 0; j < ids.length; j++)
            if (stores[j].state)
                selectedItems.add(stores[j].id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<?> combo = (JComboBox<?>) e.getSource();
        CustomedBox store = (CustomedBox) combo.getSelectedItem();
        CheckComboRenderer ccr = (CheckComboRenderer) combo.getRenderer();
        ccr.checkBox.setSelected((store.state = !store.state));
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
