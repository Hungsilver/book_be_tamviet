package com.example.book.controller.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Tag(name = "pool")
@RequestMapping("/api/visitor")
public class VisitorController {

    private AtomicInteger onlineVisitors = new AtomicInteger(0);

    @PostMapping("/enter")
    public void enterSite() {
        onlineVisitors.incrementAndGet();
    }

    @PostMapping("/leave")
    public void leaveSite() {
        onlineVisitors.decrementAndGet();
        int onl = onlineVisitors.get();
        System.out.println("before decrement online"+onl);
    }

    @GetMapping("/count")
    public int getOnlineCount() {
        int onl = onlineVisitors.get();
        System.out.println("get user online"+onl);
        return onl;
    }
}
