package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.View.TableView;
import hk.edu.polyu.comp.comp2021.jungle.model.*;

import javax.swing.*;
/**
 * Starts the game
 * Displays the game screen
 */
public class GameController {
    private int pause = 200;
    private Player player1;
    private Player player2;
    private Player turn;
    private Board board;

    /**
     *
     * @param player1_name returns the name of the first player
     * @param player2_name returns the name of the second player
     */
    public GameController(String player1_name, String player2_name) {
        try {
            prepareStartGame(player1_name, player2_name);
        } catch (InterruptedException e) {
            System.out.println("Error!");
        }
    }

    /**
     *
     * @param player1 first player
     * @param player2 second player
     * @param board game board
     * @param turn player's turn
     */
    public GameController(Player player1, Player player2, Board board, Player turn) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.turn = turn;
    }

    /**
    * Responsible for preparing variable
    * Starts the Game
    * @param player1_name Name1
    * @param player2_name Name2
    * @throws InterruptedException for interruption 
    */
    public void prepareStartGame(String player1_name,String player2_name) throws InterruptedException{
        player1 = new Player(player1_name, 1);
        player2 = new Player(player2_name, 2);
        turn = player1;
        board = new Board(player1,player2);
        TableView tableView = new TableView(board,player1,player2,player1);
        StartGame(tableView);
    }

    /**
    * The actual method that runs the game
    * Displays the game screen
    * @param tableView Display
    * @throws InterruptedException for the method
    */
    public void StartGame(TableView tableView) throws InterruptedException{
        BoardController boardController = new BoardController(board);
        Position p[]=null;
        while(!boardController.isEnd()){
            while (!tableView.isFinished()) {
                p= tableView.getInputFromTable(turn); // p[0] = current location p[1]=destination
                Thread.sleep(pause);
            }
            if(boardController.moveRules(p[0],p[1])==1) // valid move = 1, invalid move = 0
            {
                board.setBoard(boardController.getBlocks());
                turn = changeTurn(player1, player2,turn);
                tableView.updateTable(board);
            }
            else{
                tableView.updateTable(board);
                tableView.changeTurn();//didn't move so do not have to change turn but in updateTable() has it so call this again;
            }
            tableView.setFinished(false);
        }
        turn=changeTurn(player1, player2,turn);
        JOptionPane.showMessageDialog(null,"Victory! " + turn.getName() + " won! Congratulations!");
    }

    /**
     *
     * @param p1 first player
     * @param p2 second player
     * @param turn current player's turn
     * @return other player's turn
     */
    public Player changeTurn(Player p1, Player p2, Player turn) {
        if (turn.equals(p1))
            return p2;
        else
            return p1;
    }

}
