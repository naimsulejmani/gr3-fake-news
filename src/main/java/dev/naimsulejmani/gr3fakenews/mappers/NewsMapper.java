package dev.naimsulejmani.gr3fakenews.mappers;

import dev.naimsulejmani.gr3fakenews.dtos.ListingNewsDto;
import dev.naimsulejmani.gr3fakenews.dtos.NewsDto;
import dev.naimsulejmani.gr3fakenews.models.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;

import java.util.List;

//Nese ju qet problem me perdore @Qualifier
//@Primary
@Mapper(componentModel = "spring")
public interface NewsMapper extends SimpleMapper<News, NewsDto> {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "urlToImage", target = "photoUrl")
    ListingNewsDto toListingNewsDto(News news);

    List<ListingNewsDto> toListingNewsDtoList(List<News> newsList);

    List<NewsDto> toDtoList(List<News> newsList);

    @Override
//    @Mapping(source = "urlToImage", target = "photoUrl")
    NewsDto toDto(News news);

}








