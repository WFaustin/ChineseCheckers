package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BoardPanel extends JPanel {

    Image i = null;

    public BoardPanel(){
        try {
            i = ImageIO.read(new File("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Board.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(600, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(i, 0, 0, getWidth(), getHeight(), this);
    }
}
