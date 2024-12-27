package dev.naimsulejmani.gr3fakenews.repositories;

import dev.naimsulejmani.gr3fakenews.models.Category;
import dev.naimsulejmani.gr3fakenews.models.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements Runnable {
    private final NewsRepository newsRepository;

    @Override
    public void run() {

        if (newsRepository.count() == 0) {
            News news = new News();
            news.setTitle("Barca ekip i endrave!");
            news.setDescription("Barcelona eshte ekip i endrave per cdo lojtar mesatar te futbollit te Kosoves!");
            news.setUrlToImage("https://www.fcbarcelona.com/photo-resources/2021/09/14/1b4b3b7b-7b7b-4b3b-8b7b-7b4b3b7b4b3b/2021-09-14-NOTICIA-PORTADA-FCB-PSG.jpg?width=1200&height=750");
            news.setUrl("https://www.fcbarcelona.com/en/football/first-team/news/2246827/psg-1-1-fc-barcelona-a-point-in-paris");
            news.setAuthor("Arvanit Barcelonisti");
            news.setCategory(Category.ENTERTAINMENT);
            news.setCreatedAt(LocalDateTime.now());
            news.setPublishedAt(LocalDateTime.now());
            news.setCreatedBy("fake-arvaniti");
            newsRepository.save(news);
        }
    }
}
