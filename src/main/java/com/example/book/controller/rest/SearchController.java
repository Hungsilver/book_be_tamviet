package com.example.book.controller.rest;

import com.example.book.domain.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.IBookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
//import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Search - tim kiem")
@RequestMapping("/api/help-search")
public class SearchController {

    private final BookRepository bookRepository;

    @GetMapping("/data-help-search")
    private ResponseEntity<Page<Book>> getNewBooks(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }
}
