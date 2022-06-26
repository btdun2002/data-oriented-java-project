package test;

import javax.swing.*;
import java.awt.*;

public class HUSTPanel extends JPanel {
    boolean imgState = true;
    String imgRDir;
    String imgBDir;
    Image imgR;
    Image imgB;
    int width;
    int height;

    public HUSTPanel(String imgRDir, String imgBDir, int width, int height) {
        this.imgRDir = imgRDir;
        this.imgBDir = imgBDir;
        this.width = width;
        this.height = height;
        this.imgR = getToolkit().getImage(imgRDir);
        this.imgB = getToolkit().getImage(imgBDir);
        this.imgR = (this.imgR).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        this.imgB = (this.imgB).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        // this.addMouseListener(this);
        setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imgState) {
            g.drawImage(imgR, (this.getWidth() - imgR.getWidth(null)) / 2,
                    (this.getHeight() - imgR.getHeight(null)) / 2, this);
        }
        if (!imgState) {
            g.drawImage(imgB, (this.getWidth() - imgR.getWidth(null)) / 2,
                    (this.getHeight() - imgR.getHeight(null)) / 2, this);
        }
    }

    public void turnRed() {
        imgState = true;
        repaint();
    }

    public void turnBlack() {
        imgState = false;
        repaint();

    }

    // public void mouseClicked(MouseEvent e) {

    // }

    // public void mouseEntered(MouseEvent e) {
    // imgState = false;
    // repaint();
    // }

    // public void mouseExited(MouseEvent e) {
    // imgState = true;
    // repaint();
    // }

    // public void mousePressed(MouseEvent e) {

    // }

    // public void mouseReleased(MouseEvent e) {

    // }
}