package test;

import javax.swing.*;
import java.awt.*;

import model.DataExtract;
import model.DataFrame;
import tech.tablesaw.api.Table;
import view.Util.ScreenRes;
import view.components.buttons.CustomRadioButton;

public class JRadioLayout {
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame();
        f.setTitle("Data");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        f.setLocationRelativeTo(null);
        f.setResizable(false);

        ButtonGroup bg = new ButtonGroup();

        JPanel buttonHolder = new JPanel();
        buttonHolder.setBackground(Color.BLACK);
        buttonHolder.setLayout(new GridLayout(9, 1));
        buttonHolder.setSize((int) (ScreenRes.WIDTH * 1 / 6), (int) (ScreenRes.HEIGHT * 2 / 3));

        DataFrame.df = Table.read().csv(
                "/mnt/windows-d/ComSci/Langs_libs_fwks/Java/Hust_advanced_Java/Final_grade_assignment/assets/data/output_covid_data.csv");

        String[] categories = DataExtract.extractCategories();

        for (int i = 0; i < categories.length; i++) {
            CustomRadioButton newOption = new CustomRadioButton(categories[i]);
            buttonHolder.add(newOption);
            bg.add(newOption);
        }
 
        f.add(buttonHolder);
        f.setVisible(true);
    }
}
