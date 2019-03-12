package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Piece {

    private PieceImage pi = null;
    private ImageIcon piecepicture = null;
    private Image piece = null;
    private String name = "";
    private COLORS color = null;
    private JLabel pieceLabel = null;
    public JButton pieceButton = null;
    public String pieceimagelink = "";
    private boolean cool = true;

    public Piece(){
       //nothing
    }

    public Piece(COLORS c){
        color = c;
        IdentifyColor();
    }

    public Piece(String antipiece, COLORS c){
        color = c;
        IdentifyAfterColor();
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

    public PieceImage getPi() {
        return pi;
    }

    public void setPi(PieceImage pi) {
        this.pi = pi;
    }

    private void IdentifyColor(){
        if (color == COLORS.Red){
            name = "red";
            pieceimagelink ="C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Red Piece.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Red Piece.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Blue){
            name = "blue";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Blue Piece.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Blue Piece.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Green){
            name = "green";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Green Piece.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Green Piece.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Yellow){
            name = "yellow";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Yellow Piece.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Yellow Piece.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.White){
            name = "white";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers White Piece.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers White Piece.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Black){
            name = "black";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Gray Piece.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Gray Piece.png");
            pi = new PieceImage(pieceimagelink);
        }
        else{

        }
        try {
            piece = ImageIO.read(new File(pieceimagelink));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pieceLabel = new JLabel(piecepicture);
        pieceLabel.setIcon(piecepicture);
        //pieceLabel.addMouseListener(ml);
    }

    private void IdentifyAfterColor(){
        if (color == COLORS.Red){
            name = "red";
            pieceimagelink ="C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Red Outline.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Red Outline.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Blue){
            name = "blue";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Blue Outline.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Blue Outline.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Green){
            name = "green";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Green Outline.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Green Outline.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Yellow){
            name = "yellow";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Yellow Outline.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Yellow Outline.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.White){
            name = "white";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers White Outline.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers White Outline.png");
            pi = new PieceImage(pieceimagelink);
        }
        else if (color == COLORS.Black){
            name = "black";
            pieceimagelink = "C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Gray Outline.png";
            piecepicture = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Gray Outline.png");
            pi = new PieceImage(pieceimagelink);
        }
        else{

        }
        try {
            piece = ImageIO.read(new File(pieceimagelink));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pieceLabel = new JLabel(piecepicture);
        pieceLabel.setIcon(piecepicture);
        //pieceLabel.addMouseListener(ml);
    }

    /*
    private MouseAdapter ml = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println(pieceLabel.getLocation());
        }


    };
       */
}
