package com.example.book.service;

import com.example.book.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> getNewBooks(Pageable pageable);
    Page<Book> getBookMaxView(Pageable pageable);
    Page<Book> getBooksByCategoryId(Pageable pageable, Integer categoryId);
    Page<Book> getBooksByPublisherId(Pageable pageable, Integer publisherId);
    Page<Book> getBooksByAuthorId(Pageable pageable, Integer authorId);


    Page<Book> getBooksBySectorId(Pageable pageable, Integer authorId);


    Page<Book> filter(
            String seachAll,
            String nameAuthor,
            List<Integer> categoryIds,
            String nameBook,
            Integer publisherId,
            Pageable pageable);

    Book getOne(Integer id);

}
