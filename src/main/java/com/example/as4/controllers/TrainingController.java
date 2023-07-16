package com.example.as4.controllers;

import com.example.as4.request.DeleteRequest;
import com.example.as4.request.TrainingRequest;
import com.example.as4.response.Response;
import com.example.as4.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/v1/idstar/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;
    @Autowired
    Response response;

    @GetMapping("/list")
    @PreAuthorize("hasRole('READ')")
    public ResponseEntity<?> trainingList(@PageableDefault(page = 0, size = 20) Pageable pageable){
        return ResponseEntity.ok(response.sukses(trainingService.trainingList(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> trainingDetail(@PathVariable Long id){
        return ResponseEntity.ok(response.sukses(trainingService.trainingDetail(id)));
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('WRITE')")
    public ResponseEntity<?> trainingSave(@RequestBody TrainingRequest request) throws ParseException {
        return ResponseEntity.ok(response.sukses(trainingService.createTraining(request)));
    }

    @PutMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> trainingUpdate(@RequestBody TrainingRequest request) throws ParseException {
        return ResponseEntity.ok(response.sukses(trainingService.saveTraining(request)));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('WRITE')")
    public ResponseEntity<?> trainingDelete(@RequestBody DeleteRequest request){
        return ResponseEntity.ok(response.sukses(trainingService.deleteTraining(request)));
    }

}