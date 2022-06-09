// This class will implement a frame used as the root (scaffold) of the application.
package view;

import javax.swing.*;

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

    FileChooser fc = null;
    DataExtract dataExtract = null;

    public Root() {
        super();
        this.setTitle("Data");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int) (ScreenRes.width() * 2 / 3), (int) (ScreenRes.height() * 2 / 3));
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
        if (e.getSource() == fileChoosingBtn) {
            this.fc = new FileChooser();
            choosenFile.setText(StaticTexts.fileDangChon + fc.getFile());
            System.out.println(fc.getFile());

        } else if (e.getSource() == dataBtn) {
            this.dataExtract = new DataExtract(this.fc.getFile());
            dataExtract.initialize();
        }
    }
}
