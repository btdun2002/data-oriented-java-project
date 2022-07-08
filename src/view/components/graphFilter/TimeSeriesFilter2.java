package view.components.graphFilter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.Util.Palette;
import view.components.*;
import view.components.buttons.*;

public class TimeSeriesFilter2 extends JPanel implements ActionListener {
    // Extract data/informations needed for the panel.
    private String[] countries = DataExtract.extractCountry();
    private String[] categories = DataExtract.extractCategories();

    // Components.
    private CheckComboPanel countrySelect;
    private SeriesTypeChooser graphCategories;
    private ColoredButton filterBtn = new ColoredButton("Áp dụng");
    private ColoredButton clearFilterBtn = new ColoredButton("Xóa bộ lọc");

    public TimeSeriesFilter2() {
        super();
        this.setLayout(new GridLayout(3 + categories.length, 1));
        this.setBackground(Palette.WHITE);

        // Create a Combobox with checkbox by calling the CheckComboPanel class with
        // list of countries obtained from DataExtract class.
        this.countrySelect = new CheckComboPanel(countries);
        this.add(countrySelect);

        // Create JRadioButton serves as filter for the type of data the graph will
        // represent.
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < categories.length; i++) {
            CustomRadioButton newOption = new CustomRadioButton(categories[i]);
            bg.add(newOption);
            this.add(newOption);
        }
        graphCategories = new SeriesTypeChooser(categories);
        // this.add(graphCategories);

        clearFilterBtn.addActionListener(this);
        this.add(clearFilterBtn);

        filterBtn.addActionListener(this);
        this.add(filterBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == filterBtn) {
            countrySelect.updateSelected();
            System.out.println(countrySelect.selectedItems);
        }
    }
}
