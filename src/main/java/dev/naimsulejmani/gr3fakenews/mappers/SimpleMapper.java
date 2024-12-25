package dev.naimsulejmani.gr3fakenews.mappers;

public interface SimpleMapper<TEntity, TDto> {
    TEntity toEntity(TDto dto);

    TDto toDto(TEntity entity);
}