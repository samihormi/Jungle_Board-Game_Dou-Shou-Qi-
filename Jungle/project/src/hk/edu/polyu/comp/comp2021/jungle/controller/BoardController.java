package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.model.Block;
import hk.edu.polyu.comp.comp2021.jungle.model.Board;
import hk.edu.polyu.comp.comp2021.jungle.model.Player;
import hk.edu.polyu.comp.comp2021.jungle.model.Position;

public class BoardController {
    public int moveAnimal(Position p1, Position p2, Board board){ //turn will consider the player. we don't have to deal with that here
        //isvalidmove() but there is exception
        Block[][] blocks = board.getBoard();
        if(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2)!=1)
        {
            System.out.println("you cannot move more than one block");
            return -1;//fail
        }
        if(blocks[p2.getX()][p2.getY()].getBlockType()==1){ //if it is river
            System.out.println("you cannot move to river");
            return -1;//fail
        }
        if(blocks[p2.getX()][p2.getY()].getA()!=null){ //if there is any enemy
            if(blocks[p1.getX()][p1.getY()].getA().getRank()<blocks[p2.getX()][p2.getY()].getA().getRank()){
                if(blocks[p1.getX()][p1.getY()].getA().getRank()!=0){
                    System.out.println("you cannot kill higher rank animal");
                    return -1;//fail
                }
            }
        }
        return 0;//success

    }
    public boolean canEat(){
        return false;
    }
    public int doMove(Position p1,Position p2){
        return -1;
    }
}
