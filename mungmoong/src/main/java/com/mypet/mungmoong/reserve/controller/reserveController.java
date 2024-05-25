package com.mypet.mungmoong.reserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypet.mungmoong.reserve.dto.Reserve;
import com.mypet.mungmoong.reserve.service.ReserveService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/reserve")
public class reserveController {
    
    @Autowired
    ReserveService reserveService;

    // @GetMapping("/{page}")
    // public String test(@PathVariable("page") String page) {
    //     return "/reserve/" + page;
    // }
    @GetMapping("/list")
    public String boardList(Model model) throws Exception {
        List<Reserve> reserveList = reserveService.list();
        model.addAttribute("reserveList", reserveList);
        return"/reserve/list";
    }
}
