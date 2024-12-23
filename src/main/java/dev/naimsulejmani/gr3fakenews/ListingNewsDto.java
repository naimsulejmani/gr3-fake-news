package dev.naimsulejmani.gr3fakenews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingNewsDto {
    private long id;
    private String title;
    private String photoUrl;
    private String category;
}
