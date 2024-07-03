package com.example.book.repository;

import com.example.book.domain.Author;
import com.example.book.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
