package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Assert;
import org.junit.Test;

/**
     * Board Class Test
     */
public class BoardTest {
    /**
     * Full Board Class Testing
     */
    @Test
    public void boardTest(){
        Player player1 = new Player("John", 1);
        Player player2 = new Player("Alice", 2);
        Board board = new Board(player1,player2);

        Block[][] blocks = new Block[9][7];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                blocks[i][j] = new Block();
            }
        }
        board.setBoard(blocks);
        Assert.assertEquals(blocks.length, board.getBoard().length);
    }
}
