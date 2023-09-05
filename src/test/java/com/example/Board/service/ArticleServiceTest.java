package com.example.Board.service;

import com.example.Board.dto.ArticleForm;
import com.example.Board.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        List<Article> articles = articleService.index();

        Article a = new Article(1L, "aaaa","1111");
        Article b = new Article(2L, "bbbb","2222");
        Article c = new Article(3L, "cccc","3333");

        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void create_success() {
        String title = "aaaa";
        String content = "1111";

        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(1L, title, content);

        Article article  = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void create_fail() {
        Long id = 1L;
        String title = "aaaa";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null;

        Article article = articleService.create(dto);
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void update_success(){
        Long id = 1L;
        String title = "null";
        String content = "1111";

        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id,title,content);
        Article article = articleService.update(id,dto);
        assertEquals(expected.toString(),article.toString());
    }
}