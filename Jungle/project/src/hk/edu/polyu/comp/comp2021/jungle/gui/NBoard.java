package hk.edu.polyu.comp.comp2021.jungle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NBoard {
    private final JFrame NFrame;
    private JTextField playerName2;
    private JTextField playerName1;
    private JPanel panelMain;
    private JButton startGameButton;
    private String Name1;
    private String Name2;
    public boolean isGameStarted = false;

    public NBoard(){
        this.NFrame = new JFrame("Jungle Game");
        NFrame.setContentPane(panelMain);
        NFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFrame.pack();
        NFrame.setVisible(true);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Name1 = playerName1.getText();
                Name2 = playerName2.getText();
                isGameStarted = true;
                NFrame.setVisible(false);
            }
        });
    }

    public String getName1() {
        return Name1;
    }

    public String getName2() {
        return Name2;
    }
}
