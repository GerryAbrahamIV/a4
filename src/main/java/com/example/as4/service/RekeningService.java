package com.example.as4.service;

import com.example.as4.dto.RekeningProjection;
import com.example.as4.models.Karyawan;
import com.example.as4.models.Rekening;
import com.example.as4.repository.KaryawanRepository;
import com.example.as4.repository.RekeningRepository;
import com.example.as4.request.DeleteRequest;
import com.example.as4.request.RekeningRequest;
import com.example.as4.response.RekeningListResponse;
import com.example.as4.response.RekeningResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RekeningService {

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    KaryawanRepository karyawanRepository;

    public RekeningListResponse rekeningList(Pageable pageable){
        RekeningListResponse response = new RekeningListResponse();
        List<RekeningResponse> rekeningList = new ArrayList<>();
        Page<RekeningProjection> rekeningPage = rekeningRepository.getPageable(pageable);

        for (RekeningProjection rekening:rekeningPage) {
            RekeningResponse single = new RekeningResponse(rekening);
            rekeningList.add(single);
        }

        response.setRekeningList(rekeningList);
        response.setPage(pageable.getPageNumber());
        response.setPageSize(pageable.getPageSize());
        response.setTotalElements(rekeningPage.getTotalElements());
        response.setTotalPages(rekeningPage.getTotalPages());

        return response;
    }

    public RekeningResponse  rekeningDetail(Long id){
        RekeningProjection rekening = rekeningRepository.findDetailById(id);
        RekeningResponse response = new RekeningResponse(rekening);
        return response;
    }

    public RekeningResponse saveRekening(RekeningRequest request) throws ParseException {
        Rekening rekening = rekeningRepository.findById(request.getId()).orElse(null);
        return saveUpdateRekening(rekening, request, true);
    }

    public RekeningResponse createRekening(RekeningRequest request) throws ParseException {
        Rekening rekening = new Rekening();
        return saveUpdateRekening(rekening, request, false);
    }

    private RekeningResponse saveUpdateRekening(Rekening rekening,
                                RekeningRequest request, boolean isUpdate) throws ParseException {
        rekening.setRekening(request.getRekening());
        rekening.setNama(request.getNama());
        rekening.setJenis(request.getJenis());
        rekening.setAlamat(request.getAlamat());
        rekening.setUpdated_date(new Timestamp(new Date().getTime()));
        rekening.setId_karyawan(request.getKaryawan().getId());
        if(!isUpdate)
            rekening.setCreated_date(new Timestamp(new Date().getTime()));

        Karyawan karyawan = karyawanRepository.findById(rekening.getId_karyawan()).orElse(null);
        rekening = rekeningRepository.save(rekening);

        return new RekeningResponse(rekening, karyawan);
    }

    public String deleteRekening(DeleteRequest request){
        Rekening rekening = rekeningRepository.findById(request.getId()).orElse(null);
        rekening.setDeleted_date(new Timestamp(new Date().getTime()));

        rekeningRepository.save(rekening);
        return "success";
    }
}