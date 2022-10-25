package com.ITCube.RelazioniDB.controller;

import com.ITCube.RelazioniDB.exception.AuthorNotFoundException;
import com.ITCube.RelazioniDB.model.Author;
import com.ITCube.RelazioniDB.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
@Validated
public class AuthorController {

    private final AuthorServiceImpl a;

    @Autowired
    public AuthorController(AuthorServiceImpl a){
        this.a=a;
    }

    @ResponseStatus(value=HttpStatus.OK)
    @GetMapping
    public List<Author> findAll(){
        return a.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value= HttpStatus.OK)
    public Author findOne(@PathVariable long id) throws AuthorNotFoundException {
        return a.findOne(id);
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping
    public Author create(@RequestBody @Valid Author author){ return a.create(author); }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws AuthorNotFoundException {
        a.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Author update(@PathVariable long id, @RequestBody @Valid Author author) throws AuthorNotFoundException {

        return a.update(id, author);

    }


}
