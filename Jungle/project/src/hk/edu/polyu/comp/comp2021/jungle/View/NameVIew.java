package hk.edu.polyu.comp.comp2021.jungle.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Window prompting players for their names
 */
public class NameVIew {
    private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(400, 200);
    private final JFrame NFrame;
    private JTextField playerName2;
    private JTextField playerName1;
    private JPanel panelMain;
    private JButton startGameButton;
    private String Name1 = "";
    private String Name2 = "";
    protected boolean isGameStarted = false;

    /**
     * Initializes the window
     */
    public NameVIew(){
        this.NFrame = new JFrame("Jungle Game");
        NFrame.setContentPane(panelMain);
        NFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NFrame.setPreferredSize(OUTER_FRAME_DIMENSION);
        NFrame.pack();
        NFrame.setVisible(true);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerName1.getText() != null){
                    Name1 = playerName1.getText();
                }
                if(playerName2.getText() != null){
                    Name2 = playerName2.getText();
                }
                isGameStarted = true;
                NFrame.setVisible(false);
            }
        });
    }

    /**
     *
     * @return first player's name
     */
    public String getName1() {
        return Name1;
    }

    /**
     *
     * @return second player's name
     */
    public String getName2() {
        return Name2;
    }

    /**
     * Checks whether the game is launched
     * @return isGameStarted
     */
    public boolean isGameStarted(){
        return isGameStarted;
    }
}

