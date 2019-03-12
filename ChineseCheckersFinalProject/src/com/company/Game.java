package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

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
    private int playerturncounter = 0;
    private Piece piq = null;
    private Vector<Piece> pieceafterimages = new Vector<Piece>(13);
    private int afterimageselected = 0;
    private boolean hasMoved = false;


    public Game(){

    }

    public Game(Board b, Player [] p){
        ReplenishVector();
        board = b;
        players = p;
        playGame();
    }


    public void ReplenishVector(){
        for (int i = 0; i < 13; i++){
            pieceafterimages.add(new Piece(COLORS.Red));
        }
        for (int i = 0; i < 13; i++){
            pieceafterimages.get(i).getPieceLabel().setLocation(0,0);
        }
    }


    public void playGame(){
        playerturncounter = 0;
        movePiece(players[playerturncounter]);
        //while (isGameContinuing == true){
            //movePiece(players[playerturncounter]);
            /*
            if (hasMoved == false){
            }

            if(CheckWinState() == true){
                isGameContinuing = false;
            }
            else{
                //++playerturncounter;
                if (playerturncounter > max){
                    playerturncounter = 0;
                }
            }
            //sleep(2000);
            isGameContinuing = false;
            */
        //}
    }

    public void continueGame(){
        playerturncounter = playerturncounter + 1;
        if (playerturncounter > players.length - 1){
            playerturncounter = 0;
        }
        movePiece(players[playerturncounter]);
    }


    public boolean CheckWinState(){
        if(CheckNorthWinState() == true){
            return true;
        }
        if(CheckNorthEastWinState() == true){
            return true;
        }
        if(CheckNorthWestWinState() == true){
            return true;
        }
        if(CheckSouthWinState() == true){
            return true;
        }
        if(CheckSouthWestWinState() == true){
            return true;
        }
        if(CheckSouthEastWinState() == true){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean CheckNorthWinState(){

        return false;
    }

    public boolean CheckNorthWestWinState(){

        return false;
    }

    public boolean CheckNorthEastWinState(){

        return false;
    }

    public boolean CheckSouthWinState(){

        return false;
    }

    public boolean CheckSouthWestWinState(){

        return false;
    }

    public boolean CheckSouthEastWinState(){

        return false;
    }


    public void movePiece(Player p){

        for (int i = 0; i < p.getPieces().length; i++){
            final int v = i;
            p.getPieces()[i].getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(p.getPieces()[v].getColor());
                    System.out.println(players[playerturncounter].getColor());
                    System.out.println(playerturncounter);

                    if (p.getPieces()[v].getColor() == players[playerturncounter].getColor()) {
                        piq = p.getPieces()[v];
                        CalculateValidMove(p.getPieces()[v]);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
            });
        }
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

    public void CalculateValidMove(Piece p){
        //get Value (Point Location) of piece clicked.
        //get all possible piece end locations and put them into an array.
        //iterate through all of them, and check if there are pieces in those positions in the board (Board Tile State) - not V or F.
        //if they can be moved there, then take that position, and reveal that pieces color in that spot.

        int first = 0;
        int second = 0;

        outerloop:
        for (int i = 0; i < board.getBoard_location().length; i++){
            if (i == 17){

            }
            else {
                for (int j = 0; j < board.getBoard_location()[i].length; j++) {
                    if (board.getBoard_location()[i][j] == null) {
                        //Don't check
                    } else {
                        if (p.getPieceLabel().getLocation().getX() == board.getBoard_location()[i][j].getX() &&  p.getPieceLabel().getLocation().getY() == board.getBoard_location()[i][j].getY()) {
                            first = i;
                            second = j;
                            break outerloop;
                        }
                    }
                }
            }
        }

        //How pieces can move

        if (board.getBoard()[first + 1][second + 1] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first + 1][second + 1]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f + 1][s + 1]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f+1][s+1] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f+1][s+1] = piece.getColor();
                    continueGame();
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
            afterimageselected = 1;
            pieceafterimages.add(afterimageselected, piece);
        }

        if (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first - 1][second + 1]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f - 1][s + 1]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f-1][s+1] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f-1][s+1] = piece.getColor();
                    continueGame();
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
            afterimageselected = 2;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first + 1][second - 1]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f + 1][s - 1]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f+1][s-1] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f+1][s-1] = piece.getColor();
                    continueGame();

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
            afterimageselected = 3;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first - 1][second - 1]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f - 1][s - 1]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f-1][s-1] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f-1][s-1] = piece.getColor();
                    continueGame();

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
            afterimageselected = 4;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first][second + 2] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first][second + 2]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f][s + 2]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f][s+2] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f][s+2] = piece.getColor();
                    continueGame();

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
            afterimageselected = 5;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first][second - 2] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first][second - 2]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f][s - 2]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f][s-2] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f][s-2] = piece.getColor();
                    continueGame();

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
            afterimageselected = 6;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first + 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second + 2] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first + 2][second + 2]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f + 2][s + 2]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f+2][s+2] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f+2][s+2] = piece.getColor();
                    continueGame();

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
            afterimageselected = 7;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second + 2] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first - 2][second + 2]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f - 2][s + 2]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f-2][s+2] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f-1][s+2] = piece.getColor();
                    continueGame();

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
            afterimageselected = 8;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second - 2] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first - 2][second - 2]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f - 2][s - 2]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f-2][s-2] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f-2][s-2] = piece.getColor();
                    continueGame();

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
            afterimageselected = 9;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second - 2] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first + 2][second - 2]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f + 2][s - 2]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f+2][s-2] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f+2][s-2] = piece.getColor();
                    continueGame();

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
            afterimageselected = 10;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first][second - 2] == Board.BoardTileState.F && board.getBoard()[first][second - 4] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first][second - 4]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f][s - 4]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f][s-4] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f][s-4] = piece.getColor();
                    continueGame();
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
            afterimageselected = 11;
            pieceafterimages.add(afterimageselected, piece);
        }
        if (board.getBoard()[first][second + 2] == Board.BoardTileState.F && board.getBoard()[first][second + 4] == Board.BoardTileState.E){
            Piece piece = new Piece("afterimage", p.getColor());
            piece.getPieceLabel().setSize(40,40);
            piece.getPieceLabel().setLocation(board.getBoard_location()[first][second + 4]);
            board.getLayeredPane().add(piece.getPieceLabel());
            final int f = first;
            final int s = second;
            piece.getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    p.getPieceLabel().setLocation(board.getBoard_location()[f][s + 4]);
                    //board.getLayeredPane().remove(piece.getPieceLabel());
                    for (int i = 0; i < pieceafterimages.size(); i++) {
                        if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                            board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                        }
                        pieceafterimages.remove(pieceafterimages.get(i));

                    }
                    ReplenishVector();
                    board.getBoard()[f][s+4] = Board.BoardTileState.F;
                    board.getBoard()[f][s] = Board.BoardTileState.E;
                    board.getBoard_color()[f][s+4] = piece.getColor();
                    continueGame();
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
            afterimageselected = 12;
            pieceafterimages.add(afterimageselected, piece);

        }


    }


    public void sleep(int num){
        try{
            Thread.sleep(num);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    //Rules


}
