package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.model.Block;
import hk.edu.polyu.comp.comp2021.jungle.model.Board;
import hk.edu.polyu.comp.comp2021.jungle.model.Player;
import hk.edu.polyu.comp.comp2021.jungle.model.Position;

public class BoardController {//0=plain, 1=river, 2=trap, 3=goal(w
    public int moveAnimal(Position p1, Position p2, Board board){ //turn will consider the player. we don't have to deal with that here
        //isvalidmove() but there is exception
        Block[][] blocks = board.getBoard();
        if(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2)==1) //check distance = 1
        {
            if(blocks[p2.getX()][p2.getY()].getBlockType()!=1){//not river
                if(blocks[p2.getX()][p2.getY()].getA()!=null){ //if there is any enemy

                }
                else{ //empty
                    move(p1,p2,board);
                    return 1;
                }
            }
            else{//river

            }
        }
        if(blocks[p2.getX()][p2.getY()].getBlockType()==1){ //if it is river
            System.out.println("you cannot move to river");
            if(blocks[p2.getX()][p2.getY()].getA()!=null){ //if there is any enemy
                if(blocks[p1.getX()][p1.getY()].getA().getRank()<blocks[p2.getX()][p2.getY()].getA().getRank()){
                    if(blocks[p1.getX()][p1.getY()].getA().getRank()!=0){
                        System.out.println("you cannot kill higher rank animal");
                    }
                }
            }
        }


        return 0;
    }

    public void move(Position p1, Position p2, Board board){

    }
    public void Eat(){

    }
    public int doMove(Position p1,Position p2){
        return -1;
    }
}
