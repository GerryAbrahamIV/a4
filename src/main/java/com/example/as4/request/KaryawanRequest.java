package com.example.as4.request;

public class KaryawanRequest {
    private Long id;
    private String nama;
    private String dob;
    private String status;
    private String alamat;
    private KaryawanDetailRequest detailKaryawan;

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public KaryawanDetailRequest getDetailKaryawan() {
        return detailKaryawan;
    }

    public void setDetailKaryawan(KaryawanDetailRequest detailKaryawan) {
        this.detailKaryawan = detailKaryawan;
    }
}
