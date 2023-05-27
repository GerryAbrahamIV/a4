package com.example.as4.controllers;

import com.example.as4.request.DeleteRequest;
import com.example.as4.request.TrainingRequest;
import com.example.as4.response.Response;
import com.example.as4.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/v1/idstar/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @GetMapping("/list")
    public ResponseEntity<?> trainingList(@PageableDefault(page = 0, size = 20) Pageable pageable){

        return ResponseEntity.ok(new Response(trainingService.trainingList(pageable), "success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> trainingDetail(@PathVariable Long id){
        return ResponseEntity.ok(new Response(trainingService.trainingDetail(id), "success"));
    }

    @PostMapping("/save")
    public ResponseEntity<?> trainingSave(@RequestBody TrainingRequest request) throws ParseException {
        return ResponseEntity.ok(new Response(trainingService.createTraining(request), "success"));
    }

    @PutMapping("/save")
    public ResponseEntity<?> trainingUpdate(@RequestBody TrainingRequest request) throws ParseException {
        return ResponseEntity.ok(new Response(trainingService.saveTraining(request), "success"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> trainingDelete(@RequestBody DeleteRequest request){
        return ResponseEntity.ok(new Response(trainingService.deleteTraining(request), "success"));
    }

}