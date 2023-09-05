package com.example.Board.dto;

import com.example.Board.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CoffeeForm {
    private Long id;
    private String name;
    private String price;

    public Coffee toEntity(){
        return new Coffee(id,name,price);
    }
}
