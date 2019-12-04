package hk.edu.polyu.comp.comp2021.jungle.save;

import hk.edu.polyu.comp.comp2021.jungle.model.*;

/**
 * Saves elements of the game
 */
public class SaveGame implements java.io.Serializable {
    public static final long serialVersionUID = 1L;

    public Board board;
    public Player p1,p2,turn;

    /**
     *
     * @param board game board
     * @param p1 player1
     * @param p2 player2
     * @param turn player's turn
     */
    public SaveGame(Board board, Player p1, Player p2, Player turn){
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.turn = turn;
    }


}
