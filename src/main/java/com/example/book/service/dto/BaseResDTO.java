package com.example.book.service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BaseResDTO<T> {
    private Integer code;
    private String message;
    private T data;
}
