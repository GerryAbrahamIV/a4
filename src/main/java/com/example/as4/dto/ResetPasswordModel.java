package com.example.as4.dto;

import lombok.Data;


@Data
public class ResetPasswordModel {
    public String username;
    public String otp;
    public String newPassword;
}

