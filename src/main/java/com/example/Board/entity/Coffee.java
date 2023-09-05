package com.example.Board.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Coffee {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    public void patch(Coffee coffeeEntity) {
        if (coffeeEntity.getName() != null) {
            this.setName(coffeeEntity.getName());
        }
        if (coffeeEntity.getPrice() != null) {
            this.setPrice(coffeeEntity.getPrice());
        }
    }
}
