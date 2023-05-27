package com.example.as4.response;

import java.sql.Timestamp;
import java.util.List;

public class KaryawanListResponse {
    private Integer totalPages, page, pageSize;
    private Long totalElements;

    public List<KaryawanResponse> getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(List<KaryawanResponse> karyawanList) {
        this.karyawanList = karyawanList;
    }

    private List<KaryawanResponse> karyawanList;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
