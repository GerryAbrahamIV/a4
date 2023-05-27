package com.example.as4.response;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.models.DetailKaryawan;
import com.example.as4.models.Karyawan;

import java.sql.Timestamp;

public class KaryawanResponse {
    private Long id;
    private String nama, status, alamat;
    private Timestamp dob, created_date, updated_date, deleted_date;

    private DetailKaryawanResponse detail;

    public KaryawanResponse(){}
    public KaryawanResponse(Karyawan karyawan, DetailKaryawan detailKaryawan){
        this.setId(karyawan.getId());
        this.setAlamat(karyawan.getAlamat());
        this.setNama(karyawan.getNama());
        this.setDob(karyawan.getDob());
        this.setStatus(karyawan.getStatus());
        this.setCreated_date(karyawan.getCreated_date());
        this.setUpdated_date(karyawan.getUpdated_date());
        this.setDeleted_date(karyawan.getDeleted_date());

        DetailKaryawanResponse resdet = new DetailKaryawanResponse();
        resdet.setId(detailKaryawan.getId());
        resdet.setNik(detailKaryawan.getNik());
        resdet.setNpwp(detailKaryawan.getNpwp());
        resdet.setCreated_date(detailKaryawan.getCreated_date());
        resdet.setUpdated_date(detailKaryawan.getUpdated_date());
        resdet.setDeleted_date(detailKaryawan.getDeleted_date());
        this.setDetail(resdet);
    }
    public KaryawanResponse(KaryawanProjection projection){
        this.setId(projection.getId());
        this.setAlamat(projection.getAlamat());
        this.setNama(projection.getNama());
        this.setDob(projection.getDob());
        this.setStatus(projection.getStatus());
        this.setCreated_date(projection.getCreated_date());
        this.setUpdated_date(projection.getUpdated_date());
        this.setDeleted_date(projection.getDeleted_date());

        DetailKaryawanResponse resdet = new DetailKaryawanResponse();
        resdet.setId(projection.getId_detail());
        resdet.setNik(projection.getNik());
        resdet.setNpwp(projection.getNpwp());
        resdet.setCreated_date(projection.getCreated_date_detail());
        resdet.setUpdated_date(projection.getUpdated_date_detail());
        resdet.setDeleted_date(projection.getDeleted_date_detail());
        this.setDetail(resdet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
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

    public DetailKaryawanResponse getDetail() {
        return detail;
    }

    public void setDetail(DetailKaryawanResponse detail) {
        this.detail = detail;
    }
}
