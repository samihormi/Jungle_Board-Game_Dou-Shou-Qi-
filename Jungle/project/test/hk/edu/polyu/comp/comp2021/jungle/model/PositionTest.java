package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Position Class Test
 */
public class PositionTest {
    /**
     * Full Test
     */
    @Test
    public void positionTest() {
        Position actual = new Position(5, 1);
        actual.setY(4);
        actual.setX(3);
        Assert.assertEquals(4, actual.getY());
        Assert.assertEquals(3, actual.getX());
    }
}
