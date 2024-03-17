package it.epicode.gotneed.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api")
    public class DataController {

        @GetMapping("/data")
        public ResponseEntity<String> getData() {

            String data = "Hello from Spring Boot!";
            return ResponseEntity.ok(data);
        }

    }

