package com.example.as4.service;

import com.example.as4.dto.TrainingProjection;
import com.example.as4.models.Training;
import com.example.as4.repository.TrainingRepository;
import com.example.as4.request.DeleteRequest;
import com.example.as4.request.TrainingRequest;
import com.example.as4.response.TrainingListResponse;
import com.example.as4.response.TrainingResponse;
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
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;
    public TrainingListResponse trainingList(Pageable pageable){
        TrainingListResponse response = new TrainingListResponse();
        List<TrainingResponse> trainingList = new ArrayList<>();
        Page<TrainingProjection> trainingPage = trainingRepository.getPageable(pageable);

        for (TrainingProjection training:trainingPage) {
            TrainingResponse single = new TrainingResponse(training);
            trainingList.add(single);
        }

        response.setTrainingList(trainingList);
        response.setPage(pageable.getPageNumber());
        response.setPageSize(pageable.getPageSize());
        response.setTotalElements(trainingPage.getTotalElements());
        response.setTotalPages(trainingPage.getTotalPages());

        return response;
    }

    public TrainingResponse  trainingDetail(Long id){
        TrainingProjection training = trainingRepository.findDetailById(id);
        TrainingResponse response = new TrainingResponse(training);
        return response;
    }

    public TrainingResponse saveTraining(TrainingRequest request) throws ParseException {
        Training training = trainingRepository.findById(request.getId()).orElse(null);
        return saveUpdateTraining(training, request, true);
    }

    public TrainingResponse createTraining(TrainingRequest request) throws ParseException {
        Training training = new Training();
        return saveUpdateTraining(training, request, false);
    }

    private TrainingResponse saveUpdateTraining(Training training,
                                TrainingRequest request, boolean isUpdate) throws ParseException {
        training.setTema(request.getTema());
        training.setPengajar(request.getPengajar());
        training.setUpdated_date(new Timestamp(new Date().getTime()));
        if(!isUpdate)
            training.setCreated_date(new Timestamp(new Date().getTime()));

        training = trainingRepository.save(training);

        return new TrainingResponse(training);
    }

    public String deleteTraining(DeleteRequest request){
        Training training = trainingRepository.findById(request.getId()).orElse(null);
        training.setDeleted_date(new Timestamp(new Date().getTime()));

        trainingRepository.save(training);
        return "success";
    }
}