package com.ITCube.RelazioniDB.service;

import com.ITCube.RelazioniDB.exception.AuthorNotFoundException;
import com.ITCube.RelazioniDB.exception.BookNotFoundException;
import com.ITCube.RelazioniDB.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findOne(long id) throws BookNotFoundException;

    public Book create(Book b);

    public void deleteBook(long id) throws BookNotFoundException;

    public Book update(long id,Book b) throws BookNotFoundException;

    public Book addAuthor(long id, long idA) throws BookNotFoundException, AuthorNotFoundException;

}
