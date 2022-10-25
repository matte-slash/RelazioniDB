package com.ITCube.RelazioniDB.service;

import com.ITCube.RelazioniDB.exception.AuthorNotFoundException;
import com.ITCube.RelazioniDB.model.Address;
import com.ITCube.RelazioniDB.model.Author;
import com.ITCube.RelazioniDB.repository.AddressRepository;
import com.ITCube.RelazioniDB.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository author;
    private final AddressRepository address;

    @Autowired
    public AuthorServiceImpl(AuthorRepository author, AddressRepository address){
        this.author = author;
        this.address=address;
    }

    @Override
    public Author create(Author a) {
        Address addr=address.save(a.getAddress());
        a.setAddress(addr);

        Author result=author.save(a);

        addr.setAuthor(result);

        return result;

    }

    @Override
    public List<Author> findAll() {
        List<Author> result=new ArrayList<>();
        author.findAll().forEach(result::add);
        return result;
    }

    public Author findOne(long idA) throws AuthorNotFoundException {

        return author.findById(idA).orElseThrow(()->new AuthorNotFoundException("Author "+idA+" not found"));

    }

    public void delete(long id) throws AuthorNotFoundException {

        Author a=findOne(id);
        author.deleteById(id);

    }

    public Author update(long id,Author a) throws AuthorNotFoundException {

        Author result=findOne(id);
        result.setAge(a.getAge());
        result.setEmail(a.getEmail());
        result.setFirsName(a.getFirstName());
        result.setLastName(a.getLastName());

        Address ad=result.getAddress();
        result.setAddress(a.getAddress());

        result=author.save(result);

        address.delete(ad);

        return result;

    }

}
