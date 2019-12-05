package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.View.TableView;
import hk.edu.polyu.comp.comp2021.jungle.model.*;
import hk.edu.polyu.comp.comp2021.jungle.save.ResourceManager;

import javax.swing.*;

/**
 * Saves elements of the game
 */
public class SaveGameController implements java.io.Serializable {
    public static final long serialVersionUID = 1L;

    public Board board;
    public Player p1,p2,turn;

    public SaveGameController(){
    }
    /**
     *
     * @param board game board
     * @param p1 player1
     * @param p2 player2
     * @param turn player's turn
     */
    public void SaveGame(Board board, Player p1, Player p2, Player turn){
        this.board=board;
        this.p1=p1;
        this.p2=p2;
        this.turn=turn;
        String fname="";
        try {
            while (fname.length()==0){
                fname = JOptionPane.showInputDialog("enter file name");}
            ResourceManager.save(this,fname+".save");

        } catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }
    public TableView loadGame(){
        TableView loadedGame;
        loadedGame = new TableView(board,p1,p2,turn);
        return loadedGame;
    }


}
