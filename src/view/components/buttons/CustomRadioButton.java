// The custom JRadioButton with better UI look overall.
package view.components.buttons;

import javax.swing.*;

import view.Util.Palette;

import java.awt.event.*;

public class CustomRadioButton extends JRadioButton implements MouseListener, ActionListener {
    public CustomRadioButton(String buttonName) {
        super(buttonName);
        this.setBackground(Palette.WHITE);
        this.addActionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isSelected()) {
            this.setBackground(Palette.HUST_RED);
            this.setForeground(Palette.WHITE);
        }
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
        this.setBackground(Palette.HUST_RED);
        this.setForeground(Palette.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Palette.WHITE);
        this.setForeground(Palette.BLACK);
    }
}
