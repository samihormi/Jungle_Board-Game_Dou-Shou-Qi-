package hk.edu.polyu.comp.comp2021.jungle.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SBoard {
    private final JFrame SFrame;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JPanel panelMain;
    private JButton OKButton;
    public boolean isNewGame = false;
    public boolean isLoadGame = false;

    public SBoard(){
        this.SFrame = new JFrame("Jungle Game");
        SFrame.setContentPane(panelMain);
        SFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNewGame = true;
                SFrame.setVisible(false);
            }
        });
        SFrame.pack();
        SFrame.setVisible(true);
    }
}
