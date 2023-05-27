package com.example.as4.dto;

import java.sql.Timestamp;

public interface KaryawanProjection {
    Long getId();
    String getNama();
    String getStatus();
    String getAlamat();
    Timestamp getDob();
    Timestamp getCreated_date();
    Timestamp getUpdated_date();
    Timestamp getDeleted_date();


    Long getId_detail();
    String getNik();
    String getNpwp();
    Timestamp getCreated_date_detail();
    Timestamp getUpdated_date_detail();
    Timestamp getDeleted_date_detail();

}
