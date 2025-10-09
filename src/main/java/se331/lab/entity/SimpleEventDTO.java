package se331.lab.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleEventDTO {
    Long id;
    String title;
}
