package com.example.as4.models;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Rekening {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_karyawan")
    private Long id_karyawan;

    @Column(name = "nama")
    private String nama;

    @Column(name = "rekening")
    private String rekening;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name = "deleted_date")
    private Timestamp deleted_date;

    @Column(name = "updated_date")
    private Timestamp updated_date;

    public Rekening() {}

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getRekening() {
        return rekening;
    }
    public String getJenis() {
        return jenis;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public Long getId_karyawan() {
        return id_karyawan;
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

    public void setId_karyawan(Long id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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