package com.example.as4.response;

import java.util.List;

public class KaryawanTrainingListResponse {
    private Integer totalPages, page, pageSize;
    private Long totalElements;

    private List<KaryawanTrainingResponse> karyawanTrainingList;
    
    public void setKaryawanTrainingList(List<KaryawanTrainingResponse> karyawanTrainingList) {
        this.karyawanTrainingList = karyawanTrainingList;
    }

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

    public List<KaryawanTrainingResponse> getKaryawanTrainingList() {
        return karyawanTrainingList;
    }
}
