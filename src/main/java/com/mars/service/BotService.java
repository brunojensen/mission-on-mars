package com.mars.service;

import org.springframework.stereotype.Service;

import com.mars.model.Bot;
import com.mars.model.Coordinates;

@Service
public class BotService {

    public Bot createBot() {
        return new Bot(Coordinates.ZERO, 'N');
    }

}
