package com.ITCube.RelazioniDB.repository;

import com.ITCube.RelazioniDB.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
