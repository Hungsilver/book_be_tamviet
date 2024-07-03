package com.example.book.repository;

import com.example.book.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Page<Book> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<Book> findAllByOrderByViewDesc(Pageable pageable);

    Page<Book> findAllByCategoryId(Pageable pageable, Integer id);

    Page<Book> findAllByAuthorId(Pageable pageable, Integer id);

    Page<Book> findAllByPublisherId(Pageable pageable, Integer id);

    @Query("""
            select b from Book b
                left join Category  c on c.id = b.category.id
                left join Publisher  p on p.id = b.publisher.id
                left join Author a on a.id = b.author.id
                where
                       (trim(:nameBook)='' or :nameBook is null OR b.title LIKE CONCAT('%', :nameBook, '%')) AND
                       (trim(:nameAuthor)='' or :nameAuthor is null OR a.name LIKE CONCAT('%', :nameAuthor, '%')) AND
                       (:publisherId IS NULL OR :publisherId = p.id) AND
                       (:categoryIds IS NULL OR c.id IN (:categoryIds))
                                    """)
    Page<Book> filter(
            Pageable pageable,
            @Param("nameBook") String nameBook,
            @Param("nameAuthor") String nameAuthor,
            @Param("publisherId") Integer publisherId,
            @Param("categoryIds") List<Integer> categoryIds
    );



}
