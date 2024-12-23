package dev.naimsulejmani.gr3fakenews;

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
