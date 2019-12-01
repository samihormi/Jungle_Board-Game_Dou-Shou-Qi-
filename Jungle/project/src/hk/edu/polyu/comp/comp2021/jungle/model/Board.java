package hk.edu.polyu.comp.comp2021.jungle.model;

public class Board {
    private Block[][] board = new Block[9][7];

    public Block[][] getBoard() {
        return board;
    }

    public void setBoard(Block[][] board){
        this.board=board;
    }
}
