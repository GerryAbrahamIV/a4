package com.example.as4.models;


import jakarta.persistence.*;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "testcol")
    private String testcol;

    @Column(name = "city")
    private String city;

    @Column(name = "testcol1")
    private String testcol1;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTestcol() {
        return testcol;
    }

    public String getCity() {
        return city;
    }

    public String getTestcol1() {
        return testcol1;
    }

    protected Test() {}



}