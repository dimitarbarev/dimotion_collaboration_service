package org.example.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private String title;
    private String datetime; // Use ISO format (can convert to LocalDateTime)
    private Long teamId;
}
