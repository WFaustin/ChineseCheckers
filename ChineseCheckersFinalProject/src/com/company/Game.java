package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private GameManager g = null;
    private Player [] players = null;
    private boolean isGameContinuing = true;
    private int playerturncounter = 0;
    private Piece piq = null;
    private Vector<Piece> pieceafterimages = new Vector<Piece>(13);
    private int afterimageselected = 0;
    private boolean hasJumpMoved = false;
    private Player winner = null;
    private Point lastPieceJumped = null;
    private JButton button = null;
    private Vector<Point> lastPiecesJumped = new Vector<Point>();


    public Game(){

    }

    public Game(Board b, Player [] p){
        ReplenishVector();
        board = b;
        players = p;
        playGame();
    }

    public Game(Board b, Player [] p, GameManager g){
        ReplenishVector();
        board = b;
        players = p;
        this.g = g;
        board.getLayeredPane().setFocusTraversalKeysEnabled(false);
        playGame();
    }

    public Game(Board b, Player [] p, GameManager g, JButton jb){
        ReplenishVector();
        board = b;
        players = p;
        this.g = g;
        button = jb;
        playGame();
    }


    public void ReplenishVector(){
        for (int i = 0; i < pieceafterimages.size(); i++){
            if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0){
                board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
            }
        }
        for (int i = 0; i < 13; i++){
            pieceafterimages.add(new Piece(COLORS.Red));
        }
        for (int i = 0; i < 13; i++){
            pieceafterimages.get(i).getPieceLabel().setLocation(0,0);
        }
    }



    public void CreateButton(){



        /*
        JButton finishturn = new JButton("??? Player Turn");
        finishturn.setBackground(Color.WHITE);
        finishturn.setMaximumSize(new Dimension(90, 90));
        finishturn.setLocation(0, 0);
        board.getLayeredPane().add(finishturn);
        finishturn.addActionListener(new GameButtonListener());
        button = finishturn;
        board.getLayeredPane().repaint();
        */
    }


    public void RenameButton(){
        button.setText(players[playerturncounter].getColor().toString() + " Player Turn");
        board.getLayeredPane().repaint();
    }

    public boolean CheckMovementLine(){

        for (int i = 0; i < 3; i++){
            if (lastPieceJumped != null) {
                if (lastPieceJumped.getX() == lastPiecesJumped.get(i).getX() && lastPieceJumped.getY() == lastPiecesJumped.get(i).getY()) {
                    return true;
                }
            }

        }
        return false;
    }

    public Player getWinner() {
        return winner;
    }

    public void playGame(){
        boolean s = CheckWinState();
        if (s == false){
            playerturncounter = 0;
            movePiece(players[playerturncounter]);
        }
        else{
           g.displayWinner(winner);

        }
    }



    public void continueGame(){
        if (CheckWinState() == false) {
            /*
            for (int i = 0; i < pieceafterimages.size(); i++) {
                if (pieceafterimages.get(i).getPieceLabel().getLocation().getX() != 0) {
                    board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
                }
                pieceafterimages.remove(pieceafterimages.get(i));
            }
            for (int i = 0; i < pieceafterimages.size(); i++) {
                pieceafterimages.remove(i);
            }
            ReplenishVector();
            */
            hasJumpMoved = false;
            for (int i = 0; i < lastPiecesJumped.size(); i++){
                lastPiecesJumped.remove(lastPiecesJumped.get(i));
            }
            lastPieceJumped = null;
            playerturncounter = playerturncounter + 1;
            if (playerturncounter > players.length - 1) {
                playerturncounter = 0;
            }
            movePiece(players[playerturncounter]);
        }
        else {
            System.out.println(winner.getName() + "Help!");
            g.displayWinner(winner);
            //Go back to gameMana
        }
    }



    public boolean CheckWinState(){
        board.getLayeredPane().repaint();
        int s = 0;
        for (int c = 0; c < players.length; c++) {
            for (int i = 0; i < players[c].getPieces().length; i++) {
                if ((checkHelper(players[c].getPieces()[i].getPieceLabel().getLocation(), players[c].winRegions)) == true) {
                    s++;
                }
                if (s == 10){
                    winner = players[c];
                    return true;
                }
                else {
                    s = 0;
                }
            }
        }
        return false;

    }

    private boolean checkHelper(Point p, Point [] q){
        for (int i = 0; i < q.length; i++){
            if (p.getY() == board.getBoard_location()[(int)q[i].getX()][(int)q[i].getY()].getY() && p.getX() == board.getBoard_location()[(int)q[i].getX()][(int)q[i].getY()].getX()){
                return true;
            }
        }
        return false;
    }


    public void movePiece(Player p){

        for (int i = 0; i < p.getPieces().length; i++){
            final int v = i;
            int x = 0;
            p.getPieces()[i].getPieceLabel().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(p.getPieces()[v].getColor());
                    System.out.println(players[playerturncounter].getColor());
                    System.out.println(playerturncounter);

                    if (p.getPieces()[v].getColor() == players[playerturncounter].getColor()) {
                        piq = p.getPieces()[v];
                        CalculateValidMove(p.getPieces()[v]);
                        System.out.println(p.getPieces()[v].getPieceLabel().getLocation());
                        for (int j = 0; j < p.getPieces().length; j++){
                            p.getPieces()[j].getPieceLabel().removeMouseListener(this);
                        }
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
            if (i == 21){

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

        //Big if statement checking if ANY of these moves are valid.
        if((board.getBoard()[first + 1][second + 1] == Board.BoardTileState.E && hasJumpMoved == false) || (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.E && hasJumpMoved == false) ||
                (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.E && hasJumpMoved == false) || (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.E && hasJumpMoved == false) ||
                (board.getBoard()[first][second + 2] == Board.BoardTileState.E && hasJumpMoved == false) || (board.getBoard()[first][second - 2] == Board.BoardTileState.E && hasJumpMoved == false) ||
                (board.getBoard()[first + 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 2][second + 2]) == true) || (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first - 2][second + 2]) == true) ||
                (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 2][second - 2]) == true) || (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first - 2][second - 2]) == true) ||
                (board.getBoard()[first][second - 2] == Board.BoardTileState.F && board.getBoard()[first][second - 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second - 4]) == true) || (board.getBoard()[first][second + 2] == Board.BoardTileState.F && board.getBoard()[first][second + 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 2][second + 2]) == true)) {

            if (board.getBoard()[first + 1][second + 1] == Board.BoardTileState.E && hasJumpMoved == false) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first + 1][second + 1]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f + 1][s + 1]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f + 1][s + 1] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
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
            }

            if (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.E && hasJumpMoved == false) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first - 1][second + 1]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f - 1][s + 1]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f - 1][s + 1] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
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
            }

            if (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.E && hasJumpMoved == false) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first - 1][second - 1]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f - 1][s - 1]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f - 1][s - 1] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
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
            }

            if (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.E && hasJumpMoved == false) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first + 1][second - 1]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f + 1][s - 1]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f + 1][s - 1] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
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
            }

            if (board.getBoard()[first][second + 2] == Board.BoardTileState.E && hasJumpMoved == false) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first][second + 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f][s + 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f][s + 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
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
            }

            if (board.getBoard()[first][second - 2] == Board.BoardTileState.E && hasJumpMoved == false) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first][second - 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f][s - 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f][s - 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
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
            }

            if (board.getBoard()[first + 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 1][second + 1]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first + 2][second + 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f + 2][s + 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f + 2][s + 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = p.getPieceLabel().getLocation();
                        lastPiecesJumped.add(board.getBoard_location()[f+1][s+1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first - 1][second + 1]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first - 2][second + 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f - 2][s + 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f - 2][s + 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = p.getPieceLabel().getLocation();
                        lastPiecesJumped.add(board.getBoard_location()[f-1][s+1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 1][second - 1]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first + 2][second - 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f + 2][s - 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f + 2][s - 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = p.getPieceLabel().getLocation();
                        lastPiecesJumped.add(board.getBoard_location()[f+1][s-1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first - 1][second - 1]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first - 2][second - 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f - 2][s - 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f - 2][s - 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = p.getPieceLabel().getLocation();
                        lastPiecesJumped.add(board.getBoard_location()[f-1][s-1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first][second + 2] == Board.BoardTileState.F && board.getBoard()[first][second + 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second + 2]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first][second + 4]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f][s + 4]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f][s + 4] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPiecesJumped.add(board.getBoard_location()[f][s+2]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first][second - 2] == Board.BoardTileState.F && board.getBoard()[first][second - 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second - 2]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first][second - 4]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f][s - 4]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f][s - 4] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = p.getPieceLabel().getLocation();
                        lastPiecesJumped.add(board.getBoard_location()[f][s-2]);
                        CalculateValidJumpMoves(p);

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
        else{
           continueGame();
        }

    }


    public void CalculateValidJumpMoves(Piece p){
        int first = 0;
        int second = 0;

        outerloop:
        for (int i = 0; i < board.getBoard_location().length; i++){
            if (i == 21){

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
        if ((board.getBoard()[first + 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 2][second + 2]) == true && CheckPieceMoved(p, first, second) == false) || (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first - 2][second + 2]) == true && CheckPieceMoved(p, first, second) == false) ||
                (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 2][second - 2]) == true && CheckPieceMoved(p, first, second) == false) || (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first - 2][second - 2]) == true && CheckPieceMoved(p, first, second) == false) ||
                (board.getBoard()[first][second - 2] == Board.BoardTileState.F && board.getBoard()[first][second - 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second - 4]) == true && CheckPieceMoved(p, first, second) == false) || (board.getBoard()[first][second + 2] == Board.BoardTileState.F && board.getBoard()[first][second + 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first + 2][second + 2]) == true && CheckPieceMoved(p, first, second) == false)) {


            if (board.getBoard()[first + 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first + 2][second + 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                p.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("hi");
                        p.getPieceLabel().removeMouseListener(this);
                        board.getLayeredPane().repaint();
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
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f + 2][s + 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f + 2][s + 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = board.getBoard_location()[f][s];
                        lastPiecesJumped.add(board.getBoard_location()[f + 1][s + 1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first - 1][second + 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second + 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first - 2][second + 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                p.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("hi");
                        p.getPieceLabel().removeMouseListener(this);
                        board.getLayeredPane().repaint();
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
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f - 2][s + 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f - 2][s + 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = board.getBoard_location()[f][s];
                        lastPiecesJumped.add(board.getBoard_location()[f - 1][s + 1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first + 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first + 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first + 2][second - 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                p.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("hi");
                        p.getPieceLabel().removeMouseListener(this);
                        board.getLayeredPane().repaint();
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
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f + 2][s - 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f + 2][s - 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = board.getBoard_location()[f][s];
                        lastPiecesJumped.add(board.getBoard_location()[f + 1][s - 1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first - 1][second - 1] == Board.BoardTileState.F && board.getBoard()[first - 2][second - 2] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first - 2][second - 2]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                p.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("hi");
                        p.getPieceLabel().removeMouseListener(this);
                        board.getLayeredPane().repaint();
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
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f - 2][s - 2]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f - 2][s - 2] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = board.getBoard_location()[f][s];
                        lastPiecesJumped.add(board.getBoard_location()[f - 1][s - 1]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first][second + 2] == Board.BoardTileState.F && board.getBoard()[first][second + 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first][second + 4]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                p.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("hi");
                        p.getPieceLabel().removeMouseListener(this);
                        board.getLayeredPane().repaint();
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
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f][s + 4]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f][s + 4] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = board.getBoard_location()[f][s];
                        lastPiecesJumped.add(board.getBoard_location()[f][s + 2]);
                        CalculateValidJumpMoves(p);
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

            if (board.getBoard()[first][second - 2] == Board.BoardTileState.F && board.getBoard()[first][second - 4] == Board.BoardTileState.E && CheckifinTrain(board.getBoard_location()[first][second]) == true) {
                Piece piece = new Piece("afterimage", p.getColor());
                piece.getPieceLabel().setSize(40, 40);
                piece.getPieceLabel().setLocation(board.getBoard_location()[first][second - 4]);
                pieceafterimages.add(piece);
                final int f = first;
                final int s = second;
                board.getLayeredPane().add(piece.getPieceLabel());
                p.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("hi");
                        p.getPieceLabel().removeMouseListener(this);
                        board.getLayeredPane().repaint();
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
                piece.getPieceLabel().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeIfClicked(piece);
                        pieceafterimages.remove(piece);
                        p.getPieceLabel().setLocation(board.getBoard_location()[f][s - 4]);
                        board.getLayeredPane().repaint();
                        board.getBoard()[f][s - 4] = Board.BoardTileState.F;
                        board.getBoard()[f][s] = Board.BoardTileState.E;
                        removedIfNotClicked();
                        piece.getPieceLabel().removeMouseListener(this);
                        hasJumpMoved = true;
                        lastPieceJumped = board.getBoard_location()[f][s];
                        lastPiecesJumped.add(board.getBoard_location()[f][s - 2]);
                        CalculateValidJumpMoves(p);
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
        else{
            continueGame();
        }


    }



    public void removeIfClicked(Piece p){
        board.getLayeredPane().remove(p.getPieceLabel());

        board.getLayeredPane().repaint();
    }

    public void removedIfNotClicked(){
        for (int i = 0; i < pieceafterimages.size(); i++){
            if (pieceafterimages.get(i).getPieceLabel().getParent() == board.getLayeredPane()){
                board.getLayeredPane().remove(pieceafterimages.get(i).getPieceLabel());
            }
        }
        board.getLayeredPane().repaint();
    }

    public boolean CheckifinTrain(Point pt){
        for (int i = 0; i < lastPiecesJumped.size(); i++){
            if(pt.getX() == lastPiecesJumped.get(i).getX() && pt.getY() == lastPiecesJumped.get(i).getY()){
                return false;
            }
        }
        return true;

    }

    public boolean CheckPieceMoved(Piece p, int first, int second){
        if (board.getBoard_location()[first][second] == null){
            return false;
        }
        else if(lastPieceJumped == null){
            return false;
        }
        else {
            if (lastPieceJumped.getX() == board.getBoard_location()[first][second].getX() && lastPieceJumped.getY() == board.getBoard_location()[first][second].getY()) {
                return false;
            } else {
                return true;
            }
        }

    }

    //Rules


}
