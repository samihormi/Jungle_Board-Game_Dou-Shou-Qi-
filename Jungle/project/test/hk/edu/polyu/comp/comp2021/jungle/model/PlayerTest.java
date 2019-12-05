package hk.edu.polyu.comp.comp2021.jungle.model;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void playerTest() throws Exception{
        Player actual = new Player("Jon", 1);
        actual.setName("John");
        actual.setId(2);
        Assert.assertEquals("John",actual.getName());
        Assert.assertEquals(2, actual.getId());
    }
}
