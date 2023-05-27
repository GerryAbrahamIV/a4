package com.example.as4.response;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.dto.KaryawanTrainingProjection;
import com.example.as4.dto.TrainingProjection;
import com.example.as4.models.Karyawan;
import com.example.as4.models.KaryawanTraining;
import com.example.as4.models.Training;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class KaryawanTrainingResponse {
    private Long id;
    private String tanggal;
    private KaryawanResponse karyawan;
    private TrainingResponse training;
    private Timestamp created_date, updated_date, deleted_date;

    public KaryawanTrainingResponse(){}
    public KaryawanTrainingResponse(KaryawanTrainingProjection karyawanTrainingProjection,
                                    KaryawanProjection karyawan,
                                    TrainingProjection training){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.id = karyawanTrainingProjection.getId();
        if(karyawanTrainingProjection.getTanggal() != null)
            this.tanggal = dateFormat.format(karyawanTrainingProjection.getTanggal());
        this.karyawan = new KaryawanResponse(karyawan);
        this.training = new TrainingResponse(training);
        this.created_date = karyawanTrainingProjection.getCreated_date();
        this.updated_date = karyawanTrainingProjection.getUpdated_date();
        this.deleted_date = karyawanTrainingProjection.getDeleted_date();
    }

    public KaryawanTrainingResponse(KaryawanTraining karyawanTraining,
                                    KaryawanProjection karyawan,
                                    TrainingProjection training){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.id = karyawanTraining.getId();
        if(karyawanTraining.getTanggal()!=null)
            this.tanggal = dateFormat.format(karyawanTraining.getTanggal());
        this.karyawan = new KaryawanResponse(karyawan);
        this.training = new TrainingResponse(training);
        this.created_date = karyawanTraining.getCreated_date();
        this.updated_date = karyawanTraining.getUpdated_date();
        this.deleted_date = karyawanTraining.getDeleted_date();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public KaryawanResponse getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(KaryawanResponse karyawan) {
        this.karyawan = karyawan;
    }

    public TrainingResponse getTraining() {
        return training;
    }

    public void setTraining(TrainingResponse training) {
        this.training = training;
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
