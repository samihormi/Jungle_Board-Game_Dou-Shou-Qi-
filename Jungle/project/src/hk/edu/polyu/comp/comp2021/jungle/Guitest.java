package hk.edu.polyu.comp.comp2021.jungle;

import javax.swing.*;
import java.awt.*;

public class Guitest {
    Guitest(){
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("sources/animals/PLAYER2/Elephant2.png").getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
        label.setIcon(imageIcon);
        panel.add(label);
        frame.add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
