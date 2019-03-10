package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.CharacterCodingException;

public class CharacterSetUpMenu extends Menu{

    private static int charactersetupMenunum = 3;
    private static String charactersetupMenuname = "RulesMenu";
    public static JFrame charactersetupMenuJFrame = null;
    private Player [] players = null;
    private JButton ok = null;
    private JPanel b = null;



    public CharacterSetUpMenu(){

    }

    public CharacterSetUpMenu(JFrame jFrame, Player [] player){
        charactersetupMenuJFrame = jFrame;
        players = player;
        createJFrame();
    }

    public CharacterSetUpMenu(JFrame jFrame){
        charactersetupMenuJFrame = jFrame;
    }

    @Override
    public void createJFrame() {
        System.out.println(players.length);
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.X_AXIS));
        JPanel [] characterpanelarray = new JPanel[players.length];

        for (int i = players.length - 1; i >= 0; i--){
            JPanel s = new JPanel();
            s.setLayout(new BoxLayout(s, BoxLayout.Y_AXIS));
            JLabel stitle = new JLabel("P" + players[i].getNum());
            JTextArea sname = new JTextArea();
            JComboBox scolor = new JComboBox();
            scolor.addItem("Red");
            scolor.addItem("Blue");
            scolor.addItem("Yellow");
            scolor.addItem("Green");
            scolor.addItem("White");
            scolor.addItem("Black");
            JButton ssubmit = new JButton("P" + players[i].getNum() + " Ready!");
            ssubmit.addActionListener(new CharacterSetUpListener());
            s.add(stitle);
            s.add(sname);
            s.add(scolor);
            s.add(ssubmit);
            characterpanelarray[i] = s;
        }

        for (int i = 0; i < characterpanelarray.length; i++){
            characterpanelarray[i].setBackground(Color.darkGray);
            bigPanel.add(characterpanelarray[i], BorderLayout.EAST);
        }
        JButton submit = new JButton("OK");
        submit.addActionListener(new CharacterSetUpListener());
        ok = submit;
        b = bigPanel;
        charactersetupMenuJFrame.getContentPane().add(BorderLayout.CENTER, bigPanel);
        charactersetupMenuJFrame.getContentPane().add(BorderLayout.SOUTH, submit);

        charactersetupMenuJFrame.setSize(800,800);
        charactersetupMenuJFrame.setResizable(false);
        charactersetupMenuJFrame.setVisible(true);

    }

    public class CharacterSetUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("OK")){
                charactersetupMenuJFrame.remove(ok);
                charactersetupMenuJFrame.remove(b);
                getMenuNavigator().MakeMenu(4, charactersetupMenuJFrame, players);
            }
        }
    }
}
