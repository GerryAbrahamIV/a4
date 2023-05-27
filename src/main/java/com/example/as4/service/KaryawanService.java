package com.example.as4.service;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.models.DetailKaryawan;
import com.example.as4.models.Karyawan;
import com.example.as4.repository.DetailKaryawanRepository;
import com.example.as4.repository.KaryawanRepository;
import com.example.as4.request.DeleteRequest;
import com.example.as4.request.KaryawanRequest;
import com.example.as4.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class KaryawanService {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    DetailKaryawanRepository detailKaryawanRepository;

    public KaryawanListResponse karyawanList(Pageable pageable){
        KaryawanListResponse response = new KaryawanListResponse();

        List<KaryawanResponse> karyawanList = new ArrayList<>();
        Page<KaryawanProjection> karyawanPage = karyawanRepository.getPageable(pageable);
        for (KaryawanProjection karyawan:karyawanPage) {
            KaryawanResponse single = new KaryawanResponse(karyawan);
            karyawanList.add(single);
        }
        response.setKaryawanList(karyawanList);
        response.setPage(pageable.getPageNumber());
        response.setPageSize(pageable.getPageSize());
        response.setTotalElements(karyawanPage.getTotalElements());
        response.setTotalPages(karyawanPage.getTotalPages());

        return response;
    }

    public KaryawanResponse  karyawanDetail(Long id){
        KaryawanProjection karyawan = karyawanRepository.findDetailById(id);
        KaryawanResponse response = new KaryawanResponse(karyawan);
        return response;
    }

    public KaryawanResponse saveKaryawan(KaryawanRequest request) throws ParseException {
        Karyawan karyawan = karyawanRepository.findById(request.getId()).orElse(null);
        DetailKaryawan detailKaryawan = detailKaryawanRepository.findById(karyawan.getDetail_karyawan()).orElse(null);
        return saveUpdateKaryawan(karyawan, detailKaryawan, request, true);
    }

    public KaryawanResponse createKaryawan(KaryawanRequest request) throws ParseException {
        Karyawan karyawan = new Karyawan();
        DetailKaryawan detailKaryawan = new DetailKaryawan();
        return saveUpdateKaryawan(karyawan, detailKaryawan, request, false);
    }

    private KaryawanResponse saveUpdateKaryawan(Karyawan karyawan, DetailKaryawan detailKaryawan,
                                KaryawanRequest request, boolean isUpdate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(request.getDob());

        karyawan.setStatus(request.getStatus());
        karyawan.setNama(request.getNama());
        karyawan.setAlamat(request.getAlamat());
        karyawan.setDob(new Timestamp(parsedDate.getTime()));
        karyawan.setUpdated_date(new Timestamp(new Date().getTime()));
        if(!isUpdate)
            karyawan.setCreated_date(new Timestamp(new Date().getTime()));

        detailKaryawan.setNik(request.getDetailKaryawan().getNik());
        detailKaryawan.setNpwp(request.getDetailKaryawan().getNpwp());
        detailKaryawan.setUpdated_date(new Timestamp(new Date().getTime()));
        if(!isUpdate)
            detailKaryawan.setCreated_date(new Timestamp(new Date().getTime()));

        detailKaryawan = detailKaryawanRepository.save(detailKaryawan);
        karyawan.setDetail_karyawan(detailKaryawan.getId());
        karyawan = karyawanRepository.save(karyawan);

        return new KaryawanResponse(karyawan,detailKaryawan);
    }

    public String deleteKaryawan(DeleteRequest request){
        Karyawan karyawan = karyawanRepository.findById(request.getId()).orElse(null);
        karyawan.setDeleted_date(new Timestamp(new Date().getTime()));
        DetailKaryawan detailKaryawan = detailKaryawanRepository.findById(karyawan.getDetail_karyawan()).orElse(null);
        detailKaryawan.setDeleted_date(new Timestamp(new Date().getTime()));

        karyawanRepository.save(karyawan);
        detailKaryawanRepository.save(detailKaryawan);

        return "success";
    }
}