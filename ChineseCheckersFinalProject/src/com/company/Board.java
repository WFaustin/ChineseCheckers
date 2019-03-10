package com.company;

import javax.swing.*;

public class Board {

    private BoardTileState [][] board = null;
    private COLORS [][] board_color = null;
    private ImageIcon board_image = new ImageIcon("C:\\Users\\maste\\Documents\\ChineseCheckers\\ChineseCheckersFinalProject\\src\\com\\company\\ChineseCheckersArt\\Chinese Checkers Board.png");
    private JLabel board_label = new JLabel(board_image);
    private BoardPanel boardPanel = new BoardPanel();
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

    private void CreateBoard(){
        BoardTileState[][] newboard = new BoardTileState[17][51];
        board_color = new COLORS[17][51];
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


        /*
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
        */
    }



}
