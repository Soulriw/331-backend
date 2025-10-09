package se331.lab.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantSimpleDTO {
    Long id;
    String name;
}
