package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
                mainMenuJFrame.remove(mainMenuJPanel2);
                getMenuNavigator().MakeMenu(1, mainMenuJFrame);
            }
            if (e.getActionCommand().equals(("Play"))) {
                mainMenuJFrame.remove((mainMenuJPanel));
                mainMenuJFrame.remove(mainMenuJPanel2);
                getMenuNavigator().MakeMenu(2, mainMenuJFrame);
            }
            if(e.getActionCommand().equals(("Quit"))){
                System.exit(0);
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
        JPanel j = new JPanel();
        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();



        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        file.add(quit);
        help.add(about);
        menuBar.add(file);
        menuBar.add(help);


        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));
        j.setLayout(new BoxLayout(j, BoxLayout.Y_AXIS));


        JLabel title = new JLabel("Chinese Checkers");
        JButton playButton = new JButton("Play");
        try {
            Image img = ImageIO.read(getClass().getResource("ChineseCheckersArt/PlayButtonIcon.png"));
            ImageIcon i = new ImageIcon(img);

            playButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        playButton.addActionListener(new MainMenuButtonListener());
        JButton settingsButton = new JButton("Settings");
        try {
            Image img = ImageIO.read(getClass().getResource("ChineseCheckersArt/SettingsButtonIcon.png"));
            ImageIcon i = new ImageIcon(img);

            settingsButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JButton rulesButton = new JButton("Rules");
        try {
            Image img = ImageIO.read(getClass().getResource("ChineseCheckersArt/RulesButtonIcon.png"));
            ImageIcon i = new ImageIcon(img);

            rulesButton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        rulesButton.addActionListener(new MainMenuButtonListener());
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new MainMenuButtonListener());



        jPanel.add(playButton);
        jPanel.add(rulesButton);
        jPanel1.add(settingsButton);
        jPanel1.add(quitButton);
        j.add(jPanel);
        j.add(jPanel1);




        mainMenuJFrame.getContentPane().add(BorderLayout.NORTH, menuBar);
        mainMenuJFrame.getContentPane().add(BorderLayout.CENTER, j);

        mainMenuJPanel = jPanel;
        mainMenuJPanel2 = j;
        mainMenuJFrame.setSize(300,300);
        mainMenuJFrame.setResizable(false);
        mainMenuJFrame.setVisible(true);



    }
}
