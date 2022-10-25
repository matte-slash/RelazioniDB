package com.ITCube.RelazioniDB.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "indirizzo")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="country", columnDefinition="TEXT")
    @NotBlank(message="the country must be present")
    private String country;

    @Column(name="city", columnDefinition="TEXT")
    @NotBlank(message="the city must be present")
    private String city;

    @Column(name="zipcode", columnDefinition="TEXT")
    @NotBlank(message="the zipCode must be present")
    private String zipCode;

    @Column(name="street", columnDefinition="TEXT")
    @NotBlank(message="the street must be present")
    private String street;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Author author;

    public Address() {
    }

    public Address(String country, String city, String zipCode, String street) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", author=" + author +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setAuthor(Author author) { this.author=author; }
}
