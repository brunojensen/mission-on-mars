package com.mars.engine;

import java.util.stream.Stream;

import com.mars.engine.impl.LeftCommand;
import com.mars.engine.impl.MoveCommand;
import com.mars.engine.impl.RightCommand;
import com.mars.exception.InvalidCommandException;

public class CommandParser {

    public static Stream<Command> parse(final String command) {
        return command.chars().mapToObj(c -> {
            switch(c) {
                case 'L': return new LeftCommand();
                case 'R': return new RightCommand();
                case 'M': return new MoveCommand();
            }
            throw new InvalidCommandException(String.valueOf(command));
        });
    }

}
