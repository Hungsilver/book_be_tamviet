package com.example.book.controller.rest;

import com.example.book.domain.Author;
import com.example.book.domain.Category;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.CategoryRepository;
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
@Tag(name = "Author - Tac gia")
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("")
    private ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorRepository.findAll());
    }
}
