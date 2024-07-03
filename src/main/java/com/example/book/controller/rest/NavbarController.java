package com.example.book.controller.rest;

import com.example.book.domain.Author;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.CategoryRepository;
import com.example.book.repository.PublisherRepository;
import com.example.book.service.NavbarService;
import com.example.book.service.dto.NavbarResDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
//import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://thuviendientu.vinhphuc.gov.vn")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

@Tag(name = "Navbar")
@RequestMapping("/api/navbar")
public class NavbarController {

    private final NavbarService navbarService;

    @GetMapping("")
    private ResponseEntity<NavbarResDTO> getDataNavbar(

    ) {
        return ResponseEntity.ok(navbarService.getNavbar());
    }

}
