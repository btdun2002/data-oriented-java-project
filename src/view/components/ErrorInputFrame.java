package view.components;

import javax.swing.*;

import view.*;

import java.awt.*;
import java.awt.event.*;

public class ErrorInputFrame extends JFrame implements ActionListener {
    private ColoredButton label = new ColoredButton("Wrong input file");
    private JPanel buttonPanel = new JPanel();
    private ColoredButton againButton = new ColoredButton("Choose again");
    private ColoredButton exitButton = new ColoredButton("Exit");

    public ErrorInputFrame() {
        this.setLayout(new GridBagLayout());
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(label, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        againButton.addActionListener(this);
        buttonPanel.add(againButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        exitButton.addActionListener(this);
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

    private void DisposeErrorInputFrame() {
        this.dispose();
    }

    @Override
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
