package com.mars.service;

import org.junit.Assert;
import org.junit.Test;

import com.mars.model.Bot;
import com.mars.model.Coordinates;

public class BotServiceTest {

    private BotService service = new BotService();
    
    @Test
    public void testCreateBot() {
        final Bot bot = service.createBot();
        Assert.assertEquals(bot.getCoordinates(), Coordinates.ZERO);
        Assert.assertEquals(bot.getDirection(), 'N');
    }

}
