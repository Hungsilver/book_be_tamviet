package com.example.book.service.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NavbarResDTO {
    private List<NavObjResDTO> category;
    private List<NavObjResDTO> author;
    private List<NavObjResDTO> publisher;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class NavObjResDTO {
        private Integer id;
        private String name;
    }
}
