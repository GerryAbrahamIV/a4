package com.example.as4.controllers;

import com.example.as4.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/v1/role-test-global/")
public class TestController {
/*    @Autowired
    public Response response;*/
// .antMatchers("/v1/role-test-global/listbarang").hasAnyAuthority("ROLE_READ")
// .antMatchers("/v1/role-test-global/postbarang").hasAnyAuthority("ROLE_WRITE")
// .antMatchers("/v1/role-test-global/post-baranguser").hasAnyAuthority("ROLE_USER")
// .antMatchers("/v1/role-test-global/post-barangadmin").hasAnyAuthority("ROLE_ADMIN")
    @GetMapping(value = {"/list-barang", "/list-barang/"})
    @PreAuthorize("hasRole('READ')")
    public ResponseEntity<String> list() {
        return new ResponseEntity<String>("GetMapping - list-barang - ROLE_READ ", HttpStatus.OK);
    }
    @PostMapping(value = {"/post-barang", "/post-barang/"})
    @PreAuthorize("hasRole('WRITE')")
    public ResponseEntity<String> save() {
        return new ResponseEntity<String>("PostMapping- post-barang - ROLE_WRITE ", HttpStatus.OK);
    }
    @PostMapping(value = { "/post-baranguser"})
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> saveuser() {
        return new ResponseEntity<String>("PostMapping - post-barang-user - ROLE_USER ", HttpStatus.OK);
    }
    @PostMapping(value = {"/post-barangadmin"})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> saveadmin() {
        return new ResponseEntity<String>("PostMapping post-barang-admin - ROLE_ADMIN ", HttpStatus.OK);
    }
}
