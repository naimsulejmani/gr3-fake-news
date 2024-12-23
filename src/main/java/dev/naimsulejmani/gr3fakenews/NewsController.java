package dev.naimsulejmani.gr3fakenews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService service;

    @GetMapping
    public String listNews(Model model) {
        var newsList = service.findAll();
        model.addAttribute("newsList", newsList);
        return "news/home";
    }
}









