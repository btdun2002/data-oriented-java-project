// This class will implement a frame used as the root (scaffold) of the application.
package view;

import javax.swing.*;

import model.DataFrame;
import tech.tablesaw.api.*;

import java.awt.*;
import java.awt.event.*;

import view.Util.*;
import view.components.*;

public class Root extends JFrame implements ActionListener {
    GridBagConstraints gbc = new GridBagConstraints();
    // Components added to the Frame.
    ColoredButton fileChoosingBtn = new ColoredButton(StaticTexts.chonFile);
    JLabel choosenFile = new JLabel(StaticTexts.fileDangChon);
    ColoredButton dataBtn = new ColoredButton(StaticTexts.phanTich);

    FileChoosingScreen fc = null;
    GraphScreen dataExtract = null;

    public Root() {
        super();
        this.setTitle("Data");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        // Setup and add the button to the frame.
        gbc.gridx = 0;
        gbc.gridy = 0;
        fileChoosingBtn.addActionListener(this);
        this.add(fileChoosingBtn, gbc);

        // Container used as a padding between button and text.
        JPanel padding = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(padding, gbc);

        // Setup and add the text illustartes the current file being choosen.
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(choosenFile, gbc);

        // Container used as a padding between button and text.
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(padding, gbc);

        // Setup and add the button to open the analyzed frame.
        gbc.gridx = 0;
        gbc.gridy = 4;
        dataBtn.addActionListener(this);
        this.add(dataBtn, gbc);
    }

    public void initialize() {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // When press the choosing file button, call FileChooser instance.
        if (e.getSource() == fileChoosingBtn) {
            this.fc = new FileChoosingScreen();

            // With the file got from FileChooser, get the path of the file.
            String filePath = fc.getFile().toString();

            // Set the text to acknowledge user about the current choosen file.
            choosenFile.setText(StaticTexts.fileDangChon + filePath);
            System.out.println(filePath);

            // Initialize the dataframe by read the csv the user choosed. Remember that this
            // df can be accessed from anywhere since it is a static variable in
            // DataFrame.java.
            DataFrame.df = Table.read().csv(filePath);
        }
        // With the data button, take the file and perform read and analyze operations
        // with that.
        else if (e.getSource() == dataBtn) {
            this.dataExtract = new GraphScreen(this.fc.getFile());
            dataExtract.initialize();
        }
    }
}
