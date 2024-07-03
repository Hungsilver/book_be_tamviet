package com.example.book.controller.rest;

import com.example.book.domain.Book;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.CategoryRepository;
import com.example.book.repository.PublisherRepository;
import com.example.book.service.IBookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
//import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "Home - Trang chu")
@RequestMapping("/api/home")
public class HomeController {

    private final IBookService bookService;

    @GetMapping("/new")
    private ResponseEntity<List<Book
            >> getNewBooks(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(bookService.getNewBooks(pageable).getContent());
    }

    @GetMapping("/max-view")
    private ResponseEntity<List<Book>> getBooksMaxView(@ParameterObject Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.getBookMaxView(pageable).getContent());
    }
}
