package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PlayMenu extends Menu {

    private Player [] players = null;
    private static int playMenunum = 3;
    private static String playMenuname = "PlayMenu";
    private static JFrame playMenuJFrame = null;
    private Board board = new Board();


    public PlayMenu(){
        playMenuJFrame = new JFrame();
        createJFrame();
    }

    public PlayMenu(JFrame jFrame){
        playMenuJFrame = jFrame;
        createJFrame();
    }

    public PlayMenu(JFrame jFrame, Player[] players){
        this.players = players;
        playMenuJFrame = jFrame;
        createJFrame();
    }

    @Override
    public void createJFrame() {
        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();

        jPanel.setLayout(new OverlayLayout(jPanel));

        players[0].CreatePieces();
        players[0].getPieces()[0].getPieceLabel().setAlignmentX(Component.CENTER_ALIGNMENT);
        players[0].getPieces()[0].getPieceLabel().setAlignmentY(-0.7f);

        jPanel1.add(players[0].getPieces()[0].getPieceLabel());
        jPanel.add(board.getBoard_label());
        



        //playMenuJFrame.getContentPane().add(, jPanel);
        playMenuJFrame.setSize(600,600);
        playMenuJFrame.setResizable(false);
        playMenuJFrame.setVisible(true);


    }
}
