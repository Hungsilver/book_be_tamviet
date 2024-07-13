package com.example.book.service.impl;

import com.example.book.domain.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<Book> getNewBooks(Pageable pageable) {
        return bookRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Book> getBookMaxView(Pageable pageable) {
        return bookRepository.findAllByOrderByViewDesc(pageable);
    }

    @Override
    public Page<Book> getBooksByCategoryId(Pageable pageable, Integer categoryId) {
        return bookRepository.findByCategoryIdAndDistinctTitle(pageable, categoryId);
    }

    @Override
    public Page<Book> getBooksByPublisherId(Pageable pageable, Integer publisherId) {
        return bookRepository.findAllByPublisherId(pageable, publisherId);
    }

    @Override
    public Page<Book> getBooksByAuthorId(Pageable pageable, Integer authorId) {
        return bookRepository.findAllByAuthorId(pageable, authorId);
    }

    @Override
    public Page<Book> getBooksBySectorId(Pageable pageable, Integer authorId) {
        return null;
    }


    @Transactional(readOnly = true)
    @Override
    public Page<Book> filter(
            String searchAll,
            String nameAuthor,
            List<Integer> categoryIds,
            String nameBook,
            Integer publisherId,
            Pageable pageable) {
        if (categoryIds.isEmpty()) {
            categoryIds = null;
        }

        Page<Book> book = bookRepository.filter(pageable, searchAll, nameBook, nameAuthor, publisherId, categoryIds);
        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public Book getOne(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }
}
