package com.company;

//Games are run by a game manager. They each come with their own rules.
public class Game {

    //private Vector<Player> players = new Vector<Player>();
    //private const int maxnumPlayers = 6;

    //Rules of the game
    /*
    * A piece CANNOT move to a filled or void space. It can only move to an empty space adjacent to it's current position.
    * Players take turns moving pieces.
    * If there is an empty
    *
     */

    private Board board = null;
    private Player [] players = null;
    private boolean isGameContinuing = true;



    public Game(){

    }


    public void playGame(){
        int i = 0;
        int max = players.length - 1;
        while (isGameContinuing == true){
            movePiece(players[i]);
        }
    }


    public void movePiece(Player p){

        //click on a piece of their color.
        //if they do, show all available spots to move.
        //if they dont, wait until they click one of their pieces
        //if there are no available spaces to move, wait until they click another of their pieces, and repeat that process.
        //if there is an available space, highlight it with their color on the available spaces.
        //if they click on one of those spots, move the piece to the spot, and check if they can move again.
        //if they dont click on one of those spots, make the spots disappear, and repeat the process again.
        //If they can move again, highlight places that piece can move, if they click somewhere else, their turn ends, if they click one of those spots, move the piece and continue the process.
        //Go to next player.
    }

    //Rules


}
