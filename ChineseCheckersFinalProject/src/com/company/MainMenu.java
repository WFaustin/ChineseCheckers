package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Menu {

    private static int mainMenunum = 0;
    private static String mainMenuname = "MainMenu";
    public static JFrame mainMenuJFrame = null;
    private  JPanel mainMenuJPanel = null;
    private JPanel mainMenuJPanel2 = null;


    public class MainMenuButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Rules")){
                mainMenuJFrame.remove(mainMenuJPanel);
                getMenuNavigator().MakeMenu(1, mainMenuJFrame);
            }
            if (e.getActionCommand().equals(("Play"))) {
                mainMenuJFrame.remove((mainMenuJPanel));
                getMenuNavigator().MakeMenu(2, mainMenuJFrame);
            }
        }
    }

    public MainMenu(){
        mainMenuJFrame = new JFrame();
        createJFrame();
    }

    public MainMenu(JFrame jframe){
        mainMenuJFrame = jframe;
        createJFrame();
    }

    public MainMenu(JFrame jframe, MenuNavigator mN){
        mainMenuJFrame = jframe;
        setMenuNavigator(mN);
        createJFrame();
    }

    public void createJFrame(){
        mainMenuJFrame.setBackground(Color.gray);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.darkGray);

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new MainMenuButtonListener());
        JButton settingsButton = new JButton("Settings");
        JButton rulesButton = new JButton("Rules");
        rulesButton.addActionListener(new MainMenuButtonListener());
        JButton quitButton = new JButton("Quit");

        Piece c = new Piece(COLORS.Red);

        jPanel.add(c.getPieceLabel());
        jPanel.add(playButton);
        jPanel.add(rulesButton);
        jPanel.add(settingsButton);
        jPanel.add(quitButton);




        mainMenuJFrame.getContentPane().add(BorderLayout.WEST, jPanel);
        mainMenuJPanel = jPanel;
        mainMenuJFrame.setSize(600,600);
        mainMenuJFrame.setVisible(true);



    }
}
