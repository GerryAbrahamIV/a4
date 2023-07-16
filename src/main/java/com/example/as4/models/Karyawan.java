package com.example.as4.models;


import javax.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "detail_karyawan")
    private Long detail_karyawan;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "status")
    private String status;

    @Column(name = "dob")
    private Timestamp dob;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name = "deleted_date")
    private Timestamp deleted_date;

    @Column(name = "updated_date")
    private Timestamp updated_date;

    public Karyawan() {}

    public Long getId() {
        return id;
    }

    public Long getDetail_karyawan() {
        return detail_karyawan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getDob() {
        return dob;
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

    public void setDetail_karyawan(Long detail_karyawan) {
        this.detail_karyawan = detail_karyawan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
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