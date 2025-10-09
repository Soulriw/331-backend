package se331.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Participant;

public interface ParticipantService {
    Page<Participant> getParticipants(Pageable pageable);
}
