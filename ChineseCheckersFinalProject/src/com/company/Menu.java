package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class Menu {

    private String menuName = "placeholder title";
    private int menuNum = -1;
    private JFrame menuJFrame = null;
    private static MenuNavigator menuNavigator = null;
    private static GameManager gm = null;

    public static MenuNavigator getMenuNavigator() {
        return menuNavigator;
    }

    public static void setMenuNavigator(MenuNavigator menuNavigator) {
        Menu.menuNavigator = menuNavigator;
    }

    public static GameManager getGm() {
        return gm;
    }

    public static void setGm(GameManager gm) {
        Menu.gm = gm;
    }

    public Menu(){
        menuName = "placeholder title";
        menuNum = -1;

    }

    public Menu(int num){

    }

    public Menu createBaseMenu(int num){
        if (num == 0){
            return new MainMenu();
        }
        else if (num == 1){
            return new RulesMenu();
        }
        else {
            return null;
        }
    }

    public String getMenuName(){
        return menuName;
    }

    public int getMenuNum(){
        return menuNum;
    }

    public void setMenuName(String name){
        menuName = name;
    }

    public void setMenuNum(int num){
        menuNum = num;
    }

    public void setMenuJFrame(JFrame jFrame){
        menuJFrame = jFrame;
    }

    private String numtoName(int num){
        if (num == 0){
            return "MainMenu";
        }
        else if(num == 1){
            return "AboutMenu";
        }
        else if(num == 2){
            return "SettingsMenu";
        }
        else if(num == 3){
            return "PlaySetUpMenu";
        }
        else if(num == 4){
            return "PlayGameMenu";
        }
        else{
            return "placeholder menu";
        }
    }

    public void createJFrame(){
        //
    }

    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu firstmenu = new JMenu("File");

        JMenuItem first1menuitem = new JMenuItem("Quit");
        first1menuitem.addActionListener(new MenuBarListener());

        return menuBar;
    }

    public class MenuBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Quit")){

            }
        }
    }
}
