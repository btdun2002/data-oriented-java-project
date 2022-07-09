// The custom JRadioButton with better UI look overall.
package view.components.buttons;

import javax.swing.*;
import javax.swing.border.*;

import view.Util.Palette;

import java.awt.event.*;

public class CustomRadioButton extends JRadioButton implements MouseListener, ActionListener {
    private Border buttonBorder = BorderFactory.createLineBorder(Palette.HUST_RED);

    public CustomRadioButton(String buttonName) {
        super(buttonName);
        this.setBackground(Palette.WHITE);
        this.setBorder(buttonBorder);
        this.addActionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isSelected()) {
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
        this.setBorderPainted(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorderPainted(false);
    }
}
