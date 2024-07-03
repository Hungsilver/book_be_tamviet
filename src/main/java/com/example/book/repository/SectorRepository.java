package com.example.book.repository;

import com.example.book.domain.Author;
import com.example.book.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector,Integer> {
}
