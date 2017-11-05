package com.mars.service;

import org.junit.Assert;
import org.junit.Test;

import com.mars.exception.OutOfSpaceException;
import com.mars.model.Bot;

public class MarsServiceTest {

    private MarsService marsService = new MarsService();

    private BotService botService = new BotService();

    @Test(expected = NullPointerException.class)
    public void testNullBot() {
        marsService.execute(null, "MMMMMM");
    }

    @Test(expected = NullPointerException.class)
    public void testNullCommand() {
        final Bot bot = botService.createBot();
        marsService.execute(bot, null);
    }

    @Test(expected = OutOfSpaceException.class)
    public void testCollisionError() {
        final Bot bot = botService.createBot();
        marsService.execute(bot, "MMMMMM");
    }

    @Test
    public void testNoCollision() {
        final Bot bot = botService.createBot();
        Assert.assertEquals(marsService.execute(bot, "MMRMMRMM").finalPosition(), "(2, 0, S)");
    }

    @Test
    public void testNoCollision1() {
        final Bot bot = botService.createBot();
        Assert.assertEquals(marsService.execute(bot, "MML").finalPosition(), "(0, 2, W)");
    }

}
