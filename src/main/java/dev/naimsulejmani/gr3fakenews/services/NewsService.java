package dev.naimsulejmani.gr3fakenews.services;

import dev.naimsulejmani.gr3fakenews.dtos.ArchiveNewsDto;
import dev.naimsulejmani.gr3fakenews.models.Category;
import dev.naimsulejmani.gr3fakenews.dtos.NewsDto;

import java.util.List;

public interface NewsService extends BaseService<NewsDto, Long> {
    List<NewsDto> findAllByCategory(Category category);

    List<NewsDto> findAllByAuthor(String author);

    NewsDto archive(long id, ArchiveNewsDto archiveNewsDto);
}
