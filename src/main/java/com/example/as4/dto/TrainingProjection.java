package com.example.as4.dto;

import java.sql.Timestamp;

public interface TrainingProjection {
    Long getId();
    String getTema();
    String getPengajar();
    Timestamp getCreated_date();
    Timestamp getUpdated_date();
    Timestamp getDeleted_date();
}
