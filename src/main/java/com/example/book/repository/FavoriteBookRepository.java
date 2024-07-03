package com.example.book.repository;

import com.example.book.domain.Author;
import com.example.book.domain.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteBookRepository extends JpaRepository<FavoriteBook,Integer> {
}
