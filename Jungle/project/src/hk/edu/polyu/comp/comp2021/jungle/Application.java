package hk.edu.polyu.comp.comp2021.jungle;

import java.util.*;
import hk.edu.polyu.comp.comp2021.jungle.controller.*;
import hk.edu.polyu.comp.comp2021.jungle.model.*;

public class Application {
    public static void main(String[] args) throws NullPointerException{
        Scanner input = new Scanner(System.in);
        String playerName1 = input.next();
        String playerName2 = input.next();
        Board board = new Board(playerName1,playerName2);
        // start playing the game

        //GameController gc = new GameController();
        //BoardController bc = new BoardController();
    }
}
