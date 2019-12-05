package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Animal class Test
 */
public class AnimalTest {
    /**
     * Animal Test
     */
    @Test
    public void animalTest() {
        Position p = new Position(1, 2);
        Player ply = new Player("Mark", 1);
        Animal actual = new Animal(2, p, ply);
        Assert.assertEquals(ply, actual.getPly());
        Assert.assertEquals(p, actual.getP());
        Assert.assertEquals(2, actual.getRank());

    }
}
