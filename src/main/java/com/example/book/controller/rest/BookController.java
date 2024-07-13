package com.example.book.controller.rest;

import com.example.book.domain.Book;
import com.example.book.service.IBookService;
import com.example.book.service.dto.FilterResDTO;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
//@Tag(name = "Book ")
@RequestMapping("/api/book")
public class BookController {

    private final IBookService bookService;

    @GetMapping("/{id}")
    private ResponseEntity<Book> getOne(@PathVariable("id") Integer idBook

    ) {
        return ResponseEntity.ok(bookService.getOne(idBook));
    }

    @GetMapping("/filter")
    private ResponseEntity<FilterResDTO<List<Book>>> filter(
            @ParameterObject Pageable pageable,
            @RequestParam(value = "searchAll", defaultValue = "", required = false) String searchAll,
            @RequestParam(value = "nameAuthor", defaultValue = "", required = false) String nameAuthor,
            @RequestParam(value = "categoryIds", defaultValue = "", required = false) List<Integer> categoryIds,
            @RequestParam(value = "nameBook", defaultValue = "", required = false) String nameBook,
            @RequestParam(value = "publisherId", defaultValue = "", required = false) Integer publisherId
    ) {
        Page<Book> book = bookService.filter(searchAll,nameAuthor, categoryIds, nameBook, publisherId, pageable);
        return ResponseEntity.ok(FilterResDTO.<List<Book>>builder()
                .data(book.getContent())
                .totalPages(book.getTotalPages())
                .totalElements(book.getTotalElements())
                .currentPage(book.getNumber())
                .build());
    }

    @GetMapping("/{id}/category")
    private ResponseEntity<List<Book>> getBooksByCategoryId(@ParameterObject Pageable pageable,@PathVariable("id") Integer id

    ) {
        return ResponseEntity.ok(bookService.getBooksByCategoryId(pageable,id).getContent());
    }
    @GetMapping("/{id}/author")
    private ResponseEntity<List<Book>> getBooksByAuthorId(@ParameterObject Pageable pageable,@PathVariable("id") Integer id

    ) {
        return ResponseEntity.ok(bookService.getBooksByAuthorId(pageable,id).getContent());
    }
    @GetMapping("/{id}/publisher")
    private ResponseEntity<List<Book>> getBooksByPublisherId(@ParameterObject Pageable pageable,@PathVariable("id") Integer id

    ) {
        return ResponseEntity.ok(bookService.getBooksByPublisherId(pageable,id).getContent());
    }


}
