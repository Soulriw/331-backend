package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.entity.Participant;
import se331.lab.repository.ParticipantRepository;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantRepository participantRepository;

    @Override
    public Page<Participant> getParticipants(Pageable pageable) {
        return participantRepository.findAll(pageable);
    }
}
