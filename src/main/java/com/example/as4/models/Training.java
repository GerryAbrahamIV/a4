package com.example.as4.models;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pengajar")
    private String pengajar;

    @Column(name = "tema")
    private String tema;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name = "deleted_date")
    private Timestamp deleted_date;

    @Column(name = "updated_date")
    private Timestamp updated_date;

    public Training() {}

    public Long getId() {
        return id;
    }

    public String getPengajar() {
        return pengajar;
    }

    public String getTema() {
        return tema;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public Timestamp getDeleted_date() {
        return deleted_date;
    }

    public Timestamp getUpdated_date() {
        return updated_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public void setDeleted_date(Timestamp deleted_date) {
        this.deleted_date = deleted_date;
    }

    public void setUpdated_date(Timestamp updated_date) {
        this.updated_date = updated_date;
    }
}