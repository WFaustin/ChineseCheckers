package com.company;

import javax.swing.*;

public class GameManager {

    private Game game = null;
    private int nop = 2;
    private boolean trueforteam = false;
    private Player [] players = null;
    private Board board = new Board();
    private JLayeredPane layeredPane = null;

    public GameManager(){
        game = new Game();
    }

    public GameManager(Board b, Player [] p){
        board = b;
        players = p;
        layeredPane = b.getLayeredPane();
        SetTurnOrder();
    }


    public void SetTurnOrder(){
        Player [] playerturnorder = new Player[players.length];
        for (int i = 0; i < players.length; i++){
            playerturnorder[i] = players[players.length-i-1];
            System.out.println(playerturnorder[i].getName());
        }
        players = playerturnorder;
    }

    public void initializeGame(){
        //Need to set up pieces properly.
    }

    public boolean winConditions(){

        return true;
    }


}

