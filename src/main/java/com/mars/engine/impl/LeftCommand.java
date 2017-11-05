package com.mars.engine.impl;

import java.util.HashMap;
import java.util.Map;

import com.mars.engine.Command;
import com.mars.model.Bot;

public class LeftCommand implements Command {

    private static final Map<Character, Character> directives = new HashMap<>();
    static {
        directives.put('E', 'N');
        directives.put('W', 'S');
        directives.put('N', 'W');
        directives.put('S', 'E');
    }

    @Override
    public void execute(Bot bot) {
        bot.setDirection(directives.get(bot.getDirection()));
    }

}
