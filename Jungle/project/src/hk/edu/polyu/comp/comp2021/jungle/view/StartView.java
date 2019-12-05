package hk.edu.polyu.comp.comp2021.jungle.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Welcome window prompting users to start new game or load a saved one
 */
public class StartView{
    private final JFrame SFrame;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JPanel panelMain;
    private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(530, 600);
    private boolean isNewGame = false;
    private boolean isLoadGame = false;

    /**
     *
     * @return user selection for new game
     */
    public boolean isNewGame(){
        return isNewGame;
    }


    /**
     *
     * @return user selection for load game
     */
    public boolean isLoadGame(){
        return isLoadGame;
    }
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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
