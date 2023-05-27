package com.example.as4.response;

import com.example.as4.dto.RekeningProjection;
import com.example.as4.models.Karyawan;
import com.example.as4.models.Rekening;

import java.sql.Timestamp;

public class RekeningResponse {
    private Long id;
    private String nama, jenis, rekening, alamat;
    private Long karyawan_id;
    private String karyawan_name;
    private Timestamp created_date, updated_date, deleted_date;

    public RekeningResponse(){}
    public RekeningResponse(Rekening rekening, Karyawan karyawan){
        this.id = rekening.getId();
        this.nama = rekening.getNama();
        this.jenis = rekening.getJenis();
        this.rekening = rekening.getRekening();
        this.alamat = rekening.getAlamat();
        this.karyawan_id = karyawan.getId();
        this.karyawan_name = karyawan.getNama();
        this.created_date = rekening.getCreated_date();
        this.updated_date = rekening.getUpdated_date();
        this.deleted_date = rekening.getDeleted_date();
    }
    public RekeningResponse(RekeningProjection projection){
        this.id = projection.getId();
        this.nama = projection.getNama();
        this.jenis = projection.getJenis();
        this.rekening = projection.getRekening();
        this.alamat = projection.getAlamat();
        this.karyawan_id = projection.getIdKaryawan();
        this.karyawan_name = projection.getNamaKaryawan();
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

    public Long getKaryawan_id() {
        return karyawan_id;
    }

    public void setKaryawan_id(Long karyawan_id) {
        this.karyawan_id = karyawan_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKaryawan_name() {
        return karyawan_name;
    }

    public void setKaryawan_name(String karyawan_name) {
        this.karyawan_name = karyawan_name;
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
