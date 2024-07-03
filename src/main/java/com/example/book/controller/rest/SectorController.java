package com.example.book.controller.rest;

import com.example.book.domain.Sector;
import com.example.book.repository.SectorRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Sector - Linh vuc")
@RequestMapping("/api/sector")
public class SectorController {


    private final SectorRepository sectorRepository;

    @GetMapping("")
    private ResponseEntity<List<Sector>> getAll() {
        return ResponseEntity.ok(sectorRepository.findAll());
    }
}
