package com.example.patch.service.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class SealZuulController {
    @GetMapping("/seal/zuul")
    public String equals() {
        log.info("this is test for zuul server.");
        return "This is a seal zuul project1.";
    }
}
