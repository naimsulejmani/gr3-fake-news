package dev.naimsulejmani.gr3fakenews.services.impls;

import dev.naimsulejmani.gr3fakenews.dtos.ArchiveNewsDto;
import dev.naimsulejmani.gr3fakenews.dtos.NewsDto;
import dev.naimsulejmani.gr3fakenews.mappers.NewsMapper;
import dev.naimsulejmani.gr3fakenews.models.Category;
import dev.naimsulejmani.gr3fakenews.models.News;
import dev.naimsulejmani.gr3fakenews.repositories.NewsRepository;
import dev.naimsulejmani.gr3fakenews.services.NewsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository repository;
    private final NewsMapper mapper;

    @Override
    public List<NewsDto> findAllByCategory(Category category) {
        var newsList = repository.findAllByCategory(category);
        return mapper.toDtoList(newsList);
    }

    @Override
    public List<NewsDto> findAllByAuthor(String author) {
        var newList = repository.findAllByAuthor(author);
        return mapper.toDtoList(newList);
    }

    @Override
    public NewsDto archive(long id, ArchiveNewsDto archiveNewsDto) {
        if (id != archiveNewsDto.getId()) {
            throw new IllegalArgumentException("Id mismatch");
        }

        var optionalNews = repository.findById(id);
        if (optionalNews.isEmpty()) {
            throw new EntityNotFoundException("News with id " + id + " not found");
        }
        News news = optionalNews.get();
        news.setArchived(archiveNewsDto.isArchived());
        news.setArchivedBy(archiveNewsDto.getArchivedBy());
        news.setArchivedAt(archiveNewsDto.getArchivedAt());
        repository.save(news);

        return mapper.toDto(news);
    }

    @Override
    public List<NewsDto> findAll() {
        var newList = repository.findAll();
        return mapper.toDtoList(newList);
    }

    @Override
    public NewsDto findById(Long id) {
        var news = repository.findById(id);

        if (news.isEmpty()) {
            throw new EntityNotFoundException("News with id " + id + " not found");
        }
        if (news.get().isArchived()) {
            throw new EntityNotFoundException("News with id " + id + " is archived");
        }

        return mapper.toDto(news.get());
    }

    @Override
    public NewsDto add(NewsDto dto) {
        var entity = mapper.toEntity(dto);
        var savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Transactional
    @Override
    public NewsDto modify(Long id, NewsDto dto) {

        if (id != dto.getId()) {
            throw new IllegalArgumentException("Id mismatch");
        }

        var exists = repository.existsById(id);
        if (!exists) {
            throw new EntityNotFoundException("News with id " + id + " not found");
        }
//        var oldEntity = repository.findById(id).get();


        var entity = mapper.toEntity(dto);
        var savedEntity = repository.save(entity);

        return mapper.toDto(savedEntity);
    }

    @Override
    public void removeById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("News with id " + id + " not found");
        }

        repository.deleteById(id);
    }
}












