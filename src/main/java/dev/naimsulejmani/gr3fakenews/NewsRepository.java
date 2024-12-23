package dev.naimsulejmani.gr3fakenews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByCategory(Category category);

    List<News> findAllByAuthor(String author);
}
