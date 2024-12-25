package dev.naimsulejmani.gr3fakenews.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveNewsDto {
    private long id;

    private boolean archived;
    private LocalDateTime archivedAt= LocalDateTime.now();
    @NotNull(message = "Archived by cannot be null")
    @NotBlank(message = "Archived by cannot be blank")
    private String archivedBy;
}
