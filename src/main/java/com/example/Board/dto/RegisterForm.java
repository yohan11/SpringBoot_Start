package com.example.Board.dto;

import com.example.Board.entity.Register;
import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString

public class RegisterForm {
private Long id;
    private String email;
    private String password;
    public RegisterForm(Long id,String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public Register toEntity(){
        return new Register(id,email,password);
    }



}
