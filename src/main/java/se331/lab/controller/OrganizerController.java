package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizerService;
import se331.lab.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("/organizers")
    ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(
                LabMapper.INSTANCE.getOrganizerDTO(organizerService.getAllOrganizer())
        );
    }

    @GetMapping("/organizers/{id}") // ✅ ADD THIS
    ResponseEntity<?> getOrganizerById(@PathVariable Long id) {
        Organizer organizer = organizerService.getOrganizerById(id);
        if (organizer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizer));
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer) {
        Organizer saved = organizerService.save(organizer);
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(saved));
    }
}
