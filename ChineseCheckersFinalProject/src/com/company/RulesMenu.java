package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesMenu extends Menu {

    private static int rulesMenunum = 1;
    private static String rulesMenuname = "RulesMenu";
    public static JFrame rulesMenuJFrame = null;
    private JPanel rulesMenuPanel1 = null;
    private JPanel rulesMenuPanel2 = null;


    public class RulesMenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Back")){
                rulesMenuJFrame.remove(rulesMenuPanel1);
                rulesMenuJFrame.remove(rulesMenuPanel2);
                getMenuNavigator().MakeMenu(0, rulesMenuJFrame);


            }
        }
    }


    public RulesMenu(){
        rulesMenuJFrame = new JFrame();
        createJFrame();
    }
    public RulesMenu(JFrame jFrame){
        rulesMenuJFrame = jFrame;
        createJFrame();
    }

    public void createJFrame(){

        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new RulesMenuButtonListener());

        JLabel rulesText = new JLabel("Visit the following link to get rules and learn about implementation details! https://github.com/WFaustin/ChineseCheckers/blob/master/CS338README.txt");
        JOptionPane.showConfirmDialog(rulesMenuJFrame, "Visit the following link to get rules and learn about implementation details! https://github.com/WFaustin/ChineseCheckers/blob/master/CS338README.txt" );
        jPanel2.add(backButton);


        //jPanel.add(rulesText);



        rulesMenuJFrame.getContentPane().add(BorderLayout.CENTER, jPanel);
        rulesMenuJFrame.getContentPane().add(BorderLayout.SOUTH, jPanel2);
        rulesMenuPanel1 = jPanel;
        rulesMenuPanel2 = jPanel2;
        rulesMenuJFrame.setSize(300,300);
        rulesMenuJFrame.setVisible(true);


    }
}

