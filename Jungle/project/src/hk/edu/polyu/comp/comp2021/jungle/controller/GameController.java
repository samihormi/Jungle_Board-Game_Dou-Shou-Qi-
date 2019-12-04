package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.save.ResourceManager;
import hk.edu.polyu.comp.comp2021.jungle.save.SaveGame;
import hk.edu.polyu.comp.comp2021.jungle.gui.Table;
import hk.edu.polyu.comp.comp2021.jungle.model.*;

/**
 * Starts the game
 * Displays the game screen
 */
import javax.swing.*;

public class GameController {
    public Player player1;
    public Player player2;
    public Player turn;
    public Board board;

    /**
     *
     * @param player1_name returns the name of the first player
     * @param player2_name returns the name of the second player
     */
    public GameController(String player1_name, String player2_name) {
        try {
            prepareStartGame(player1_name, player2_name);
        } catch (InterruptedException e) {
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
     *
     * @param player1 first player
     * @param player2 second player
     * @param board game board
     * @param turn player's turn
     */
    public GameController(Board board,Player player1,Player player2, Player turn) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.turn = turn;
        SaveGame s1 = new SaveGame(board,player1,player2,turn);
        saveGame(s1);
    }

    public void prepareStartGame(String player1_name,String player2_name) throws InterruptedException{
        player1 = new Player(player1_name, 1);
        player2 = new Player(player2_name, 2);
        turn = player1;
        board = new Board(player1,player2);
        Table table = new Table(board,player1,player2,player1);
        StartGame(table);
    }


    public void StartGame(Table table) throws InterruptedException{


        BoardController boardController = new BoardController(board);

        Position p[]=null;

        while(!boardController.isEnd()){
            System.out.println("turn:"+turn.getId());
            while (!table.isFinished()) {
                p=table.getInputFromTable(turn); // p[0] = current location p[1]=destination
                Thread.sleep(200);
            }
            System.out.println("p[o]xy:("+p[0].getX()+","+p[0].getY()+") p[1]xy("+p[1].getX()+","+p[1].getY()+")");
            if(boardController.moveRules(p[0],p[1])==1) // valid move = 1, invalid move = 0
            {
                board.setBoard(boardController.getBlocks());
                turn = chageTurn(player1, player2,turn);
                table.updateTable(board);
            }
            table.setFinished(false);
        }
        System.out.println("isend end");
        JOptionPane.showMessageDialog(null,"Victory! " + turn.getName() + " won! Congratulations!");
    }

    /**
     *
     * @param s1 game to save
     */
    public void saveGame(SaveGame s1){
        try {
            ResourceManager.save(s1,"Game69.save");
        } catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }
    /**
     *
     * @param s1 saved game
     * @return table of the loaded game
     */
    public Table loadGame(SaveGame s1)  {
        Table loadedGame;
        BoardController boardController = new BoardController(board);
        try {
            board.setBoard(s1.board.getBoard());
            player1.setId(s1.p1.getId());
            player1.setName(s1.p1.getName());
            player2.setId(s1.p2.getId());
            player2.setName(s1.p2.getName());
            changeTurn(player1, player2, changeTurn(s1.p1, s1.p2, s1.turn));

        } catch (Exception e) {
            System.out.println("Couldn't load game: " + e.getMessage());
        }
        loadedGame = new Table(board, player1, player2, turn);
        return loadedGame;
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
