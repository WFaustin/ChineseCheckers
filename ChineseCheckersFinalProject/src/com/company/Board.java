package com.company;

import javax.swing.*;
import java.awt.*;

public class Board {

    private BoardTileState [][] board = null;
    private COLORS [][] board_color = null;
    private Point[][] board_location = null;
    private ImageIcon board_image = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Board.png");
    private JLabel board_label = new JLabel(board_image);
    private BoardPanel boardPanel = new BoardPanel();
    private JLayeredPane layeredPane = new JLayeredPane();
    //Voided, Filled, Empty
    public enum BoardTileState{
        V, F, E;
    }

    public Board(){
        board_label.setIcon(board_image);
        CreateBoard();
    }



    public BoardPanel getBoardPanel(){
        return boardPanel;
    }

    public ImageIcon getBoard_image() {
        return board_image;
    }

    public BoardTileState[][] getBoard(){
        return board;
    }

    public COLORS[][] getBoard_color(){
        return board_color;
    }

    public JLabel getBoard_label() {
        return board_label;
    }

    public JLayeredPane getLayeredPane(){
        return layeredPane;
    }



    /*
    * Square Board Configuration
    *
    *
    * [0] - 25
    * [1] - 24, 26
    * [2] - 23, 25, 27
    * [3] - 22, 24, 26, 28
    * [4] - 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37
    * [5] - 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36
    * [6] - 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35
    * [7] - 16, 18, 20, 22, 24, 26, 28, 30, 32, 34
    *  8 is the mirror line, as it's sequence is not repeated
    * [8] - 17, 19, 21, 23, 25, 27, 29, 31, 33
    *  8 is the mirror line, as it's sequence is not repeated
    * [9] - 16, 18, 20, 22, 24, 26, 28, 30, 32, 34
    * [10] - 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35
    * [11] - 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36
    * [12] - 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37
    * [13] - 22, 24, 26, 28
    * [14] - 23, 25, 27
    * [15] - 24, 26
    * [16] - 25
    *
    * */


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

