package se331.lab.entity;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {
    Long id;
    String name;
    String telNo;
    List<EventDTO> attendedEvents; // ✅ must match the target field name
}
