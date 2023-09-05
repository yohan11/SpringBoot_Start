package com.example.Board.repository;

import com.example.Board.entity.Article;
import com.example.Board.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /*
        Long articleId = 4L;
        Article article = new Article(4L, "당신의 인생영화","댓글 고");
        Comment a = new Comment(1L,article,"Park","Good will hunting");
        Comment b = new Comment(2L,article,"KIm","Twilight");
        Comment c = new Comment(3L,article,"Hong","I am Sam");
        List<Comment> expected = Arrays.asList(a,b,c);

        List<Comment> comments = commentRepository.findByArticleId(articleId);
        assertEquals(expected.toString(), comments.toString(),"4번 글의 모든 댓글을 출력");
        */
        Long articleId = 1L;
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        Article article = new Article(1L, "aaaa", "1111");
        List<Comment> expected = Arrays.asList();

        assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음" );
    }



    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        String nickname = "Hong";
        List<Comment> comments = commentRepository.findByNickname(nickname);
        Comment a = new Comment(3L, new Article(4L, "당신의 인생영화","댓글 고"), nickname, "I am Sam");
        Comment b = new Comment(6L, new Article(5L, "당신의 소울푸드는?","댓글 고"), nickname, "QQQ");
        List<Comment> expected = Arrays.asList(a,b);

        assertEquals(expected.toString(),comments.toString(),"Hong의 모든 댓글 출력");



    }
}