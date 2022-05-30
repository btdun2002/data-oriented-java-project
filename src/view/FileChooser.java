package view;

import java.io.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.components.ColoredButton;

public class FileChooser extends JFileChooser {
    File choosenFile = null;
    int response = this.showOpenDialog(null);

    public FileChooser() {
        // Set the current directory as one that will be opened by calling super().
        super(new File(System.getProperty("user.dir")));

        // Restrict the file type to .csv.
        this.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv", "comma-seperated");
        this.setFileFilter(restrict);
        this.addChoosableFileFilter(restrict);

        // The if-else statement to validate that the user choosed a file in the
        // directory.
        if (this.response == JFileChooser.APPROVE_OPTION && this.getSelectedFile() != null) {
            File file = new File(this.getSelectedFile().getAbsolutePath());
            this.choosenFile = file;
        } else {
            // JOptionPane.showMessageDialog(new JFrame(), StaticTexts.noChoosingCSV,
            // "Lỗi",
            // JOptionPane.NO_OPTION);
            new ErrorInputFrame();
            // FIXME: Required feature to add some kind of notification to tell user about
            // the .csv files
            // as the only acceptable file type. Note that JOptionPane makes program cannot
            // stop.
            this.choosenFile = null;
        }
    }

    public class ErrorInputFrame extends JFrame {
        private ColoredButton label = new ColoredButton("Wrong input file");
        private JPanel buttonPanel = new JPanel();
        private ColoredButton againButton = new ColoredButton("Choose again");
        private ColoredButton exitButton = new ColoredButton("Exit");

        public ErrorInputFrame() {
            againButton.addActionListener(new ButtonListener());
            exitButton.addActionListener(new ButtonListener());
            this.setLayout(new GridBagLayout());
            buttonPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            this.add(label, gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            gbc.gridx = 0;
            gbc.gridy = 0;
            buttonPanel.add(againButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            buttonPanel.add(exitButton, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            this.add(buttonPanel, gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setVisible(true);
        }

        private class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exitButton) {
                    DisposeErrorInputFrame();
                }
                if (e.getSource() == againButton) {
                    DisposeErrorInputFrame();
                    new FileChooser();
                }
            }
        }

        private void DisposeErrorInputFrame() {
            this.dispose();
        }

    }

    // The getFile() method return the path of the choosen file, which will be used
    // for multiple
    // operations in the future.
    public File getFile() {
        return this.choosenFile;
    }
}
