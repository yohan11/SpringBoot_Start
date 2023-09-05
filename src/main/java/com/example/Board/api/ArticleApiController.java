package com.example.Board.api;

import com.example.Board.dto.ArticleForm;
import com.example.Board.entity.Article;
import com.example.Board.repository.ArticleRepository;
import com.example.Board.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.hibernate.query.spi.AbstractSelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ArticleApiController {

//    @Autowired
//    private ArticleRepository articleRepository;
//
//    @GetMapping("/api/articles")
//    public List<Article> index(){
//        return (List<Article>)articleRepository.findAll();
//    }
//
//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id){
//        return articleRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("/api/articles")
//    public Article create(@RequestBody ArticleForm dto){
//        Article article = dto.toEntity();
//        return articleRepository.save(article);
//    }
//
//       @PatchMapping ("/api/articles/{id}")
//        public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
//            Article article = dto.toEntity();
//            log.info("id: {}, article: {}",id,article.toString());
//
//            Article target = articleRepository.findById(id).orElse(null);
//
//           if (target == null || id != article.getId()) {
//               log.info("잘못된 요청! id:{}. article:{}",id,article.toString());
//               return ResponseEntity.status(4444).body(null);
//           }
//           target.patch(article);
//           Article updated = articleRepository.save(target);
//
//           return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id){
//        Article target = articleRepository.findById(id).orElse(null);
//        if(target == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @Autowired
    private ArticleService articleService;
    private ArticleRepository articleRepository;


    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        return (created!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



}
