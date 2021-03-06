package hk.edu.polyu.comp.comp2021.jungle;

import java.util.*;

import hk.edu.polyu.comp.comp2021.jungle.save.ResourceManager;
import hk.edu.polyu.comp.comp2021.jungle.controller.SaveGameController;
import hk.edu.polyu.comp.comp2021.jungle.controller.*;
import hk.edu.polyu.comp.comp2021.jungle.model.*;
import hk.edu.polyu.comp.comp2021.jungle.view.*;

/**
 * Launches the application of the game.
 * Checks whether the player wants a new game or load a new game.
 */
public class Application {
    private static final long time = 200;

    /**
     * @param args main function
     * @throws NullPointerException if null appears
     * @throws InterruptedException in case for interruptions
     */
    public static void main(String[] args) throws NullPointerException, InterruptedException {
        Scanner input = new Scanner(System.in);
        Player player1 = new Player("", 1),
                player2 = new Player("", 2);
        StartView startView;
        Boolean loadComplete = false, gameStarted = false;
        while (!loadComplete || !gameStarted) {
            startView = new StartView();
            while (!startView.isNewGame() && !startView.isLoadGame()) {
                Thread.sleep(time);
            }
            if (startView.isNewGame()) {
                gameStarted = true;
                NameVIew nameVIew = new NameVIew();
                while (!nameVIew.isGameStarted()) {
                    Thread.sleep(time);
                }
                player1.setName(nameVIew.getName1());
                player2.setName(nameVIew.getName2());
                GameController gc = new GameController(player1.getName(), player2.getName());// start playing the game
            } else {//load game
                Board board;
                GameController gc;
                TableView tableView = null;
                try {
                    SaveGameController s1 = (SaveGameController) ResourceManager.load("Game69.save");
                    if (s1 != null) {
                        loadComplete = true;
                        tableView = s1.loadGame();
                        board = new Board(s1.getP1(), s1.getP2());
                        gc = new GameController(s1.getP1(), s1.getP2(), s1.getBoard(), s1.getTurn());
                        gc.StartGame(tableView);
                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
