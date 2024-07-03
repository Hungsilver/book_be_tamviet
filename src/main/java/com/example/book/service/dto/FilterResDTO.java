package com.example.book.service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FilterResDTO<T> {
    private Long totalElements;
    private Integer totalPages;
    private Integer currentPage;
    private T data;
}
