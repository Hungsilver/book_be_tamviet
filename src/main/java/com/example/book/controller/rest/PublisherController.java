package com.example.book.controller.rest;

import com.example.book.domain.Category;
import com.example.book.domain.Publisher;
import com.example.book.repository.CategoryRepository;
import com.example.book.repository.PublisherRepository;
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
@Tag(name = "Publisher - nha xuat ban")
@RequestMapping("/api/publisher")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    @GetMapping("")
    private ResponseEntity<List<Publisher>> getAll() {
        return ResponseEntity.ok(publisherRepository.findAll());
    }
}
