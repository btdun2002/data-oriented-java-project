// This class will implement a frame used as the root (scaffold) of the application.
package view;

import javax.swing.*;

import model.DataFrame;
import tech.tablesaw.api.*;

import java.awt.*;
import java.awt.event.*;

import view.Util.*;
import view.components.*;
import view.components.loadingIcon.SplashBox;

public class Root extends JFrame implements ActionListener {
    JPanel rootPanel = new JPanel();
    GridBagConstraints gbc = new GridBagConstraints();

    SplashBox splashBox = new SplashBox();
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
        this.setResizable(false);

        // Building main Panel of Root Frame
        rootPanel.setLayout(new GridBagLayout());

        // Setup and add the button to the frame.
        gbc.gridx = 0;
        gbc.gridy = 0;
        fileChoosingBtn.addActionListener(this);
        rootPanel.add(fileChoosingBtn, gbc);

        // Container used as a padding between button and text.
        JPanel padding = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 1;
        rootPanel.add(padding, gbc);

        // Setup and add the text illustartes the current file being choosen.
        gbc.gridx = 0;
        gbc.gridy = 2;
        rootPanel.add(choosenFile, gbc);

        // Container used as a padding between button and text.
        gbc.gridx = 0;
        gbc.gridy = 3;
        rootPanel.add(padding, gbc);

        // Setup and add the button to open the analyzed frame.
        gbc.gridx = 0;
        gbc.gridy = 4;
        dataBtn.addActionListener(this);
        rootPanel.add(dataBtn, gbc);

        this.add(rootPanel);
        this.add(splashBox);
        toRootTask trthread = new toRootTask();
        trthread.start();
    }

    public void initialize() {
        this.setVisible(true);
    }

    public class toRootTask extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            remove(splashBox);
            add(rootPanel);
            validate();
            repaint();
        }
    }

    public class toSplashTask extends Thread {
        @Override
        public void run() {
            remove(rootPanel);
            add(splashBox);
            validate();
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // When press the choosing file button, call FileChooser instance.
        if (e.getSource() == fileChoosingBtn) {
            toSplashTask tsthread = new toSplashTask();
            tsthread.start();

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

            toRootTask trthread = new toRootTask();
            trthread.start();
        }
        // With the data button, take the file and perform read and analyze operations
        // with that.
        else if (e.getSource() == dataBtn) {
            this.dataExtract = new GraphScreen(this.fc.getFile());
            dataExtract.initialize();
        }
    }
}
