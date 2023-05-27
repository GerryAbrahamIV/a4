package com.example.as4.dto;

import java.sql.Timestamp;

public interface RekeningProjection {
    Long getId();
    String getNama();
    String getJenis();
    String getRekening();
    String getAlamat();
    Timestamp getCreated_date();
    Timestamp getUpdated_date();
    Timestamp getDeleted_date();
    Long getIdKaryawan();
    String getNamaKaryawan();
}
