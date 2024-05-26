package com.mypet.mungmoong.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypet.mungmoong.reserve.service.ReserveService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    ReserveService reserveService;

    @GetMapping("/{page}")
    public String test(@PathVariable("page") String page) {
        return "/board/" + page;
    }
}







