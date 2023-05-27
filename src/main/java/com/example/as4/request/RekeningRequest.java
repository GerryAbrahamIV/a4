package com.example.as4.request;

public class RekeningRequest {
    private Long id;
    private String nama;
    private String jenis;
    private String rekening;
    private String alamat;
    private KaryawanRequest karyawan;

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

    public KaryawanRequest getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(KaryawanRequest karyawan) {
        this.karyawan = karyawan;
    }
}
