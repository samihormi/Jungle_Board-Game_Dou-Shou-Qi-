package hk.edu.polyu.comp.comp2021.jungle;

import java.util.*;

import hk.edu.polyu.comp.comp2021.jungle.save.ResourceManager;
import hk.edu.polyu.comp.comp2021.jungle.save.SaveGame;
import hk.edu.polyu.comp.comp2021.jungle.controller.*;
import hk.edu.polyu.comp.comp2021.jungle.model.*;
import hk.edu.polyu.comp.comp2021.jungle.gui.*;

/**
 * Launches the application of the game.
 * Checks whether the player wants a new game or load a new game.
 */
public class Application {
    private static final long time = 200;

    /**
     *
     * @param args main function
     * @throws NullPointerException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws NullPointerException, InterruptedException {
        Scanner input = new Scanner(System.in);
        Player player1 = new Player("", 1),
                player2 = new Player("", 2);
        SBoard sBoard = new SBoard();
        while (!sBoard.isNewGame && !sBoard.isLoadGame) {
            Thread.sleep(time);
        }
        if (sBoard.isNewGame) {
            NBoard nBoard = new NBoard();
            while (!nBoard.isGameStarted) {
                Thread.sleep(time);
            }
            player1.setName(nBoard.getName1());
            player2.setName(nBoard.getName2());
            Board board = new Board(player1, player2);
            GameController gc = new GameController(player1.getName(), player2.getName());// start playing the game
        } else {
            Board board = new Board(player1, player2);
            GameController gc = new GameController(player1, player2, board, player1);
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
