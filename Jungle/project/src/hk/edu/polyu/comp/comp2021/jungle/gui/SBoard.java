package hk.edu.polyu.comp.comp2021.jungle.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hk.edu.polyu.comp.comp2021.jungle.controller.GameController;

/**
 * Welcome window prompting users to start new game or load a saved one
 */
public class SBoard {
    private final JFrame SFrame;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JPanel panelMain;
    private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(300, 300);
    public boolean isNewGame = false;
    public boolean isLoadGame = false;

    /**
     * Initialize the window
     */
    public SBoard() {
        this.SFrame = new JFrame("Jungle Game");
        this.SFrame.setPreferredSize(OUTER_FRAME_DIMENSION);
        SFrame.setContentPane(panelMain);
        SFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNewGame = true;
                SFrame.setVisible(false);
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoadGame = true;
                SFrame.setVisible(false);
            }
        });
        SFrame.pack();
        SFrame.setVisible(true);
    }

}
