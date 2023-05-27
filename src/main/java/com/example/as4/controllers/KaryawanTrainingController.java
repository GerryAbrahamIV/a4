package com.example.as4.controllers;

import com.example.as4.request.DeleteRequest;
import com.example.as4.request.KaryawanTrainingRequest;
import com.example.as4.response.Response;
import com.example.as4.service.KaryawanTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/v1/idstar/karyawan-training")
public class KaryawanTrainingController {

    @Autowired
    KaryawanTrainingService karyawanTrainingService;

    @GetMapping("/list")
    public ResponseEntity<?> karyawanTrainingList(@PageableDefault(page = 0, size = 20) Pageable pageable){

        return ResponseEntity.ok(new Response(karyawanTrainingService.karyawanTrainingList(pageable), "success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> karyawanTrainingDetail(@PathVariable Long id){
        return ResponseEntity.ok(new Response(karyawanTrainingService.karyawanTrainingDetail(id), "success"));
    }

    @PostMapping("/save")
    public ResponseEntity<?> karyawanTrainingSave(@RequestBody KaryawanTrainingRequest request) throws ParseException {
        return ResponseEntity.ok(new Response(karyawanTrainingService.createKaryawanTraining(request), "success"));
    }

    @PutMapping("/save")
    public ResponseEntity<?> karyawanTrainingUpdate(@RequestBody KaryawanTrainingRequest request) throws ParseException {
        return ResponseEntity.ok(new Response(karyawanTrainingService.saveKaryawanTraining(request), "success"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> karyawanTrainingDelete(@RequestBody DeleteRequest request){
        return ResponseEntity.ok(new Response(karyawanTrainingService.deleteKaryawanTraining(request), "success"));
    }

}