    private void CreateBoard(){



        //Make the board
        BoardTileState[][] newboard = new BoardTileState[17][51];
        for (int i = 0; i < newboard.length; i++){
            for (int j = 0; j < newboard[i].length; j++){
                newboard[i][j] = BoardTileState.V;
            }
        }

        newboard[0][25] = BoardTileState.E;
        newboard[1][24] = BoardTileState.E;
        newboard[1][26] = BoardTileState.E;
        newboard[2][23] = BoardTileState.E;
        newboard[2][25] = BoardTileState.E;
        newboard[2][27] = BoardTileState.E;
        newboard[3][22] = BoardTileState.E;
        newboard[3][24] = BoardTileState.E;
        newboard[3][26] = BoardTileState.E;
        newboard[3][28] = BoardTileState.E;
        newboard[4][13] = BoardTileState.E;
        newboard[4][15] = BoardTileState.E;
        newboard[4][17] = BoardTileState.E;
        newboard[4][19] = BoardTileState.E;
        newboard[4][21] = BoardTileState.E;
        newboard[4][23] = BoardTileState.E;
        newboard[4][25] = BoardTileState.E;
        newboard[4][27] = BoardTileState.E;
        newboard[4][29] = BoardTileState.E;
        newboard[4][31] = BoardTileState.E;
        newboard[4][33] = BoardTileState.E;
        newboard[4][35] = BoardTileState.E;
        newboard[4][37] = BoardTileState.E;
        newboard[5][14] = BoardTileState.E;
        newboard[5][16] = BoardTileState.E;
        newboard[5][18] = BoardTileState.E;
        newboard[5][20] = BoardTileState.E;
        newboard[5][22] = BoardTileState.E;
        newboard[5][24] = BoardTileState.E;
        newboard[5][26] = BoardTileState.E;
        newboard[5][28] = BoardTileState.E;
        newboard[5][30] = BoardTileState.E;
        newboard[5][32] = BoardTileState.E;
        newboard[5][34] = BoardTileState.E;
        newboard[5][36] = BoardTileState.E;
        newboard[6][15] = BoardTileState.E;
        newboard[6][17] = BoardTileState.E;
        newboard[6][19] = BoardTileState.E;
        newboard[6][21] = BoardTileState.E;
        newboard[6][23] = BoardTileState.E;
        newboard[6][25] = BoardTileState.E;
        newboard[6][27] = BoardTileState.E;
        newboard[6][29] = BoardTileState.E;
        newboard[6][31] = BoardTileState.E;
        newboard[6][33] = BoardTileState.E;
        newboard[6][35] = BoardTileState.E;
        newboard[7][16] = BoardTileState.E;
        newboard[7][18] = BoardTileState.E;
        newboard[7][20] = BoardTileState.E;
        newboard[7][22] = BoardTileState.E;
        newboard[7][24] = BoardTileState.E;
        newboard[7][26] = BoardTileState.E;
        newboard[7][28] = BoardTileState.E;
        newboard[7][30] = BoardTileState.E;
        newboard[7][32] = BoardTileState.E;
        newboard[7][34] = BoardTileState.E;
        newboard[8][17] = BoardTileState.E;
        newboard[8][19] = BoardTileState.E;
        newboard[8][21] = BoardTileState.E;
        newboard[8][23] = BoardTileState.E;
        newboard[8][25] = BoardTileState.E;
        newboard[8][27] = BoardTileState.E;
        newboard[8][29] = BoardTileState.E;
        newboard[8][31] = BoardTileState.E;
        newboard[8][33] = BoardTileState.E;
        newboard[9][16] = BoardTileState.E;
        newboard[9][18] = BoardTileState.E;
        newboard[9][20] = BoardTileState.E;
        newboard[9][22] = BoardTileState.E;
        newboard[9][24] = BoardTileState.E;
        newboard[9][26] = BoardTileState.E;
        newboard[9][28] = BoardTileState.E;
        newboard[9][30] = BoardTileState.E;
        newboard[9][32] = BoardTileState.E;
        newboard[9][34] = BoardTileState.E;
        newboard[10][15] = BoardTileState.E;
        newboard[10][17] = BoardTileState.E;
        newboard[10][19] = BoardTileState.E;
        newboard[10][21] = BoardTileState.E;
        newboard[10][23] = BoardTileState.E;
        newboard[10][25] = BoardTileState.E;
        newboard[10][27] = BoardTileState.E;
        newboard[10][29] = BoardTileState.E;
        newboard[10][31] = BoardTileState.E;
        newboard[10][33] = BoardTileState.E;
        newboard[10][35] = BoardTileState.E;
        newboard[11][14] = BoardTileState.E;
        newboard[11][16] = BoardTileState.E;
        newboard[11][18] = BoardTileState.E;
        newboard[11][20] = BoardTileState.E;
        newboard[11][22] = BoardTileState.E;
        newboard[11][24] = BoardTileState.E;
        newboard[11][26] = BoardTileState.E;
        newboard[11][28] = BoardTileState.E;
        newboard[11][30] = BoardTileState.E;
        newboard[11][32] = BoardTileState.E;
        newboard[11][34] = BoardTileState.E;
        newboard[11][36] = BoardTileState.E;
        newboard[12][13] = BoardTileState.E;
        newboard[12][15] = BoardTileState.E;
        newboard[12][17] = BoardTileState.E;
        newboard[12][19] = BoardTileState.E;
        newboard[12][21] = BoardTileState.E;
        newboard[12][23] = BoardTileState.E;
        newboard[12][25] = BoardTileState.E;
        newboard[12][27] = BoardTileState.E;
        newboard[12][29] = BoardTileState.E;
        newboard[12][31] = BoardTileState.E;
        newboard[12][33] = BoardTileState.E;
        newboard[12][35] = BoardTileState.E;
        newboard[12][37] = BoardTileState.E;
        newboard[13][22] = BoardTileState.E;
        newboard[13][24] = BoardTileState.E;
        newboard[13][26] = BoardTileState.E;
        newboard[13][28] = BoardTileState.E;
        newboard[14][23] = BoardTileState.E;
        newboard[14][25] = BoardTileState.E;
        newboard[14][27] = BoardTileState.E;
        newboard[15][24] = BoardTileState.E;
        newboard[15][26] = BoardTileState.E;
        newboard[16][25] = BoardTileState.E;

        board = newboard;


        //Create a board layout for specific coordinate positions that need to be place
        Point [][] pointboard = new Point[17][51];


        pointboard[0][25] = new Point(278, 27);
        pointboard[1][24] = new Point(260, 56);
        pointboard[1][26] = new Point(295, 56);
        pointboard[2][23] = new Point(244, 85);
        pointboard[2][25] = new Point(278, 85);
        pointboard[2][27] = new Point(311, 85);
        pointboard[3][22] = new Point(225, 114);
        pointboard[3][24] = new Point(260, 114);
        pointboard[3][26] = new Point(295, 114);
        pointboard[3][28] = new Point(330, 114);
        pointboard[4][13] = new Point(76, 143);
        pointboard[4][15] = new Point(111, 143);
        pointboard[4][17] = new Point(142, 143);
        pointboard[4][19] = new Point(175, 143);
        pointboard[4][21] = new Point(208, 143);
        pointboard[4][23] = new Point(244, 143);
        pointboard[4][25] = new Point(277, 143);
        pointboard[4][27] = new Point(312, 143);
        pointboard[4][29] = new Point(346, 143);
        pointboard[4][31] = new Point(381, 143);
        pointboard[4][33] = new Point(416, 143);
        pointboard[4][35] = new Point(449, 143);
        pointboard[4][37] = new Point(484, 143);
        pointboard[5][14] = new Point(87, 171);
        pointboard[5][16] = new Point(120, 171);
        pointboard[5][18] = new Point(155, 171);
        pointboard[5][20] = new Point(190, 171);
        pointboard[5][22] = new Point(225, 171);
        pointboard[5][24] = new Point(260, 229);
        pointboard[5][26] = new Point(295, 229);
        pointboard[5][28] = new Point(330, 229);
        pointboard[5][30] = new Point(365, 229);
        pointboard[5][32] = new Point(400, 229);
        pointboard[5][34] = new Point(435, 171);
        pointboard[5][36] = new Point(470, 171);
        pointboard[6][15] = new Point(111, 200);
        pointboard[6][17] = new Point(142, 200);
        pointboard[6][19] = new Point(175, 200);
        pointboard[6][21] = new Point(208, 200);
        pointboard[6][23] = new Point(244, 200);
        pointboard[6][25] = new Point(279, 200);
        pointboard[6][27] = new Point(312, 200);
        pointboard[6][29] = new Point(348, 200);
        pointboard[6][31] = new Point(383, 200);
        pointboard[6][33] = new Point(415, 200);
        pointboard[6][35] = new Point(449, 200);
        pointboard[7][16] = new Point(120, 229);
        pointboard[7][18] = new Point(155, 229);
        pointboard[7][20] = new Point(190, 229);
        pointboard[7][22] = new Point(225, 229);
        pointboard[7][24] = new Point(260, 229);
        pointboard[7][26] = new Point(295, 229);
        pointboard[7][28] = new Point(330, 229);
        pointboard[7][30] = new Point(365, 229);
        pointboard[7][32] = new Point(400, 229);
        pointboard[7][34] = new Point(435, 229);
        pointboard[8][17] = new Point(144, 258);
        pointboard[8][19] = new Point(175, 258);
        pointboard[8][21] = new Point(208, 258);
        pointboard[8][23] = new Point(244, 258);
        pointboard[8][25] = new Point(279, 258);
        pointboard[8][27] = new Point(312, 258);
        pointboard[8][29] = new Point(348, 258);
        pointboard[8][31] = new Point(383, 258);
        pointboard[8][33] = new Point(415, 258);
        pointboard[9][16] = new Point(120, 287);
        pointboard[9][18] = new Point(155, 287);
        pointboard[9][20] = new Point(190, 287);
        pointboard[9][22] = new Point(225, 287);
        pointboard[9][24] = new Point(260, 287);
        pointboard[9][26] = new Point(295, 287);
        pointboard[9][28] = new Point(330, 287);
        pointboard[9][30] = new Point(365, 287);
        pointboard[9][32] = new Point(400, 287);
        pointboard[9][34] = new Point(435, 287);
        pointboard[10][15] = new Point(111, 313);
        pointboard[10][17] = new Point(142, 313);
        pointboard[10][19] = new Point(175, 313);
        pointboard[10][21] = new Point(208, 313);
        pointboard[10][23] = new Point(244, 313);
        pointboard[10][25] = new Point(277, 313);
        pointboard[10][27] = new Point(312, 313);
        pointboard[10][29] = new Point(346, 313);
        pointboard[10][31] = new Point(381, 313);
        pointboard[10][33] = new Point(416, 313);
        pointboard[10][35] = new Point(449, 313);
        pointboard[11][14] = new Point(87, 343);
        pointboard[11][16] = new Point(120, 343);
        pointboard[11][18] = new Point(155, 343);
        pointboard[11][20] = new Point(190, 343);
        pointboard[11][22] = new Point(225, 343);
        pointboard[11][24] = new Point(260, 343);
        pointboard[11][26] = new Point(295, 343);
        pointboard[11][28] = new Point(330, 343);
        pointboard[11][30] = new Point(365, 343);
        pointboard[11][32] = new Point(400, 343);
        pointboard[11][34] = new Point(435, 343);
        pointboard[11][36] = new Point(470, 343);
        pointboard[12][13] = new Point(76, 370);
        pointboard[12][15] = new Point(111, 370);
        pointboard[12][17] = new Point(142, 370);
        pointboard[12][19] = new Point(176, 370);
        pointboard[12][21] = new Point(210, 370);
        pointboard[12][23] = new Point(245, 370);
        pointboard[12][25] = new Point(279, 370);
        pointboard[12][27] = new Point(313, 370);
        pointboard[12][29] = new Point(348, 370);
        pointboard[12][31] = new Point(383, 370);
        pointboard[12][33] = new Point(416, 370);
        pointboard[12][35] = new Point(450, 370);
        pointboard[12][37] = new Point(485, 370);
        pointboard[13][22] = new Point(225, 400);
        pointboard[13][24] = new Point(260, 400);
        pointboard[13][26] = new Point(295, 400);
        pointboard[13][28] = new Point(330, 400);
        pointboard[14][23] = new Point(244, 427);
        pointboard[14][25] = new Point(278, 427);
        pointboard[14][27] = new Point(311, 427);
        pointboard[15][24] = new Point(260, 458);
        pointboard[15][26] = new Point(295, 458);
        pointboard[16][25] = new Point(278, 484);

        board_location = pointboard;

        //Making LayeredPane
        layeredPane.setPreferredSize(new Dimension(600, 600));

        //Set the regions of the board for win conditions.
        setRegions();

        /*
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
        */
    }


    public void setRegions(){
        //North - set

    }



}
