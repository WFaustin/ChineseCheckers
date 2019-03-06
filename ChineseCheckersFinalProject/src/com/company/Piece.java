package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Piece {

    private ImageIcon piecepicture = null;
    private String name = "";
    private COLORS color = null;
    private JLabel pieceLabel = null;
    public JButton pieceButton = null;

    public Piece(){
       //nothing
    }

    public Piece(COLORS c){
        color = c;
        IdentifyColor();
    }

    public JLabel getPieceLabel() {
        return pieceLabel;
    }

    public void setPieceLabel(JLabel pieceLabel) {
        this.pieceLabel = pieceLabel;
    }

    public ImageIcon getPiecepicture() {
        return piecepicture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(COLORS color) {
        this.color = color;
    }

    public COLORS getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    private void IdentifyColor(){
        if (color == COLORS.Red){
            name = "red";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Red Piece.png");
        }
        else if (color == COLORS.Blue){
            name = "blue";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Blue Piece.png");
        }
        else if (color == COLORS.Green){
            name = "green";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Green Piece.png");
        }
        else if (color == COLORS.Yellow){
            name = "yellow";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Yellow Piece.png");
        }
        else if (color == COLORS.White){
            name = "white";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers White Piece.png");
        }
        else if (color == COLORS.Black){
            name = "black";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Black Piece.png");
        }
        else{

        }

        pieceLabel = new JLabel(piecepicture);
        pieceLabel.setIcon(piecepicture);
        pieceLabel.addMouseListener(ml);
    }


    private MouseAdapter ml = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }
    };

}
