package com.company;


enum COLORS{
    Red, Blue, Green, Yellow, White, Orange, Black, Empty;
}


public class Player {

    private int num;
    private String name;
    private COLORS color;
    private Piece [] pieces = null;


    public Player(){
        color = COLORS.Red;
        name = "P1";
        num = 1;
        setColor(COLORS.Red);
        CreatePieces();
    }

    public Player(String colors){
        name = "P1";
        num = 1;
        setColor(colors);
        CreatePieces();
    }

    public void setColor(String colors){
        if (colors == "red" || colors == "Red"){
            color = COLORS.Red;
        }
        else if (colors == "blue" || colors == "Blue"){
            color = COLORS.Blue;
        }
        else if (colors == "yellow" || colors == "Yellow"){
            color = COLORS.Yellow;
        }
        else if (colors == "green" || colors == "Green"){
            color = COLORS.Green;
        }
        else if (colors == "white" || colors == "White"){
            color = COLORS.White;
        }
        else if (colors == "black" || colors == "Black"){
            color = COLORS.Black;
        }
        else if (colors == "orange" || colors == "Orange"){
            color = COLORS.Orange;
        }
        CreatePieces();
    }

    public void CreatePieces(){
        //creates 10 pieces
        Piece [] newpieces = new Piece[10];
        for (int i = 0; i < 10; i++){
            newpieces[i] = new Piece(color);
        }
        pieces = newpieces;
    }

    public int getNum() {
        return num;
    }

    public String getName(){
        return name;
    }

    public COLORS getColor(){
        return color;
    }

    public void setColor(COLORS color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    public void setPieces(Piece p, int i){
        if (i >= 0 && i < 10){
            pieces[i] = p;
        }
    }
}
