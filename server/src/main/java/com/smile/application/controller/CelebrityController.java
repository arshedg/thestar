package com.smile.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by agulshan on 16/11/17.
 */
@RestController
@RequestMapping("/api/celebrity")
public class CelebrityController {

    @RequestMapping(method = RequestMethod.GET)
    public String celebrity(){
        return "celebrity";
    }
}
