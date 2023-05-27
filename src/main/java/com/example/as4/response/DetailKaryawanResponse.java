package com.example.as4.response;

import java.sql.Timestamp;

public class DetailKaryawanResponse {
    private Long id;
    private String nik, npwp;
    private Timestamp created_date, updated_date, deleted_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Timestamp updated_date) {
        this.updated_date = updated_date;
    }

    public Timestamp getDeleted_date() {
        return deleted_date;
    }

    public void setDeleted_date(Timestamp deleted_date) {
        this.deleted_date = deleted_date;
    }
}
