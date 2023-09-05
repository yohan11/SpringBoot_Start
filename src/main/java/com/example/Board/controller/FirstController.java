package com.example.Board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String NiceToMeetYou(Model model){
        model.addAttribute("username","준영");
        return "hello";
    }
    @GetMapping( "/bye")
    public String SeeYouAgain(Model model){
        model.addAttribute("username","주녕");
        return "goodbye";
    }

    @GetMapping("/randomquote")
    public String RandomQuote(Model model){
        String[] quoteList={"1번 명언","2번 명언임다","3번 명언이에유"};
        int randomNum = (int)Math.random()*quoteList.length;
        model.addAttribute("quote", quoteList[randomNum]);
        return "randomquote";
    }
}
