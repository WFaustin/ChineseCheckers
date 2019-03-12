package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayMenu extends Menu {

    private Player [] players = null;
    private static int playMenunum = 4;
    private static String playMenuname = "PlayMenu";
    private static JFrame playMenuJFrame = null;
    private Board board = null;
    private JLayeredPane layeredPane = null;
    private GameManager gm = null;


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
        gm = new GameManager(players);
        board = gm.getBoard();
        createJFrame();
    }

    public PlayMenu(JFrame jFrame, Player[] players, GameManager gm){
        this.players = players;
        playMenuJFrame = jFrame;
        this.gm = gm;
        createJFrame();
    }

    @Override
    public void createJFrame() {

       JPanel panel = new JPanel();
       playMenuJFrame.setContentPane(board.getBoardPanel());
       layeredPane = board.getLayeredPane();

        /*
        Player pl = new Player("Red");
        Piece p = new Piece(COLORS.Red);

        p.getPieceLabel().setSize(40,40);
        Point origin = new Point(295, 458);
        p.getPieceLabel().setLocation(origin);

        pl.getPieces()[1].getPieceLabel().setSize(40,40);
        Point og = new Point(260, 114);
        pl.getPieces()[1].getPieceLabel().setLocation(og);

        layeredPane.add(p.getPieceLabel());
        layeredPane.add(pl.getPieces()[1].getPieceLabel());
        */


        playMenuJFrame.add(layeredPane);



        /*
        board.getBoard_label().setLayout( new BorderLayout() );
        board.getBoard_label().add();
        playMenuJFrame.setContentPane(board.getBoard_label());
        */








        /*

        //board.getBoardPanel().setLayout(new OverlayLayout(board.getBoardPanel()));
        Piece p = new Piece(COLORS.Red);
        p.getPieceLabel().setAlignmentX(0.5f);
        p.getPieceLabel().setAlignmentY(10f);

        JPanel p1 = new JPanel();
        p1.add(p.getPieceLabel());

        board.getBoardPanel().add(BorderLayout.SOUTH, p1);
        playMenuJFrame.getContentPane().add(BorderLayout.CENTER, board.getBoardPanel());
        */
        playMenuJFrame.setSize(600,600);
        playMenuJFrame.setResizable(false);
        playMenuJFrame.setVisible(true);
    }
}



/*
 * Coordinates for all spaces.
 *
 *
 * [0] - 25: (278, 27)
 * [1] - 24: (260, 56), 26: (295, 56)
 * [2] - 23: (244, 85), 25: (278, 85), 27 (311, 85)
 * [3] - 22: (225, 114), 24: (260, 114), 26: (295, 114), 28: (330, 114)
 * [4] - 13: (76, 143), 15: (111, 143), 17: (142, 143), 19: (175, 143), 21: (208, 143), 23: (244, 143), 25: (277, 143), 27: (312, 143), 29: (346, 143), 31: (381, 143), 33: (416, 143), 35: (449, 143), 37: (484, 143)
 * [5] - 14: (87, 171), 16: (120, 171), 18: (155, 171), 20: (190, 171), 22: (225, 171), 24: (260, 171), 26: (295, 171), 28: (330, 171), 30: (365, 171), 32: (400, 171), 34: (435, 171), 36: (470, 171)
 * [6] - 15: (111, 200), 17: (142, 200), 19: (175, 200), 21: (208, 200), 23: (244, 200), 25: (279, 200), 27: (312, 200), 29: (348, 200), 31: (383, 200), 33: (415, 200), 35: (449, 200)
 * [7] - 16: (120, 229), 18: (155, 229), 20: (190, 229), 22: (225, 229), 24: (260, 229), 26: (295, 229), 28: (330, 229), 30: (365, 229), 32: (400, 229), 34: (435, 229)
 *  8 is the mirror line, as it's sequence is not repeated
 * [8] - 17: (144, 258), 19: (175, 258)6, 21: (208, 258), 23: (244, 258), 25: (279, 258), 27: (312, 258), 29: (348, 258), 31: (383, 258), 33: (415, 258)
 *  8 is the mirror line, as it's sequence is not repeated
 * [9] - 16: (120, 287), 18: (155, 287), 20: (190, 287), 22: (225, 287), 24: (260, 287), 26: (295, 287), 28: (330, 287), 30: (365, 287), 32: (400, 287), 34: (435, 287)
 * [10] - 15: (111, 313), 17: (142, 313), 19: (175, 313), 21: (208, 313), 23: (244, 313), 25: (277, 313), 27: (312, 313), 29: (346, 313), 31: (381, 313), 33: (416, 313), 35: (449, 313)
 * [11] - 14: (87, 343), 16: (120, 343), 18: (155, 343), 20: (190, 343), 22: (225, 343), 24: (260, 343), 26: (295, 343), 28: (330, 343), 30: (365, 343), 32: (400, 343), 34: (435, 343), 36: (470, 343)
 * [12] - 13: (76, 370), 15: (111, 370), 17: (142, 370), 19: (176, 370), 21: (210, 370), 23: (245, 370), 25: (279, 370), 27: (313, 370), 29: (348, 370), 31: (383, 370), 33: (416, 370), 35: (450, 370), 37: (485, 370)
 * [13] - 22: (225, 400), 24: (260, 400), 26: (295, 400), 28: (330, 400)
 * [14] - 23: (244, 427), 25: (278, 427), 27 (311, 427)
 * [15] - 24: (260, 458), 26: (295, 458)
 * [16] - 25: (278, 484)
 *
 * */