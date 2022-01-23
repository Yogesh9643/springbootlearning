package com.firstproject.learningms.controller;


import com.firstproject.learningms.model.Books;
import com.firstproject.learningms.repository.JpaRepo;
import com.sun.source.tree.LambdaExpressionTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UserController {
@Autowired private JpaRepo jpaRepo;
@GetMapping ("/books")
private List<Books> getBooks(){
    return jpaRepo.findAll();
}

@PostMapping("/addbook")
    private String addbook(@RequestBody Books book){
        jpaRepo.save(book);
    return "Book added successfully";
}
@GetMapping("/books/{id}")
    private Optional<Books> getBook(@PathVariable Integer id){
         return jpaRepo.findById(id);
}

@DeleteMapping("/books/{id}")
    private String deleteBooks(@PathVariable Integer id){
    if(jpaRepo.findById(id)==null){
        return "Can't find book by this id";
    }
    else{
        jpaRepo.deleteById(id);
        return "Book has been deleted";
    }
}

}
