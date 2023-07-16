package com.example.as4.models;


import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "detail_karyawan")
public class DetailKaryawan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nik")
    private String nik;

    @Column(name = "npwp")
    private String npwp;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name = "deleted_date")
    private Timestamp deleted_date;

    @Column(name = "updated_date")
    private Timestamp updated_date;

    public DetailKaryawan() {}

    public Long getId() {
        return id;
    }

    public String getNik() {
        return nik;
    }

    public String getNpwp() {
        return npwp;
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

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
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