package com.ITCube.RelazioniDB.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title", columnDefinition="TEXT")
    @NotBlank(message="The title is required")
    private String title;

    @Column(name="description", columnDefinition="TEXT")
    @NotBlank(message="The description is required")
    private String description;

    @ManyToOne(targetEntity=Author.class)
    @JoinColumn(name="author_id",referencedColumnName="id")
    @JsonIgnoreProperties("books")
    private Author author;

    public Book() {
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
