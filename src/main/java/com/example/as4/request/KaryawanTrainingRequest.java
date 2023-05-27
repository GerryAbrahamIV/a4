package com.example.as4.request;

public class KaryawanTrainingRequest {
    private Long id;
    private Long karyawan_id;
    private Long training_id;
    private String tanggal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKaryawan_id() {
        return karyawan_id;
    }

    public void setKaryawan_id(Long karyawan_id) {
        this.karyawan_id = karyawan_id;
    }

    public Long getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Long training_id) {
        this.training_id = training_id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
