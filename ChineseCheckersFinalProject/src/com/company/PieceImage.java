package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PieceImage extends JLabel {

    private Image pieceimage = null;
    private String pieceimagelink = null;

    public PieceImage(){

    }

    public PieceImage(String s){
        super();
        setPreferredSize(new Dimension(20, 20));
        pieceimagelink = s;
        try {
            pieceimage = ImageIO.read(getClass().getResource(pieceimagelink));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pieceimage, 0, 0, 1, 1, this);
    }
}
