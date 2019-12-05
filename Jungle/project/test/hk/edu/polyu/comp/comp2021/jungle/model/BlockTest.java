package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Assert;
import org.junit.Test;

public class BlockTest {
    @Test
    public void blockTest() throws Exception{
        Block actual = new Block();
        Position p = new Position(4, 2);
        Player ply = new Player("Kate", 2);
        Animal a = new Animal(5, p, ply);
        actual.setA(a);
        actual.setPlayer(ply);
        Assert.assertEquals(a, actual.getA());
        Assert.assertEquals(0, actual.getBlockType());
        Assert.assertEquals(ply, actual.getPlayer());

        actual.setBlockType(2);
        Assert.assertEquals(2, actual.getBlockType());
    }
}
