package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.Event;
import se331.lab.entity.EventDTO;
import se331.lab.entity.Organizer;
import se331.lab.entity.OrganizerDTO;
import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    @Mapping(target = "images", source = "images") // ✅ Explicitly include this
    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
}
