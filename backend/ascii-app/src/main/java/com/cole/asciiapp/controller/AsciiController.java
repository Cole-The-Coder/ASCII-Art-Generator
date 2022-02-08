package com.cole.asciiapp.controller;

import com.cole.asciiapp.model.Ascii;
import com.cole.asciiapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AsciiController {
    @Autowired
    AsciiRepository asciiRepository;
    AsciiStore asciiStore;

    @GetMapping("/all_art")
    public ResponseEntity<List<Ascii>> getAllArt(@RequestParam(required = false) String title) {

        try {
            List<Ascii> asciiList = new ArrayList<>();
            if (title == null) {
                asciiList.addAll(asciiRepository.findAll());
            } else {
                asciiList.addAll(asciiRepository.findByTitleContaining(title));
            }

            if (asciiList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(asciiList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
