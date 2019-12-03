package hk.edu.polyu.comp.comp2021.jungle.Save;

import hk.edu.polyu.comp.comp2021.jungle.model.*;

public class SaveGame implements java.io.Serializable {
    public static final long serialVersionUID = 1L;

    public Board board;
    public Player p1,p2,turn;

    public SaveGame(Board board, Player p1, Player p2, Player turn){
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.turn = turn;
    }


}
