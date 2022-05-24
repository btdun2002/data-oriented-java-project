// This class inherited the JButton class to become a custom button on the sidebar.
package view.components;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import view.Util.*;

public class ColoredButton extends JButton implements MouseListener, ActionListener {

    public ColoredButton(String buttonLabel) {
        // Customize the button
        super();

        this.setText(buttonLabel);
        this.setFocusable(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setFont(new Font("Segoe UI", Font.BOLD, 30));
        this.setBorder(null);
        this.setForeground(Palette.WHITE);
        this.setBackground(Palette.HUST_RED);
        this.setPreferredSize(new Dimension((int) (ScreenRes.width() * 3 / 17), (int) (ScreenRes.height() * 1 / 17)));
        this.addActionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Palette.HUST_RED);
        setBackground(Palette.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Palette.WHITE);
        setBackground(Palette.HUST_RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            System.out.println("Colored Button Pressed");
        }
        
    }
}
