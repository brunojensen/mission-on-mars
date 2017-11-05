package com.mars.model;

import org.junit.Assert;
import org.junit.Test;

public class BotTest {

    @Test
    public void testCreation() {
        final Bot bot = new Bot(Coordinates.ZERO, 'N');
        Assert.assertEquals(bot.getCoordinates(), Coordinates.ZERO);
        Assert.assertEquals(bot.getDirection(), 'N');
    }
    
    @Test
    public void testFinalPosition() {
        final Bot bot = new Bot(Coordinates.ZERO, 'N');
        Assert.assertEquals("(0, 0, N)", bot.finalPosition());
    }

}
