package com.company;

import javax.swing.*;

public class MenuNavigator {

    private Menu currentmenu = null;

    public MenuNavigator(){

    }

    public MenuNavigator(Menu menu){
        currentmenu = menu;

    }


    public void MakeMenu(int num, JFrame jFrame){

        if (num == 0){
            currentmenu = new MainMenu(jFrame);
        }
        else if (num == 1) {
            currentmenu = new RulesMenu(jFrame);
        }
        else if(num == 2){
            currentmenu = new PlaySetupMenu(jFrame);
        }
        else if (num == 3){
            currentmenu = new PlayMenu(jFrame);
        }
        else if (num == 4){
            currentmenu = new SettingsMenu(jFrame);
        }
    }

    public void MakeMenu(int num, JFrame jFrame, Player[] players){
        if (num == 4){
            currentmenu = new PlayMenu(jFrame, players);
        }
    }
}
