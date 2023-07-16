package com.example.as4.controllers;

import com.example.as4.request.DeleteRequest;
import com.example.as4.request.RekeningRequest;
import com.example.as4.response.Response;
import com.example.as4.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/v1/idstar/rekening")
public class RekeningController {

    @Autowired
    RekeningService rekeningService;
    @Autowired
    Response response;

    @GetMapping("/list")
    @PreAuthorize("hasRole('READ')")
    public ResponseEntity<?> rekeningList(@PageableDefault(page = 0, size = 20) Pageable pageable){

        return ResponseEntity.ok(response.sukses(rekeningService.rekeningList(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> rekeningDetail(@PathVariable Long id){
        return ResponseEntity.ok(response.sukses(rekeningService.rekeningDetail(id)));
    }

    @PostMapping("/save")
    public ResponseEntity<?> rekeningSave(@RequestBody RekeningRequest request) throws ParseException {
        return ResponseEntity.ok(response.sukses(rekeningService.createRekening(request)));
    }

    @PutMapping("/save")
    public ResponseEntity<?> rekeningUpdate(@RequestBody RekeningRequest request) throws ParseException {
        return ResponseEntity.ok(response.sukses(rekeningService.saveRekening(request)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> rekeningDelete(@RequestBody DeleteRequest request){
        return ResponseEntity.ok(response.sukses(rekeningService.deleteRekening(request)));
    }

}