package com.example.book.repository;

import com.example.book.domain.Author;
import com.example.book.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
}
