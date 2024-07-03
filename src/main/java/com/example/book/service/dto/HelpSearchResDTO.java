package com.example.book.service.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HelpSearchResDTO {
    private DetailTypeResDTO nameCategory;
    private List<DetailTypeResDTO> typeDetail;

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailTypeResDTO {
        private Long id;
        private String name;
    }
}
