package com.example.as4.response;

import com.example.as4.dto.RekeningProjection;
import com.example.as4.dto.TrainingProjection;
import com.example.as4.models.Karyawan;
import com.example.as4.models.Rekening;
import com.example.as4.models.Training;

import java.sql.Timestamp;

public class TrainingResponse {
    private Long id;
    private String tema, pengajar;
    private Timestamp created_date, updated_date, deleted_date;

    public TrainingResponse(){}
    public TrainingResponse(Training training){
        this.id = training.getId();
        this.pengajar = training.getPengajar();
        this.tema = training.getTema();
        this.created_date = training.getCreated_date();
        this.updated_date = training.getUpdated_date();
        this.deleted_date = training.getDeleted_date();
    }
    public TrainingResponse(TrainingProjection projection){
        this.id = projection.getId();
        this.pengajar = projection.getPengajar();
        this.tema = projection.getTema();
        this.created_date = projection.getCreated_date();
        this.updated_date = projection.getUpdated_date();
        this.deleted_date = projection.getDeleted_date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
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
