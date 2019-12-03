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

    public NBoard(){
        this.NFrame = new JFrame("Jungle Game");
        NFrame.setContentPane(panelMain);
        NFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFrame.pack();
        NFrame.setVisible(true);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName1.getText();
                playerName2.getText();
            }
        });
    }
}