package com.example.as4;

import com.example.as4.models.Rekening;
import com.example.as4.models.Test;
import com.example.as4.repository.RekeningRepository;
import com.example.as4.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class As4Application {

    @Autowired
    RekeningRepository rekeningRepository;

    public static void main(String[] args) {
        SpringApplication.run(As4Application.class, args);
    }
    @GetMapping("/hey")
    public String sayHello(@RequestParam(value="id")Long id){
        try {
            Rekening test = rekeningRepository.findById(id).orElse(null);
            return test.getNama();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

}