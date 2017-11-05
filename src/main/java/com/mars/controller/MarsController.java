package com.mars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mars.service.BotService;
import com.mars.service.MarsService;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {

    @Autowired
    private MarsService marsService;
    
    @Autowired
    private BotService botService;

    @ResponseBody
    @RequestMapping(value = "/{command}", method = RequestMethod.POST)
    public String execute(@PathVariable("command") final String command) {
        return marsService.execute(botService.createBot(), command).finalPosition();
    }
}
