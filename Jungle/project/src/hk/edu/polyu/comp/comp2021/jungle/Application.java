package hk.edu.polyu.comp.comp2021.jungle;

import java.util.*;

import hk.edu.polyu.comp.comp2021.jungle.Save.ResourceManager;
import hk.edu.polyu.comp.comp2021.jungle.Save.SaveGame;
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
        if(sBoard.isNewGame){
            NBoard nBoard = new NBoard();
            while(!nBoard.isGameStarted){
                Thread.sleep(200);
            }
            player1.setName(nBoard.getName1());
            player2.setName(nBoard.getName2());
            GameController gc = new GameController(player1.getName(),player2.getName());// start playing the game
        }
        else{
            Board board = new Board(player1,player2);
            GameController gc = new GameController(board,player1,player2,player1); // wrong
            Table table;
            try {
                SaveGame s1 = (SaveGame) ResourceManager.load("Game69.save");
                table = gc.loadGame(s1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
