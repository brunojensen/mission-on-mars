package com.mars.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.mars.engine.CommandParser;
import com.mars.model.Bot;
import com.mars.model.Mars;

@Service
public class MarsService {

    public Bot execute(Bot bot, String command) {
        Objects.requireNonNull(bot);
        Objects.requireNonNull(command);
        CommandParser.parse(command)
            .forEach(c -> c.execute(bot));
        Mars.instance().getArea().testCollision(bot.getCoordinates());
        return bot;
    }

}
