package com.ITCube.RelazioniDB.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="first_name", columnDefinition = "TEXT")
    @NotBlank(message="The name is required")
    private String firstName;

    @Column(name="surname", columnDefinition = "TEXT")
    @NotBlank(message="The surname is required")
    private String lastName;

    @Column(name="age")
    @Min(18)
    @Max(100)
    private int age;

    @Column(name="email")
    @NotBlank(message="The email is required")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="author")
    @JsonManagedReference
    private Address address;


    @OneToMany(targetEntity = Book.class, mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("author")
    private List<Book> books;


    public void addBook(Book book) {
        books.add(book);
    }


    public Author() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public Author(String firstName, String lastName, int age, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address = address;
        books=new ArrayList<Book>();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firsName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
