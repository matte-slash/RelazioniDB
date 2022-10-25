package com.ITCube.RelazioniDB.service;

import com.ITCube.RelazioniDB.exception.AuthorNotFoundException;
import com.ITCube.RelazioniDB.exception.BookNotFoundException;
import com.ITCube.RelazioniDB.model.Author;
import com.ITCube.RelazioniDB.model.Book;
import com.ITCube.RelazioniDB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository book;
    private final AuthorServiceImpl author;

    @Autowired
    public BookServiceImpl(BookRepository book, AuthorServiceImpl author) {
        this.book = book;
        this.author = author;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result=new ArrayList<>();
        book.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Book findOne(long id) throws BookNotFoundException {
        return book.findById(id).orElseThrow(() -> new BookNotFoundException("Book "+id+" not found"));
    }

    @Override
    public Book create(Book b) {
        return book.save(b);
    }

    @Override
    @Transactional
    public void deleteBook(long id) throws BookNotFoundException {

        book.deleteById(id);

    }

    @Override
    public Book update(long id, Book b) throws BookNotFoundException {

        Book result=findOne(id);
        result.setTitle(b.getTitle());
        result.setDescription(b.getDescription());
        return book.save(result);

    }

    @Override
    @Transactional
    public Book addAuthor(long id, long idA) throws BookNotFoundException, AuthorNotFoundException {
        Book result=findOne(id);
        Author a=author.findOne(idA);
        if(a.getBooks().contains(result)){
            throw new IllegalStateException("book already present");
        }else{
            a.addBook(result);
            result.setAuthor(a);
            return result;
        }

    }
}
