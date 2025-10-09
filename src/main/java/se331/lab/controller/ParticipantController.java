package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Participant;
import se331.lab.repository.ParticipantRepository;
import se331.lab.util.LabMapper;

@RestController       // ✅ must be this (not @Controller)
@RequiredArgsConstructor
@RequestMapping("/participants") // ✅ optional but helps grouping
public class ParticipantController {
    private final ParticipantRepository participantRepository;

    @GetMapping("")
    public ResponseEntity<?> getParticipants(
            @RequestParam(value = "_limit", required = false, defaultValue = "10") Integer perPage,
            @RequestParam(value = "_page", required = false, defaultValue = "1") Integer page
    ) {
        Pageable pageable = PageRequest.of(page - 1, perPage);
        Page<Participant> participants = participantRepository.findAll(pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-total-count", String.valueOf(participants.getTotalElements()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(LabMapper.INSTANCE.getParticipantDto(participants.getContent()));
    }
}
