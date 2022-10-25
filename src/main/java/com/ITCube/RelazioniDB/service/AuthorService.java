package com.ITCube.RelazioniDB.service;

import com.ITCube.RelazioniDB.exception.AuthorNotFoundException;
import com.ITCube.RelazioniDB.model.Author;

import java.util.List;

public interface AuthorService {

    public Author create(Author author);

    public List<Author> findAll();

    public Author findOne(long idA) throws AuthorNotFoundException;

    public Author update(long id,Author a)throws AuthorNotFoundException;

}
