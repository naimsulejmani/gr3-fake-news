package dev.naimsulejmani.gr3fakenews;

import java.util.List;

public interface NewsService extends BaseService<NewsDto, Long> {
    List<NewsDto> findAllByCategory(Category category);

    List<NewsDto> findAllByAuthor(String author);
}
