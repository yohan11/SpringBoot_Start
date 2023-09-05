package com.example.Board.controller;

import com.example.Board.dto.ArticleForm;
import com.example.Board.dto.RegisterForm;
import com.example.Board.entity.Article;
import com.example.Board.entity.Register;
import com.example.Board.repository.ArticleRepository;
import com.example.Board.repository.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.plaf.ListUI;
import java.util.List;

@Slf4j
@Controller
public class RegisterController {
    @GetMapping("/register/new")
    public String newArticleForm(){
        return "register/new"; //디렉토리 안에 있으므로
    }
    @Autowired
    private RegisterRepository registerRepository;
    @PostMapping("/register/create")
    public String createRegister(RegisterForm form){


        Register register = form.toEntity();
        log.info(register.toString());

        Register saved = registerRepository.save(register);
        log.info(saved.toString());

        return "redirect:/members/"+saved.getId();
    }

    @GetMapping("/members/{id}")
    public String showMembers(@PathVariable Long id, Model model){
        Register register = registerRepository.findById(id).orElse(null);
        model.addAttribute("member",register);
        return "register/member";
    }

    @GetMapping("/members")
    public String showAllMembers(Model model){
        List<Register> registersList = (List<Register>)registerRepository.findAll();
        model.addAttribute("memberList",registersList);
        return "register/members";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Register registerEntity = registerRepository.findById(id).orElse(null);
        model.addAttribute("member",registerEntity);
        return "register/edit";
    }

    @PostMapping("/members/update")
    public String update(RegisterForm form){
        Register register = form.toEntity();
        Register target = registerRepository.findById(register.getId()).orElse(null);
        if(target!=null){
            registerRepository.save(register);
        }

        return "redirect:/members/"+register.getId();
    }
}
