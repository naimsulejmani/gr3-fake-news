package dev.naimsulejmani.gr3fakenews;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, length = 50_000)
    private String description;

    @Column(length = 500)
    private String url;

    @Column(length = 500)
    private String urlToImage;

    @Column(length = 200, nullable = false)
    private String author;

    @Column(nullable = false)
    private String publishedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, length = 50)
    private String createdBy;

    private LocalDateTime modifiedAt;
    @Column(length = 50)
    private String modifiedBy;

    private boolean archived;
    private LocalDateTime archivedAt;
    @Column(length = 50)
    private String archivedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Category category;
}
