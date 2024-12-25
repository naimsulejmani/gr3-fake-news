package dev.naimsulejmani.gr3fakenews.controllers.api.v1;

import dev.naimsulejmani.gr3fakenews.dtos.NewsDto;
import dev.naimsulejmani.gr3fakenews.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsApiController {
    private final NewsService service;

    @GetMapping
    public List<NewsDto> listNews() {
        return service.findAll();
    }
}
