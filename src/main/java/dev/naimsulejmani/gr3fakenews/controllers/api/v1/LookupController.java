package dev.naimsulejmani.gr3fakenews.controllers.api.v1;


import dev.naimsulejmani.gr3fakenews.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lookup")
public class LookupController {

    @GetMapping("/categories")
    public Category[] getCategories() {
        return Category.values();
    }
}











