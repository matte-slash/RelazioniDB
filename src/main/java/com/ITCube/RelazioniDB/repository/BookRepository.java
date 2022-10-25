package com.ITCube.RelazioniDB.repository;

import com.ITCube.RelazioniDB.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
