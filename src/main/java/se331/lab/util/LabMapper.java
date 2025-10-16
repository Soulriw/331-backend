package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.Event;
import se331.lab.entity.EventDTO;
import se331.lab.entity.Organizer;
import se331.lab.entity.OrganizerDTO;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer); // ✅ NEW single object
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
}
