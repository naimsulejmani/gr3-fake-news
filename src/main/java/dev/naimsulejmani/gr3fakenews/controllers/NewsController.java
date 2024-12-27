package dev.naimsulejmani.gr3fakenews.controllers;

import dev.naimsulejmani.gr3fakenews.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
//    private final NewsService service;

    @GetMapping
    public String listNews(Model model) {
//        var newsList = service.findAll();
//        model.addAttribute("newsList", newsList);
        model.addAttribute("calledTime", LocalDateTime.now());
        return "news/home";
    }
}









