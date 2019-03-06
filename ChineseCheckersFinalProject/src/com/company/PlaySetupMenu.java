package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PlaySetupMenu extends Menu{

    private static int playsetupMenunum = 2;
    private static String playsetupMenuname = "RulesMenu";
    public static JFrame playsetupMenuJFrame = null;
    private JComboBox nop = null;
    private boolean teamisfalse = false;
    private JPanel playsetuppanel = null;


    public PlaySetupMenu(){
        playsetupMenuJFrame = new JFrame();
        createJFrame();

    }

    public PlaySetupMenu(JFrame jFrame){
        playsetupMenuJFrame = jFrame;
        createJFrame();
    }


    public class PlaySetupMenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("OK")){
                //int s = (int) nop.getSelectedItem();
                Player[] players = new Player[2];
                players[0] = new Player("red");
                players[1] = new Player("blue");
                getMenuNavigator().MakeMenu(3, playsetupMenuJFrame, players);
                playsetupMenuJFrame.remove(playsetuppanel);
                //replace 2 with s




            }
        }
    }

    @Override
    public void createJFrame() {
        //On here is how many people are playing (using the dropdown button thing), and if the game will be an PvP(individual free for all
        //or if it is a TvT (team versus team game). If the number is odd, and team is selected, when submit is hit, a popup should warn them
        //that continuing would need even players, and so an extra player would be added. They can either press Ok to let this happen, or Cancel
        //to change this again.

        JPanel jPanel = new JPanel();
        JRadioButton team = new JRadioButton("Team");

        team.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                teamisfalse = false;
            }
        });

        JRadioButton indi = new JRadioButton("Individual", true);

        indi.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                teamisfalse = true;
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(team);
        group.add(indi);


        JComboBox numofPlayers = new JComboBox();
        numofPlayers.addItem(2);
        numofPlayers.addItem(3);
        nop = numofPlayers;
        JButton submit = new JButton("OK");
        submit.addActionListener(new PlaySetupMenuButtonListener());
        jPanel.add(team);
        jPanel.add(indi);
        jPanel.add(submit);
        jPanel.add(numofPlayers);
        playsetuppanel = jPanel;

        playsetupMenuJFrame.getContentPane().add(BorderLayout.CENTER, jPanel);
        playsetupMenuJFrame.setSize(300,300);
        playsetupMenuJFrame.setVisible(true);


    }
}
