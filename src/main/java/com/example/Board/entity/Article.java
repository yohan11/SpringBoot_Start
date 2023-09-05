package com.example.Board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {

            if (article.getTitle() != null) {
                this.setTitle(article.getTitle());
            }
            if (article.getContent() != null) {
                this.setContent(article.getContent());
        }
    }
}
