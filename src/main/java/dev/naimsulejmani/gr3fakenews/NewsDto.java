package dev.naimsulejmani.gr3fakenews;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    @PositiveOrZero(message = "Id must be positive or zero")
    private long id;

    @NotNull(message = "Title must not be null")
    @NotBlank(message = "Title must not be blank")
    @Size(max = 500, message = "Title must be at most 500 characters long")
    private String title;

    @NotNull(message = "Description must not be null")
    @NotBlank(message = "Description must not be blank")
    @Size(max = 50_000, message = "Description must be at most 50,000 characters long")
    private String description;

    @Size(max = 500, message = "Url must be at most 500 characters long")
    private String url;

    @Size(max = 500, message = "Url to image must be at most 500 characters long")
    private String urlToImage;

    @NotNull(message = "Author must not be null")
    @NotBlank(message = "Author must not be blank")
    @Size(max = 200, message = "Author must be at most 200 characters long")
    private String author;

    @NotNull(message = "Published at must not be null")
    @PastOrPresent(message = "Published at must be in the past or present")
    private String publishedAt;


    private LocalDateTime createdAt = LocalDateTime.now();


    private String createdBy;

    private LocalDateTime modifiedAt;

    private String modifiedBy;

    private boolean archived;
    private LocalDateTime archivedAt;
    private String archivedBy;

    @NotNull(message = "Category must not be null")
    private Category category;
}
