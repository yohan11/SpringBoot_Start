package com.example.Board.controller;


import com.example.Board.dto.ArticleForm;
import com.example.Board.entity.Article;
import com.example.Board.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new"; //디렉토리 안에 있으므로
    }
    @Autowired
    private ArticleRepository articleRepository;
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){


        Article article = form.toEntity();
        System.out.println(form.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

            return "redirect:/articles/";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model ){
        log.info("id = "+id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity);
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
        model.addAttribute("articleList",articleEntityList);
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
       // Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
       /* if(target != null){
            articleRepository.save(articleEntity);
        }
        return "redirect:/articles/"+articleEntity.getId();*/
        return null;
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id){
        log.info("삭제요청 발생!");
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        if(target!=null){
            articleRepository.delete(target);
        }
        return "redirect:/articles";
    }



}
