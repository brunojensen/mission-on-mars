package com.mars.engine.impl;

import java.util.HashMap;
import java.util.Map;

import com.mars.engine.Command;
import com.mars.model.Bot;
import com.mars.model.Coordinates;

public class MoveCommand implements Command {

    private static final Map<Character, Coordinates> directives = new HashMap<>();
    static {
        directives.put('E', new Coordinates.Unmodifiable(1, 0));
        directives.put('W', new Coordinates.Unmodifiable(-1, 0));
        directives.put('N', new Coordinates.Unmodifiable(0, 1));
        directives.put('S', new Coordinates.Unmodifiable(0, -1));
    }

    @Override
    public void execute(Bot bot) {
        bot.move(directives.get(bot.getDirection()));
    }

}
