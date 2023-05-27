package com.example.as4.dto;

import java.sql.Timestamp;

public interface KaryawanTrainingProjection {
    Long getId();
    Long getId_karyawan();
    Long getId_training();
    Timestamp getTanggal();
    Timestamp getCreated_date();
    Timestamp getUpdated_date();
    Timestamp getDeleted_date();
}
