package hk.edu.polyu.comp.comp2021.jungle.controller;

import hk.edu.polyu.comp.comp2021.jungle.model.Block;
import hk.edu.polyu.comp.comp2021.jungle.model.Board;
import hk.edu.polyu.comp.comp2021.jungle.model.Player;
import hk.edu.polyu.comp.comp2021.jungle.model.Position;

public class BoardController {//0=plain, 1=river, 2=trap, 3=goal
    private Block[][] blocks;
    public BoardController(Board board){
        blocks = board.getBoard();
    }
    public int moveRules(Position p1, Position p2){ //move:1, invalid move:0
        //isvalidmove() but there is exception
        if(p1.getY()==p2.getY()&&p1.getX()==p2.getX())
            return 0;
        if (Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) == 1) //check distance = 1 -> exception when tiger cross the river
        {
            if (blocks[p2.getY()][p2.getX()].getBlockType() != 1) {//not river
                if (blocks[p2.getY()][p2.getX()].getA() != null) { //if there is any enemy
                    if (blocks[p2.getY()][p2.getX()].getBlockType() != 2) { //if it is not trap
                        if (blocks[p1.getY()][p1.getX()].getA().getRank() >= blocks[p2.getY()][p2.getX()].getA().getRank())//if rank is higher than enemy
                        {
                            if(blocks[p1.getY()][p1.getX()].getA().getPly().getId()!= blocks[p2.getY()][p2.getX()].getA().getPly().getId()) {
                                eat(p1, p2);
                                return 1;
                            }
                        } else if (blocks[p1.getY()][p1.getX()].getA().getRank() == 1 && blocks[p2.getY()][p2.getX()].getA().getRank() == 8)//rat to elephant
                        {
                            if (!((blocks[p1.getY()][p1.getX()].getBlockType() == 1 && blocks[p2.getY()][p2.getX()].getBlockType() != 1) //river to land
                                    || (blocks[p1.getY()][p1.getX()].getBlockType() != 1 && blocks[p2.getY()][p2.getX()].getBlockType() == 1))) // land to river
                            {
                                if(blocks[p1.getY()][p1.getX()].getA().getPly().getId()!= blocks[p2.getY()][p2.getX()].getA().getPly().getId()){
                                    eat(p1, p2);
                                    return 1;
                                }
                            }

                        }

                    } else { //trap
                        if(blocks[p1.getY()][p1.getX()].getA().getPly().getId()!= blocks[p2.getY()][p2.getX()].getA().getPly().getId()) {
                            eat(p1, p2);
                            return 1;
                        }
                    }
                } else { //empty
                    move(p1, p2);
                    return 1;
                }
            } else {//river
                if (blocks[p1.getY()][p1.getX()].getA().getRank() == 1)
                    if (blocks[p2.getY()][p2.getX()].getA() != null) {
                        move(p1, p2);
                        return 1;
                    }
            }
        } else if (((p1.getX() - p2.getX()) == 0 && (Math.pow(p1.getY() - p2.getY(), 2)) == 16)) {
            if (blocks[p1.getY()][p1.getX()].getA().getRank() == 6 || blocks[p1.getY()][p1.getX()].getA().getRank() == 7) { //if tiger or lion
                if (blocks[p2.getY()][p2.getX()].getA() != null) {
                    if (blocks[p1.getY()][p1.getX()].getA().getRank() >= blocks[p2.getY()][p2.getX()].getA().getRank())//if rank is higher than enemy
                        if (!checkThereIsRat(p1, p2, "X")) {
                            if(blocks[p1.getY()][p1.getX()].getA().getPly().getId()!= blocks[p2.getY()][p2.getX()].getA().getPly().getId()) {
                                eat(p1, p2);
                                return 1;
                            }
                        }
                } else {
                    if (!checkThereIsRat(p1, p2, "X")) {
                        move(p1, p2);
                        return 1;
                    }
                }
            }
        } else if ((p1.getY() - p2.getY()) == 0 && (Math.pow(p1.getX() - p2.getX(), 2)) == 9) {
            if (blocks[p1.getY()][p1.getX()].getA().getRank() == 6 || blocks[p1.getY()][p1.getX()].getA().getRank() == 7) { //if tiger or lion
                if (blocks[p2.getY()][p2.getX()].getA() != null) {
                    if (blocks[p1.getY()][p1.getX()].getA().getRank() >= blocks[p2.getY()][p2.getX()].getA().getRank())//if rank is higher than enemy
                        if (!checkThereIsRat(p1, p2, "Y")) {
                            if(blocks[p1.getY()][p1.getX()].getA().getPly().getId()!= blocks[p2.getY()][p2.getX()].getA().getPly().getId()) {
                                eat(p1, p2);
                                return 1;
                            }
                        }
                } else {
                    if (!checkThereIsRat(p1, p2, "Y")) {
                        move(p1, p2);
                        return 1;
                    }
                }
            }
        }
        System.out.println("invalid move");
        return 0;
    }
    private boolean checkThereIsRat(Position p,Position d,String x){
        if(x.equals("X")){
            if(p.getX()==1||p.getX()==2){
                for (int i = 3; i <= 5; i++) {
                    for (int j = 1; j <= 2; j++) {
                        if(blocks[i][j].getA()!=null)
                            return true;
                    }
                }
            }
            else{
                for (int i = 3; i <= 5; i++) {
                    for (int j = 4; j <= 5; j++) {
                        if(blocks[i][j].getA()!=null)
                            return true;
                    }
                }
            }
        }
        else if(x.equals("Y")){
            if((p.getX()+d.getX())/2==1){
                for (int i = 3; i <= 5; i++) {
                    for (int j = 1; j <= 2; j++) {
                        if(blocks[i][j].getA()!=null)
                            return true;
                    }
                }
            }
            else{
                for (int i = 3; i <= 5; i++) {
                    for (int j = 4; j <= 5; j++) {
                        if(blocks[i][j].getA()!=null)
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void move(Position p1, Position p2){
        blocks[p2.getY()][p2.getX()].setA(blocks[p1.getY()][p1.getX()].getA());
        blocks[p1.getY()][p1.getX()].setA(null);
    }
    private void eat(Position p1, Position p2){
        blocks[p2.getY()][p2.getX()].setA(blocks[p1.getY()][p1.getX()].getA());
        blocks[p1.getY()][p1.getX()].setA(null);
    }

    public boolean isEnd(){
        Player p=null;
        if(blocks[0][3].getA()!=null) {
            if (blocks[0][3].getA().getPly() != blocks[0][3].getPlayer()) { //arrive den
                return true;
            }
        }
        else if(blocks[8][3].getA()!=null){
            if(blocks[8][3].getA().getPly()!=blocks[8][3].getPlayer()){//arrive den
                return true;
            }
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<7;j++){
                if(blocks[i][j].getA()!=null) {
                    if (p == null && blocks[i][j].getA().getPly() != null)
                        p = blocks[i][j].getA().getPly();
                    if (blocks[i][j].getA().getPly() != p)
                        return false;
                }
            }
        }
        System.out.println(p.getName()+"win");
        return true;
    }

    public Block[][] getBlocks() {
        return blocks;
    }
}
