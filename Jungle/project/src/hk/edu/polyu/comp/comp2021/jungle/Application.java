package hk.edu.polyu.comp.comp2021.jungle;

import java.util.*;
import hk.edu.polyu.comp.comp2021.jungle.controller.*;
import hk.edu.polyu.comp.comp2021.jungle.model.*;
import hk.edu.polyu.comp.comp2021.jungle.gui.*;

public class Application {
    public static void main(String[] args) throws NullPointerException, InterruptedException{
        Scanner input = new Scanner(System.in);
        Player player1 = new Player("", 1),
                player2 = new Player("", 2);
        SBoard sBoard = new SBoard();
        while(!sBoard.isNewGame && !sBoard.isLoadGame){
            Thread.sleep(200);
        }
        NBoard nBoard;
        if(sBoard.isNewGame){
            nBoard = new NBoard();
            while(!nBoard.isGameStarted){
                Thread.sleep(200);
            }
            player1.setName(nBoard.getName1());
            player2.setName(nBoard.getName2());
        }
        else{
            System.out.println("Here you load...");
        }
        Board board = new Board(player1,player2);
        // start playing the game
        Table table = new Table(board);
        //GameController gc = new GameController();
        //BoardController bc = new BoardController();
    }
}
