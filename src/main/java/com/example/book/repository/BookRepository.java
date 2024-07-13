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

    @Query("SELECT b FROM Book b WHERE b.id IN (SELECT MIN(b2.id) FROM Book b2 WHERE b2.category.id = ?1 GROUP BY b2.title)")
    Page<Book> findByCategoryIdAndDistinctTitle(Pageable pageable, Integer id);

    Page<Book> findAllByAuthorId(Pageable pageable, Integer id);

    Page<Book> findAllByPublisherId(Pageable pageable, Integer id);

// fake data select distinct
    @Query("""
            select  b from Book b
                left join Category c on c.id = b.category.id
                left join Publisher  p on p.id = b.publisher.id
                left join Author a on a.id = b.author.id
                where
                (trim(:searchAll)='' or :searchAll is null or
                lower(b.title) like lower(concat('%',:searchAll,'%')) or
                lower(b.namePdf) like lower(concat('%',:searchAll,'%')) or
                lower(b.pathDocx) like lower(concat('%',:searchAll,'%')) or
                lower(b.note) like lower(concat('%',:searchAll,'%')) or
                lower(b.description) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.id,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.totalPage,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.yearCreate,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.yearPublishing,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.view,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.quantity,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.episodes,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(concat(b.episodesTotal,'') ) like lower(concat('%',:searchAll,'%')) or
                lower(a.name ) like lower(concat('%',:searchAll,'%')) or
                lower(c.name ) like lower(concat('%',:searchAll,'%')) or
                lower(p.name ) like lower(concat('%',:searchAll,'%')) ) and
                (trim(:nameBook)='' or :nameBook is null OR b.title LIKE CONCAT('%', :nameBook, '%')) AND
                (trim(:nameAuthor)='' or :nameAuthor is null OR a.name LIKE CONCAT('%', :nameAuthor, '%')) AND
                (:publisherId IS NULL OR :publisherId = p.id) AND
                (:categoryIds IS NULL OR c.id IN (:categoryIds))
                                    """)
    Page<Book> filter(
            Pageable pageable,
            @Param("searchAll") String searchAll,
            @Param("nameBook") String nameBook,
            @Param("nameAuthor") String nameAuthor,
            @Param("publisherId") Integer publisherId,
            @Param("categoryIds") List<Integer> categoryIds
    );


}
