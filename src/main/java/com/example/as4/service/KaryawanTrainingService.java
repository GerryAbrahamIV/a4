package com.example.as4.service;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.dto.KaryawanTrainingProjection;
import com.example.as4.dto.TrainingProjection;
import com.example.as4.models.KaryawanTraining;
import com.example.as4.repository.KaryawanRepository;
import com.example.as4.repository.KaryawanTrainingRepository;
import com.example.as4.repository.TrainingRepository;
import com.example.as4.request.DeleteRequest;
import com.example.as4.request.KaryawanTrainingRequest;
import com.example.as4.response.KaryawanTrainingListResponse;
import com.example.as4.response.KaryawanTrainingResponse;
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
public class KaryawanTrainingService {

    @Autowired
    KaryawanTrainingRepository karyawanTrainingRepository;
    @Autowired
    KaryawanRepository karyawanRepository;
    @Autowired
    TrainingRepository trainingRepository;
    public KaryawanTrainingListResponse karyawanTrainingList(Pageable pageable){
        KaryawanTrainingListResponse response = new KaryawanTrainingListResponse();
        List<KaryawanTrainingResponse> karyawanTrainingList = new ArrayList<>();
        Page<KaryawanTrainingProjection> karyawanTrainingPage = karyawanTrainingRepository.getPageable(pageable);

        for (KaryawanTrainingProjection karyawanTraining:karyawanTrainingPage) {
            KaryawanProjection karyawanProjection = karyawanRepository.findDetailById(karyawanTraining.getId_karyawan());
            TrainingProjection trainingProjection = trainingRepository.findDetailById(karyawanTraining.getId_training());
            KaryawanTrainingResponse single =
                    new KaryawanTrainingResponse(karyawanTraining,karyawanProjection,trainingProjection);

            karyawanTrainingList.add(single);
        }
        response.setKaryawanTrainingList(karyawanTrainingList);
        response.setPage(pageable.getPageNumber());
        response.setPageSize(pageable.getPageSize());
        response.setTotalElements(karyawanTrainingPage.getTotalElements());
        response.setTotalPages(karyawanTrainingPage.getTotalPages());

        return response;
    }

    public KaryawanTrainingResponse  karyawanTrainingDetail(Long id){
        KaryawanTrainingProjection karyawanTraining = karyawanTrainingRepository.findDetailById(id);
        KaryawanProjection karyawanProjection = karyawanRepository.findDetailById(karyawanTraining.getId_karyawan());
        TrainingProjection trainingProjection = trainingRepository.findDetailById(karyawanTraining.getId_training());
        KaryawanTrainingResponse response =
                new KaryawanTrainingResponse(karyawanTraining,karyawanProjection,trainingProjection);
        return response;
    }

    public KaryawanTrainingResponse saveKaryawanTraining(KaryawanTrainingRequest request) throws ParseException {
        KaryawanTraining karyawanTraining = karyawanTrainingRepository.findById(request.getId()).orElse(null);
        return saveUpdateKaryawanTraining(karyawanTraining, request, true);
    }

    public KaryawanTrainingResponse createKaryawanTraining(KaryawanTrainingRequest request) throws ParseException {
        KaryawanTraining karyawanTraining = new KaryawanTraining();
        return saveUpdateKaryawanTraining(karyawanTraining, request, false);
    }

    private KaryawanTrainingResponse saveUpdateKaryawanTraining(KaryawanTraining karyawanTraining,
                                KaryawanTrainingRequest request, boolean isUpdate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(request.getTanggal());

        karyawanTraining.setId_karyawan(request.getKaryawan_id());
        karyawanTraining.setId_training(request.getTraining_id());
        karyawanTraining.setUpdated_date(new Timestamp(new Date().getTime()));
        karyawanTraining.setTanggal(new Timestamp(parsedDate.getTime()));
        if(!isUpdate)
            karyawanTraining.setCreated_date(new Timestamp(new Date().getTime()));
        karyawanTraining = karyawanTrainingRepository.save(karyawanTraining);

        KaryawanProjection karyawanProjection = karyawanRepository.findDetailById(karyawanTraining.getId_karyawan());
        TrainingProjection trainingProjection = trainingRepository.findDetailById(karyawanTraining.getId_training());

        return new KaryawanTrainingResponse(karyawanTraining,karyawanProjection,trainingProjection);
    }

    public String deleteKaryawanTraining(DeleteRequest request){
        KaryawanTraining karyawanTraining = karyawanTrainingRepository.findById(request.getId()).orElse(null);
        karyawanTraining.setDeleted_date(new Timestamp(new Date().getTime()));

        karyawanTrainingRepository.save(karyawanTraining);
        return "success";
    }
}