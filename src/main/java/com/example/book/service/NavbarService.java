package com.example.book.service;

import com.example.book.repository.AuthorRepository;
import com.example.book.repository.CategoryRepository;
import com.example.book.repository.PublisherRepository;
import com.example.book.service.dto.NavbarResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class NavbarService {

    private final CategoryRepository categoryRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public NavbarResDTO getNavbar() {
        List<NavbarResDTO.NavObjResDTO> categories = categoryRepository.findAll().stream().map(item -> NavbarResDTO.NavObjResDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .build())
                .collect(Collectors.toList());
        List<NavbarResDTO.NavObjResDTO> authors = authorRepository.findAll().stream().map(item -> NavbarResDTO.NavObjResDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .build())
                .collect(Collectors.toList());
        List<NavbarResDTO.NavObjResDTO> publishers = publisherRepository.findAll().stream().map(item -> NavbarResDTO.NavObjResDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .build())
                .collect(Collectors.toList());

        return NavbarResDTO.builder()
                .category(categories)
                .author(authors)
                .publisher(publishers)
                .build();
    }
}
