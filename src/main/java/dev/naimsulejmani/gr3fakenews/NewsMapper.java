package dev.naimsulejmani.gr3fakenews;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface NewsMapper extends SimpleMapper<News, NewsDto> {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "urlToImage", target = "photoUrl")
    ListingNewsDto toListingNewsDto(News news);

    List<ListingNewsDto> toListingNewsDtoList(List<News> newsList);

    List<NewsDto> toDtoList(List<News> newsList);

}








