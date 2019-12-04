package hk.edu.polyu.comp.comp2021.jungle;

import hk.edu.polyu.comp.comp2021.jungle.gui.Table;

import javax.swing.*;
import java.awt.*;

public class Guitest {
    Guitest(){
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        String imgPath = Table.class.getResource("").getPath() + "/sources/animals/PLAYER2/Elephant2.png";
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
        label.setIcon(imageIcon);
        panel.add(label);
        frame.add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
