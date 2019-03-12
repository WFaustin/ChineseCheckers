package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameManager {

    private Game game = null;
    private int nop = 2;
    private boolean trueforteam = false;
    private Player [] players = null;
    private Board board = new Board();
    private JLayeredPane layeredPane = null;
    private Point [] origins = new Point[6];

    public GameManager(){
        game = new Game();
    }

    public GameManager(Player [] p){
        players = p;
        layeredPane = board.getLayeredPane();
        SetTurnOrder();
    }


    public void SetTurnOrder(){
        Player [] playerturnorder = new Player[players.length];
        for (int i = 0; i < players.length; i++){
            playerturnorder[i] = players[players.length-i-1];
            System.out.println(playerturnorder[i].getName());
            System.out.println(playerturnorder[i].getColor());
        }
        players = playerturnorder;
        initializeGame();
    }

    public Board getBoard() {
        return board;
    }

    public void initializeGame(){
        if (players.length == 3){

        }
        else {
            for (int i = 0; i < players.length; i++) {
                Point [] points = board.getRegions(i);
                for (int j = 0; j < players[i].getPieces().length; j++){
                    players[i].getPieces()[j].getPieceLabel().setSize(40,40);
                    System.out.println(points[j].getX());
                    players[i].getPieces()[j].getPieceLabel().setLocation(board.getBoard_location()[(int)points[j].getX()][(int)points[j].getY()]);
                    board.getBoard()[(int)points[j].getX()][(int)points[j].getY()] = Board.BoardTileState.F;
                    //board.getBoard_color()[(int)points[j].getX()][(int)points[j].getY()] = players[i].getColor();
                    layeredPane.add(players[i].getPieces()[j].getPieceLabel());
                    board.getLayeredPane().addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (game == null){
                                StartGame();
                            }
                            else{

                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                }

            }
        }
        //Need to set up pieces properly.
    }


    public void StartGame(){
        game = new Game(board, players);
    }

    public boolean winConditions(){

        return true;
    }


}

