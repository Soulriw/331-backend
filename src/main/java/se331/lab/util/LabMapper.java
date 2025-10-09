package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    // ---- Participant mapping ----
    @Mapping(source = "eventHistory", target = "attendedEvents")
    ParticipantDTO getParticipantDto(Participant participant);
    @Mapping(source = "eventHistory", target = "attendedEvents")
    List<ParticipantDTO> getParticipantDto(List<Participant> participants);

    // ---- Event mapping ----
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);

    // ---- Organizer mapping (for OrganizerController) ----
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
}
