package com.example.book.domain;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;


    @Column(name = "image",length = 1000)
    private String image;

    @Column(name = "year_create")
    private Integer yearCreate;

    @Column(name = "year_publishing")
    private Integer yearPublishing;

    @Column(name = "total_page")
    private Integer totalPage;

    @Column(name = "view")
    private Integer view;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "path_docx",length = 1000)
    private String pathDocx;

    @Column(name = "path_pdf",length = 1000)
    private String pathPdf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id",referencedColumnName = "id")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sector_id",referencedColumnName = "id")
    private Sector sector;

    @Column(name = "name_pdf")
    private String namePdf;

    @Column(name = "episodes")
    private Integer episodes;

    @Column(name = "episodes_total")
    private Integer episodesTotal;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "note")
    private String note;

    @Column(name = "language")
    private String language;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", yearCreate=" + yearCreate +
                ", yearPublishing=" + yearPublishing +
                ", totalPage=" + totalPage +
                ", view=" + view +
                ", quantity=" + quantity +
                ", pathDocs='" + pathDocx + '\'' +
                ", pathPdf='" + pathPdf + '\'' +
                ", namePdf='" + namePdf + '\'' +
                ", episodes=" + episodes +
                ", episodesTotal=" + episodesTotal +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", language='" + language + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
