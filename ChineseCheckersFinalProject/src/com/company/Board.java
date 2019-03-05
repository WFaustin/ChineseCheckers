package com.company;

public class Board {

    //Voided, Filled, Empty
    public enum BoardTileState{
        V, F, E;
    }

    public Board(){
        CreateBoard();
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
        BoardTileState[][] board = new BoardTileState[17][51];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = BoardTileState.V;
            }
        }

        board[0][25] = BoardTileState.E;
        board[1][24] = BoardTileState.E;
        board[1][26] = BoardTileState.E;
        board[2][23] = BoardTileState.E;
        board[2][25] = BoardTileState.E;
        board[2][27] = BoardTileState.E;
        board[3][22] = BoardTileState.E;
        board[3][24] = BoardTileState.E;
        board[3][26] = BoardTileState.E;
        board[3][28] = BoardTileState.E;
        board[4][13] = BoardTileState.E;
        board[4][15] = BoardTileState.E;
        board[4][17] = BoardTileState.E;
        board[4][19] = BoardTileState.E;
        board[4][21] = BoardTileState.E;
        board[4][23] = BoardTileState.E;
        board[4][25] = BoardTileState.E;
        board[4][27] = BoardTileState.E;
        board[4][29] = BoardTileState.E;
        board[4][31] = BoardTileState.E;
        board[4][33] = BoardTileState.E;
        board[4][35] = BoardTileState.E;
        board[4][37] = BoardTileState.E;
        board[5][14] = BoardTileState.E;
        board[5][16] = BoardTileState.E;
        board[5][18] = BoardTileState.E;
        board[5][20] = BoardTileState.E;
        board[5][22] = BoardTileState.E;
        board[5][24] = BoardTileState.E;
        board[5][26] = BoardTileState.E;
        board[5][28] = BoardTileState.E;
        board[5][30] = BoardTileState.E;
        board[5][32] = BoardTileState.E;
        board[5][34] = BoardTileState.E;
        board[5][36] = BoardTileState.E;
        board[6][15] = BoardTileState.E;
        board[6][17] = BoardTileState.E;
        board[6][19] = BoardTileState.E;
        board[6][21] = BoardTileState.E;
        board[6][23] = BoardTileState.E;
        board[6][25] = BoardTileState.E;
        board[6][27] = BoardTileState.E;
        board[6][29] = BoardTileState.E;
        board[6][31] = BoardTileState.E;
        board[6][33] = BoardTileState.E;
        board[6][35] = BoardTileState.E;
        board[7][16] = BoardTileState.E;
        board[7][18] = BoardTileState.E;
        board[7][20] = BoardTileState.E;
        board[7][22] = BoardTileState.E;
        board[7][24] = BoardTileState.E;
        board[7][26] = BoardTileState.E;
        board[7][28] = BoardTileState.E;
        board[7][30] = BoardTileState.E;
        board[7][32] = BoardTileState.E;
        board[7][34] = BoardTileState.E;
        board[8][17] = BoardTileState.E;
        board[8][19] = BoardTileState.E;
        board[8][21] = BoardTileState.E;
        board[8][23] = BoardTileState.E;
        board[8][25] = BoardTileState.E;
        board[8][27] = BoardTileState.E;
        board[8][29] = BoardTileState.E;
        board[8][31] = BoardTileState.E;
        board[8][33] = BoardTileState.E;
        board[9][16] = BoardTileState.E;
        board[9][18] = BoardTileState.E;
        board[9][20] = BoardTileState.E;
        board[9][22] = BoardTileState.E;
        board[9][24] = BoardTileState.E;
        board[9][26] = BoardTileState.E;
        board[9][28] = BoardTileState.E;
        board[9][30] = BoardTileState.E;
        board[9][32] = BoardTileState.E;
        board[9][34] = BoardTileState.E;
        board[10][15] = BoardTileState.E;
        board[10][17] = BoardTileState.E;
        board[10][19] = BoardTileState.E;
        board[10][21] = BoardTileState.E;
        board[10][23] = BoardTileState.E;
        board[10][25] = BoardTileState.E;
        board[10][27] = BoardTileState.E;
        board[10][29] = BoardTileState.E;
        board[10][31] = BoardTileState.E;
        board[10][33] = BoardTileState.E;
        board[10][35] = BoardTileState.E;
        board[11][14] = BoardTileState.E;
        board[11][16] = BoardTileState.E;
        board[11][18] = BoardTileState.E;
        board[11][20] = BoardTileState.E;
        board[11][22] = BoardTileState.E;
        board[11][24] = BoardTileState.E;
        board[11][26] = BoardTileState.E;
        board[11][28] = BoardTileState.E;
        board[11][30] = BoardTileState.E;
        board[11][32] = BoardTileState.E;
        board[11][34] = BoardTileState.E;
        board[11][36] = BoardTileState.E;
        board[12][13] = BoardTileState.E;
        board[12][15] = BoardTileState.E;
        board[12][17] = BoardTileState.E;
        board[12][19] = BoardTileState.E;
        board[12][21] = BoardTileState.E;
        board[12][23] = BoardTileState.E;
        board[12][25] = BoardTileState.E;
        board[12][27] = BoardTileState.E;
        board[12][29] = BoardTileState.E;
        board[12][31] = BoardTileState.E;
        board[12][33] = BoardTileState.E;
        board[12][35] = BoardTileState.E;
        board[12][37] = BoardTileState.E;
        board[13][22] = BoardTileState.E;
        board[13][24] = BoardTileState.E;
        board[13][26] = BoardTileState.E;
        board[13][28] = BoardTileState.E;
        board[14][23] = BoardTileState.E;
        board[14][25] = BoardTileState.E;
        board[14][27] = BoardTileState.E;
        board[15][24] = BoardTileState.E;
        board[15][26] = BoardTileState.E;
        board[16][25] = BoardTileState.E;


        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length ; j++){
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

    }


}
