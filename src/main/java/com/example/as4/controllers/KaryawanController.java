package com.example.as4.controllers;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.models.Karyawan;
import com.example.as4.models.Rekening;
import com.example.as4.repository.KaryawanRepository;
import com.example.as4.repository.RekeningRepository;
import com.example.as4.request.DeleteRequest;
import com.example.as4.request.KaryawanRequest;
import com.example.as4.request.TestRequest;
import com.example.as4.response.DetailKaryawanResponse;
import com.example.as4.response.KaryawanResponse;
import com.example.as4.response.Response;
import com.example.as4.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/v1/idstar/karyawan")
public class KaryawanController {

    @Autowired
    KaryawanService karyawanService;
    @Autowired
    Response response;

    @GetMapping("/list")
    @PreAuthorize("hasRole('READ')")
    public ResponseEntity<?> karyawanList(@PageableDefault(page = 0, size = 20) Pageable pageable){

        return ResponseEntity.ok(response.sukses(karyawanService.karyawanList(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> karyawanDetail(@PathVariable Long id){
        return ResponseEntity.ok(response.sukses(karyawanService.karyawanDetail(id)));
    }

    @PostMapping("/save")
    public ResponseEntity<?> karyawanSave(@RequestBody KaryawanRequest request) throws ParseException {
        return ResponseEntity.ok(response.sukses(karyawanService.createKaryawan(request)));
    }

    @PutMapping("/save")
    public ResponseEntity<?> karyawanUpdate(@RequestBody KaryawanRequest request) throws ParseException {
        return ResponseEntity.ok(response.sukses(karyawanService.saveKaryawan(request)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> karyawanDelete(@RequestBody DeleteRequest request){
        return ResponseEntity.ok(response.sukses(karyawanService.deleteKaryawan(request)));
    }

/*

    @DeleteMapping("/delete")
    public String karyawanDelete(@RequestBody TestRequest request){
        try {
            Karyawan test = karyawanRepository.findById(request.getId());
            return test.getNama();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }*/
}