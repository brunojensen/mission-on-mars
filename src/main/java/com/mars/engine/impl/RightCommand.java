package com.mars.engine.impl;

import java.util.HashMap;
import java.util.Map;

import com.mars.engine.Command;
import com.mars.model.Bot;

public class RightCommand implements Command {

    private static final Map<Character, Character> directives = new HashMap<>();
    static {
        directives.put('E', 'S');
        directives.put('W', 'N');
        directives.put('N', 'E');
        directives.put('S', 'W');
    }

    @Override
    public void execute(Bot bot) {
        bot.setDirection(directives.get(bot.getDirection()));
    }
}
