package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.view.*;
import hk.edu.polyu.comp.comp2021.jungle.model.*;

public class GameController {

    public GameController() {
        StartGame();
    }
    public void StartGame(){
        String player1_name ="",player2_name="";
        Player player1 = new Player(player1_name, 1);
        Player player2 = new Player(player2_name, 2);
        Player turn=player1;
        Board board = new Board(player1,player2);
        BoardController boardController =new BoardController(board);

        while(boardController.isEnd()){
            Position[] p = getInputFromGui(player1); // p[0] = current location p[1]=destination
            if(boardController.moveRules(p[0],p[1])==1) // valid move = 1, invalid move = 0
            {
                turn = chageTurn(player1, player2,turn);
                updateView();
            }

        }

    }

    public Player chageTurn(Player p1,Player p2,Player turn){
        if(turn.equals(p1))
            return p2;
        else
            return p1;
    }

}
