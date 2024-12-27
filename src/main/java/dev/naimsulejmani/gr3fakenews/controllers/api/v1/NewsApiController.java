package dev.naimsulejmani.gr3fakenews.controllers.api.v1;

import dev.naimsulejmani.gr3fakenews.dtos.ArchiveNewsDto;
import dev.naimsulejmani.gr3fakenews.dtos.NewsDto;
import dev.naimsulejmani.gr3fakenews.services.NewsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public NewsDto getNewsById(@Valid @Positive(message = "Id must be positive") @PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsDto addNews(@Valid @RequestBody NewsDto newsDto) {
        return service.add(newsDto);
    }

    @PutMapping("/{id}")
    public NewsDto modifyNews(@Valid @Positive(message = "Id must be positive") @PathVariable long id
            , @RequestBody NewsDto newsDto) {
        return service.modify(id, newsDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNewsById(@Valid @Positive(message = "Id must be positive") @PathVariable long id) {
        service.removeById(id);
    }

    @GetMapping("/default")
    public NewsDto getDefaultNews() {
        return new NewsDto();
    }

    @PatchMapping("/{id}/archive")
    public NewsDto patchNews(@PathVariable long id, @RequestBody ArchiveNewsDto newsDto) {
        return service.archive(id, newsDto);
    }

}






