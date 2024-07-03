package com.example.book.service.impl;

import com.example.book.domain.Author;
import com.example.book.repository.AuthorRepository;
import com.example.book.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author getAll() {
        return null;
    }
}
