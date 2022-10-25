package com.ITCube.RelazioniDB.controller;

import com.ITCube.RelazioniDB.exception.AuthorNotFoundException;
import com.ITCube.RelazioniDB.exception.BookNotFoundException;
import com.ITCube.RelazioniDB.model.Book;
import com.ITCube.RelazioniDB.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    private final BookServiceImpl book;

    @Autowired
    public BookController(BookServiceImpl book) {
        this.book = book;
    }

    @GetMapping
    public List<Book> findAll(){

        List<Book> result = new ArrayList<Book>();
        book.findAll().forEach(result::add);
        return result;

    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable long id) throws BookNotFoundException {

        return book.findOne(id);

    }

    @PostMapping
    public Book create(@RequestBody @Valid Book b){

        return book.create(b);

    }

    @PostMapping("/{idA}/add/{id}")
    public Book add(@PathVariable long id,@PathVariable long idA) throws AuthorNotFoundException,
                                                            BookNotFoundException {

        return book.addAuthor(id,idA);

    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws BookNotFoundException{

        book.deleteBook(id);

    }

    @ResponseStatus(value= HttpStatus.OK)
    @PutMapping("/{id}")
    public Book update(@PathVariable long id,@RequestBody Book b) throws BookNotFoundException {
        return book.update(id,b);
    }

}
