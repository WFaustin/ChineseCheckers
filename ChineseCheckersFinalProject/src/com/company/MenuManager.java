package com.company;

import javax.swing.*;

public class MenuManager {

    private int currentmenuNumber = -1;
    private String currentmenuName = "placeholder menu";
    private JFrame jFrame = new JFrame();
    private MenuNavigator menuNavigator = new MenuNavigator();


    private Menu menu = null;

    public MenuManager(){
        menu = new MainMenu(jFrame, menuNavigator);
        menuNavigator = new MenuNavigator(menu);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
    }



    public MenuManager(int num){
        currentmenuNumber = num;
    }

    /*
    public void MakeMenu(int num, JFrame jFrame){
        jFrame.removeAll();
        if (num == 0){
            menu = new MainMenu(jFrame);
        }
        else if (num == 1) {
            menu = new RulesMenu(jFrame);
        }
        else {

        }
    }
    */

}
