package com.mypet.mungmoong.trainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @GetMapping("/{page}")
    public String test(@PathVariable("page") String page) {
        return "/trainer/" + page;
    }
    
}
