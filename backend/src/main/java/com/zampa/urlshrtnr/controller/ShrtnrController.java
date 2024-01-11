package com.zampa.urlshrtnr.controller;

import com.zampa.urlshrtnr.model.ShrtnrRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShrtnrController {

    @GetMapping("/{hash}")
    public ResponseEntity<byte[]> getLongURL(@PathVariable String hash){
        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "http://google.com/search?q="+hash);
        return new ResponseEntity<byte []>(null,headers,HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<?> addURL(@Valid @RequestBody ShrtnrRequest request){
        ShrtnrResponse response = new ShrtnrResponse();

        response.setUrl("responseURL");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
