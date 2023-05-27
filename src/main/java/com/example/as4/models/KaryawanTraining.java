package com.example.as4.models;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_karyawan")
    private Long id_karyawan;

    @Column(name = "id_training")
    private Long id_training;

    @Column(name = "nama")
    private String nama;

    @Column(name = "tanggal")
    private Timestamp tanggal;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name = "deleted_date")
    private Timestamp deleted_date;

    @Column(name = "updated_date")
    private Timestamp updated_date;

    public KaryawanTraining() {}

    public Long getId() {
        return id;
    }

    public Long getId_karyawan() {
        return id_karyawan;
    }

    public Long getId_training() {
        return id_training;
    }

    public String getNama() {
        return nama;
    }

    public Timestamp getTanggal() {
        return tanggal;
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

    public void setId_karyawan(Long id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public void setId_training(Long id_training) {
        this.id_training = id_training;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
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