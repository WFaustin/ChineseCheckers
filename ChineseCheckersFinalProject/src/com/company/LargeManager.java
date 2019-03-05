package com.company;

public class LargeManager {

    private MenuManager menuManager = null;
    private GameManager gameManager = null;


    public LargeManager(){
        menuManager = new MenuManager();
        gameManager = new GameManager();
    }

}
