package hk.edu.polyu.comp.comp2021.jungle.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Welcome window prompting users to start new game or load a saved one
 */
public class StartView {
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
    public StartView() {
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