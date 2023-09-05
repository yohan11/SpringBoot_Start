package com.example.Board.api;

import com.example.Board.dto.CoffeeForm;
import com.example.Board.entity.Coffee;
import com.example.Board.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeApiController {

//    @Autowired
//    CoffeeRepository coffeeRepository;
//
//    @GetMapping("/api/coffee")
//    public List<Coffee> showAllCoffee(){
//        return (List<Coffee>) coffeeRepository.findAll();
//    }
//
//    @GetMapping("/api/coffee/{id}")
//    public Coffee showCoffee(@PathVariable Long id){
//        return coffeeRepository.findById(id).orElse(null);
//    }
//
//   @PostMapping("/api/coffee")
//    public Coffee create(@RequestBody CoffeeForm dto){
//        Coffee coffeeEntity = dto.toEntity();
//        return coffeeRepository.save(coffeeEntity);
//    }
//
//    @PatchMapping("/api/coffee/{id}")
//    public ResponseEntity<Coffee> update(@RequestBody CoffeeForm dto, @PathVariable Long id){
//        Coffee coffeeEntity = dto.toEntity();
//        Coffee target = coffeeRepository.findById(id).orElse(null);
//        if(target == null || id != coffeeEntity.getId()){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        target.patch(coffeeEntity);
//        Coffee updated = coffeeRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//
//    @DeleteMapping("/api/coffee/{id}")
//    public ResponseEntity<Coffee> delete(@PathVariable Long id){
//        Coffee target = coffeeRepository.findById(id).orElse(null);
//        if(target==null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        coffeeRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

}
